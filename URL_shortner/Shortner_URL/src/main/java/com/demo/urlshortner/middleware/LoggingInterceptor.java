package com.demo.urlshortner.middleware;
import com.demo.urlshortner.service.ServiceLog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoggingInterceptor {

    private final ServiceLog logService;

    public LoggingInterceptor(ServiceLog logService) {
        this.logService = logService;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String logMsg = method + " request received for " + uri;

        logService.sendLog("INFO", "LoggingInterceptor", logMsg);
        return true;
    }
}


