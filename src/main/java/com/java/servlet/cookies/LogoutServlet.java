package com.java.servlet.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();


        request.getRequestDispatcher("link.html").include(request, response);

        Cookie[] ck =request.getCookies();
        Cookie cookie = ck[0];
        out.println(cookie.getMaxAge());
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        out.print("you are successfully logged out!");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
