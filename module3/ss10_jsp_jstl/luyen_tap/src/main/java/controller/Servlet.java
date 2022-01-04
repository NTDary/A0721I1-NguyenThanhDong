package controller;

import model.Customer;
import repository.ICustomer;
import service.ICustomerService;
import service.impl.CustomerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "Servlet", urlPatterns = "/customer")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    private ICustomerService iCustomerService = new CustomerService();
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Customer> customerList = iCustomerService.findAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/customer.jsp").forward(request,response);
    }
}
