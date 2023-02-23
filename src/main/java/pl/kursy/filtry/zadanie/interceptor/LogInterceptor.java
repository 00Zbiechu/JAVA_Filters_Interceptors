package pl.kursy.filtry.zadanie.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import pl.kursy.filtry.zadanie.service.LoggingService;


@Component
@RequiredArgsConstructor
public class LogInterceptor implements HandlerInterceptor {

    private final LoggingService loggingService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

            loggingService.logRequest(request);

        return true;
    }
}
