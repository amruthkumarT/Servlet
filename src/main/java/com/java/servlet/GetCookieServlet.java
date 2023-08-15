package com.java.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "GetCookieServlet", value = "/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {

    public void init () {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            Cookie[] ck =request.getCookies();
            out.println("Hello "+ck[0].getValue());

            out.println(Arrays.toString(ck));

            out.close();

        }catch(Exception e){System.out.println(e);}
    }


    public void destroy() {
    }

}
