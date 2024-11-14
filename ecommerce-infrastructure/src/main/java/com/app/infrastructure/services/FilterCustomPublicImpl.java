package com.app.infrastructure.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.infrastructure.config.SecurityConfig;
import com.app.infrastructure.interfaces.FilterCustomPublic;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterCustomPublicImpl extends OncePerRequestFilter implements FilterCustomPublic {

    @Value("${api.security.x-api-key}")
    private String xApiSecurity;
    @Value("${api.prefix.route}")
    private String prefixUri;

    private final String REQUEST_HEADER_KEY = "x-api-key";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // String requestUri = request.getRequestURI();
        // if (isPublicRouter(requestUri)) {
        //     String xApi = request.getHeader(REQUEST_HEADER_KEY);
        //     if(!xApiSecurity.equals(xApi)){
        //         response.sendError(HttpStatus.FORBIDDEN.value(),"Access Denied: Invalid or Missing Header");
        //         return;
        //     }
        // }

        filterChain.doFilter(request, response);
    }

    @Override
    public boolean isPublicRouter(String uri) {
        if(uri.startsWith("/swagger-ui") || uri.startsWith("/v3/api-docs")){
       System.out.println(uri);

            return false;
        }
        for (String publicUri : SecurityConfig.publicRouter) {
            if(uri.startsWith(prefixUri.concat("/admin"))){
                return false;
            }
            if (uri.startsWith(publicUri.replace("/**", ""))) {
                {
                    return true;
                }
            }
        }
        return false;
    }

}
