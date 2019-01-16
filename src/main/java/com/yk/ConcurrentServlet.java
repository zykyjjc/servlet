package com.yk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by 不器 on 2018/12/27.
 */
public class ConcurrentServlet extends HttpServlet {
    String name;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        synchronized (this) {
            name = req.getParameter("userName");
            PrintWriter out = resp.getWriter();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("userName:" + name);
        }
    }
}
