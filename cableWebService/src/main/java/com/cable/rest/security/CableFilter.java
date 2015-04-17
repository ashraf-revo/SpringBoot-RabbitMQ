package com.cable.rest.security;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lombok.extern.log4j.Log4j;

import org.apache.log4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Log4j
@WebFilter("/*")
public class CableFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        try {
           
            log.info("Filter called");
            SecurityContext context = SecurityContextHolder.getContext();
            if (context != null) {
                Authentication authentication = context.getAuthentication();
                if (authentication != null && authentication.getPrincipal() != null
                        && authentication.getPrincipal() instanceof Integer) {
                	Integer sid = (Integer) authentication.getPrincipal();
                    MDC.put("SID", sid);
                    log.info("SID:"+sid);
                }
            }
        } catch (Throwable e) {
            log.error("Exception ", e);
        }
        chain.doFilter(request, response);
        MDC.clear();
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}