package controller;

import model.Calculator;
import service.ICalculatorService;
import service.impl.CalculatorService;

import java.io.IOException;
import java.rmi.AccessException;

@javax.servlet.annotation.WebServlet(name = "/calculate", urlPatterns = "/calculate")

public class Servlet extends javax.servlet.http.HttpServlet {
    private ICalculatorService iCalculatorService = new CalculatorService();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       try{
           float firstNumber = Float.parseFloat(request.getParameter("firstNumber"));
           float secondNumber = Float.parseFloat(request.getParameter("secondNumber"));
           String calculatorOperator = request.getParameter("operator");
           float result = 0;
           Calculator calculator = new Calculator(firstNumber,secondNumber);
           request.setAttribute("a",firstNumber);
           request.setAttribute("b",secondNumber);


               switch (calculatorOperator){
                   case "addition":
                       request.setAttribute("operator", "+");
                       result = iCalculatorService.calculatorAdd(firstNumber,secondNumber);
                       request.setAttribute("result", result);
                       break;
                   case "subtraction":
                       request.setAttribute("operator", "-");
                       result = iCalculatorService.calculatorSub(firstNumber,secondNumber);
                       request.setAttribute("result",result);
                       break;
                   case "multiplication":
                       request.setAttribute("operator", "*");
                       result = iCalculatorService.calculatorMulti(firstNumber,secondNumber);
                       request.setAttribute("result",result);
                       break;
                   case "division":
                       request.setAttribute("operator", "/");
                       result = iCalculatorService.calculatorDiv(firstNumber,secondNumber);
                       request.setAttribute("result",result);
                       break;
               }
               request.getRequestDispatcher("/calculate.jsp").forward(request,response);

       }catch (Exception e) {
           request.setAttribute("err", "Is emty ");
           request.getRequestDispatcher("/index.jsp").forward(request, response);
       }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }
}
