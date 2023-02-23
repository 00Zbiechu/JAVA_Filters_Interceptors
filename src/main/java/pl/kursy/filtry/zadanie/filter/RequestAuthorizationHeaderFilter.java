package pl.kursy.filtry.zadanie.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import pl.kursy.filtry.zadanie.exception.AuthorizationException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Order(1)
public class RequestAuthorizationHeaderFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        ContentCachingRequestWrapper req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);


        try {

            if (req.getHeader("Authorization").isEmpty()) {

                throw new AuthorizationException();

            } else {

                log.info("Access granted");
                resp.setStatus(HttpServletResponse.SC_OK);
                filterChain.doFilter(req, resp);

            }

        }catch (AuthorizationException e){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied, cause wrong authorization value");
        }catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No Authorization header");
        }

        resp.copyBodyToResponse();
    }

}

