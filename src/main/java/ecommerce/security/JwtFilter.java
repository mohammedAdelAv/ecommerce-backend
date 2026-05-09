package ecommerce.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String path = req.getRequestURI();

        // السماح بالـ login و register و الصور
        if (path.contains("/login") ||
                path.contains("/register") ||
                path.contains("/images")) {

            chain.doFilter(request, response);
            return;
        }

        String authHeader = req.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {

                String username = jwtUtil.extractUsername(token);

                System.out.println("User: " + username);

            } catch (Exception e) {

                throw new RuntimeException("Invalid token");
            }

        } else {

            throw new RuntimeException("Unauthorized");
        }

        chain.doFilter(request, response);
    }
}