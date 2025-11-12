package com.ecommerce.Ecommerce.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.Ecommerce.service.JWTService;
import com.ecommerce.Ecommerce.service.MyUserDetailsService;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String email = null;

        // 🔍 STEP 1: Log incoming header
        System.out.println("\n[JwtFilter] Incoming request: " + request.getRequestURI());
        System.out.println("[JwtFilter] Authorization header: " + authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            try {
                email = jwtService.extractUserEmail(token);
                System.out.println("[JwtFilter] Extracted email from token: " + email);
            } catch (Exception e) {
                System.out.println("[JwtFilter] ❌ Failed to extract email: " + e.getMessage());
            }
        } else {
            System.out.println("[JwtFilter] ⚠️ No Bearer token found.");
        }

        // 🔍 STEP 2: Validate and set security context
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(email);
                boolean isValid = jwtService.validateToken(token, userDetails);

                System.out.println("[JwtFilter] Token validation result: " + isValid);

                if (isValid) {
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    System.out.println("[JwtFilter] ✅ Authenticated user: " + email);
                } else {
                    System.out.println("[JwtFilter] ❌ Token validation failed for user: " + email);
                }

            } catch (Exception e) {
                System.out.println("[JwtFilter] ❌ Exception during user validation: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Continue request
        filterChain.doFilter(request, response);
    }
}
