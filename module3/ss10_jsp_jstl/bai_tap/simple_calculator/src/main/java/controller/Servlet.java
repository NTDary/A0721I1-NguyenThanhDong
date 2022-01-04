package controller;

import model.Calculator;
import service.ICalculatorService;
import service.impl.CalculatorService;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "/calculate", urlPatterns = "/calculate")

public class Servlet extends javax.servlet.http.HttpServlet {
    private ICalculatorService ICalculatorService = new CalculatorService();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        float firstNumber = Float.parseFloat(request.getParameter("firstNumber"));
        float secondNumber = Float.parseFloat(request.getParameter("secondNumber"));
        String calculatorOperator = request.getParameter("operator");
        Calculator calculator = new Calculator(firstNumber,secondNumber);
        request.setAttribute("a",firstNumber);
        request.setAttribute("b",secondNumber);
        request.getRequestDispatcher("/calculate.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }
}
