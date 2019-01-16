package com.yk;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * created by 不器 on 2018/12/27.
 */
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init method");
        String value=filterConfig.getInitParameter("filterParam");
        System.out.println("filterParam="+value);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter doFilter method");
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpSession session=req.getSession();
        if(session.getAttribute("userName")==null){
            HttpServletResponse resp=(HttpServletResponse)servletResponse;
            resp.sendRedirect("../sign.html");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy method");
    }
}
