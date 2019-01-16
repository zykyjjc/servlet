package com.yk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by 不器 on 2018/12/24.
 */
public class GetPostServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        String name1=req.getParameter("name1");
        String pw1=req.getParameter("pw1");
        //out.println("<HTML>");
        //out.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
        //out.println("<BODY>");
        out.println("调用doGet方法");
        out.println("<br></br>");
        out.println("用户名："+name1);
         out.println("<br></br>");
        out.println("密码："+pw1);
        //out.println("</BODY>");
        //out.println("</HTML>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        String name2=req.getParameter("name2");
        String pw2=req.getParameter("pw2");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("调用doPost方法");
        out.println("<br></br>");
        out.println("用户名："+name2);
        out.println("<br></br>");
        out.println("密码："+pw2);
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }


}
