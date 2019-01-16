package com.yk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by 不器 on 2018/12/26.
 */
public class UserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init method");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }



    protected void process(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");
        RequestDispatcher dispatcher=null;
        HttpSession session=req.getSession();
        String name= (String) session.getAttribute("userName");
        String pwd= (String) session.getAttribute("password");
        session.setMaxInactiveInterval(2*60);
        //session.invalidate();
        if(name!=null&&pwd!=null){
            System.out.println("Second sign");
            session.removeAttribute("userName");
            session.removeAttribute("password");
        }
        session.setAttribute("userName",userName);
        session.setAttribute("password",password);
        Cookie userNameCookie=new Cookie("userName",userName);
        Cookie passwordCookie=new Cookie("password",password);
        userNameCookie.setMaxAge(20*60);
        passwordCookie.setMaxAge(20*60);
        resp.addCookie(userNameCookie);
        resp.addCookie(passwordCookie);

        Cookie[] cookies=req.getCookies();
        if(cookies!=null){

            for (Cookie cookie:cookies){
                if(cookie.getName().equals("userName")){
                    userName=cookie.getValue();
                }
                if(cookie.getName().equals("password")){
                    password=cookie.getValue();
                    System.out.println("here");
                }
            }
        }
        try {
            if(userName.equals("123")&&password.equals("456")){
                PrintWriter out=resp.getWriter();
                out.println("<html>");
                out.println("<head><title>用户中心</title></head>");
                out.println("<body>");
                out.println("<p>userName:"+userName+"</p>");
                out.println("<p>password:"+password+"</p>");
                out.println("</body>");
                out.println("<html>");
                resp.setContentType("text/html;charset=GBK");
                out.close();
            }else {
                dispatcher=req.getRequestDispatcher("error.jsp");
                dispatcher.forward(req,resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
