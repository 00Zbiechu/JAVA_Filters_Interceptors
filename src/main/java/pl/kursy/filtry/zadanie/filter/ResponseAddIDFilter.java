package pl.kursy.filtry.zadanie.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class ResponseAddIDFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        resp.addHeader("REQUEST_ID", UUID.randomUUID().toString());

        filterChain.doFilter(servletRequest,servletResponse);


    }
}
