package main.java.com.springtutorial.jba.servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValuesFeeder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TreeMap<String, Object> values = main.java.com.springtutorial.jba.monitor.logic.CurrentValues.getValues();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        Writer out = response.getWriter();
        out.write("<th>Sensor</th><th>Value</th>");
        for (Entry<String, Object> entry : values.entrySet()) {
            if (entry.getKey().contains("Value")) {
                out.write("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
            }
        }
        out.flush();
    }
}
