package pl.kursy.filtry.zadanie.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class ResponseAddIDFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        resp.addHeader("REQUEST_ID", UUID.randomUUID().toString());

        filterChain.doFilter(servletRequest,servletResponse);

        resp.copyBodyToResponse();


    }
}
