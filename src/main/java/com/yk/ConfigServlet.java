package com.yk;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by 不器 on 2018/12/24.
 */
public class ConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        pw.print("ConfigServlet Test");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//    }

    @Override
    public void init() throws ServletException {
//        ServletConfig config=this.getServletConfig();
//        String v1=config.getInitParameter("data1");
//        System.out.println("v1="+v1);
//        String v2=config.getInitParameter("data2");
//        System.out.println("v2="+v2);
        ServletContext context=this.getServletContext();
        String value1=context.getInitParameter("globalData1");
        String value2=context.getInitParameter("globalData2");
        System.out.println("value1="+value1+" value2="+value2);
        context.setAttribute("attribute1","321");
        context.setAttribute("attribute2","654");
    }
}
