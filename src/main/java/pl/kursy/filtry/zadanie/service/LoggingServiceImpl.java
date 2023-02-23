package pl.kursy.filtry.zadanie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoggingServiceImpl implements LoggingService {

    @Override
    public void logRequest(HttpServletRequest httpServletRequest) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("REQUEST ");
        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
        stringBuilder.append("headers=[").append(buildHeadersMap(httpServletRequest)).append("] ");


        log.info(stringBuilder.toString());

    }

    @Override
    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("RESPONSE ");
        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");
        stringBuilder.append("responseHeaders=[").append(buildHeadersMap(httpServletResponse)).append("] ");
        stringBuilder.append("responseBody=[").append(body.toString()).append("] ");

        log.info(stringBuilder.toString());
    }

    private Map<String, String> buildHeadersMap(HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    private Map<String, String> buildHeadersMap(HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();

        Collection<String> headerNames = response.getHeaderNames();
        for (String header : headerNames) {
            map.put(header, response.getHeader(header));
        }

        return map;
    }
}
