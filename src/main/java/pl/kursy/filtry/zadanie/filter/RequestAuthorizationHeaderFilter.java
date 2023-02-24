package pl.kursy.filtry.zadanie.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import pl.kursy.filtry.zadanie.exception.AuthorizationException;

import java.io.IOException;

@Slf4j
public class RequestAuthorizationHeaderFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        try {

            if (req.getHeader("Authorization").isEmpty()) {

                throw new AuthorizationException();

            } else {

                log.info("Access granted");
                resp.setStatus(HttpServletResponse.SC_OK);

            }

        }catch (AuthorizationException e){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied, cause wrong authorization value");
        }catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No Authorization header");
        }

        filterChain.doFilter(req, resp);

    }

}

