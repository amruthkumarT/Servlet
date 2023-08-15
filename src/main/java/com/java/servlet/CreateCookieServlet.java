package com.java.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name="CreateCookieServlet", value="/creatingCookie")
public class CreateCookieServlet extends HttpServlet {

    public void init () {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("userName");
            out.print("Welcome "+n);

            Cookie ck=new Cookie("uname",n);//creating cookie object
            response.addCookie(ck);//adding cookie in the response

            //creating submit button
            out.print("<form action='GetCookieServlet' method='post'>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");

            out.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void destroy() {
    }

}
