package com.alevel.jeebox;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "sample-servlet", urlPatterns = "/users")
public class SampleServlet extends HttpServlet {
    private Map<String, String> userInfo = new ConcurrentHashMap<>();

    private static final Logger log = LoggerFactory.getLogger(SampleServlet.class);

    @Override
    public void init() {
        log.info(getServletName() + " initialized");
    }

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");

        responseBody.println("<h1 align=\"center\">Below you can see list of current users");
        responseBody.println("<h3 align=\"center\">Information about your IP and user agent is highlighted in bold</h3>");

        String currentIp = req.getRemoteHost();
        String userAgent = req.getHeader("User-Agent");
        userInfo.put(currentIp, userAgent);
        responseBody.println("<ul>");
        for (Map.Entry entry : userInfo.entrySet()) {
            if (entry.getKey().equals(currentIp)) {
                responseBody.println("<b>"+"<li>" + entry.getKey() + "::" + entry.getValue() + "</li>" + "</b>");
            } else responseBody.println("<li>" + entry.getKey() + "::" + entry.getValue() + "</li>");
        }
        responseBody.println("</ul>");
    }

    @Override
    public void destroy() {
        log.info(getServletName() + " destroyed");
    }
}
