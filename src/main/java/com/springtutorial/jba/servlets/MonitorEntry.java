package main.java.com.springtutorial.jba.servlets;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.springtutorial.jba.monitor.logic.CurrentValues;

public class MonitorEntry extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        TreeMap<String, Object> AIDA_READS = CurrentValues.getValues();
        request.setAttribute("values", AIDA_READS);
        ServletContext sc = getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/WEB-INF/jsp/aidaMonitor.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            System.err.println("aici 111");
        } catch (IOException e) {
            System.err.println("aici 222");
        }
    }

}
