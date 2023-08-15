package com.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FormServlet",value = "/calculateServlet")
public class FormServlet extends HttpServlet {

    public void init() {

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        try {
            double bmi = calculateBMI(
                    Double.parseDouble(weight),
                    Double.parseDouble(height));

            request.setAttribute("bmi", bmi);
            response.setHeader("Test", "Success");
            response.setHeader("BMI", String.valueOf(bmi));

            request.getRequestDispatcher("form.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

    public void destroy() {
    }
}
