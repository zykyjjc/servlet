package com.yk;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by 不器 on 2018/12/25.
 */
public class ContextServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext context=this.getServletContext();
        String value1=context.getInitParameter("globalData1");
        String value2=context.getInitParameter("globalData2");
        System.out.println("value1="+value1+" value2="+value2);
        String value3= (String) context.getAttribute("attribute1");
        String value4=(String) context.getAttribute("attribute2");
        System.out.println("value3="+value3+" value4="+value4);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        pw.println("ContextServlet Test");
    }


}
