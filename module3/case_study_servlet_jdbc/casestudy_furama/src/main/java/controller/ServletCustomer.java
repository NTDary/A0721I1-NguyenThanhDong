package controller;

import model.Customer;
import model.CustomerType;
import service.customer.ICustomerService;
import service.customer.impl.CustomerService;
import service.customer_type.ICustomerTypeService;
import service.customer_type.impl.CustomerTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletFurama", urlPatterns = "/customer")
public class ServletCustomer extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();
    private ICustomerTypeService iCustomerTypeService = new CustomerTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "search":
                    searchCustomer(request, response);
                    break;
                case "customer":
                    listCustomer(request, response);
                    break;
                default:
                    homePage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void searchCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String selectName = request.getParameter("txt");
        List<Customer> customerList = iCustomerService.selectCustomerByName(selectName);

        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.deleteCustomer(id);

        this.listCustomer(request,response);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");
//        dispatcher.forward(request, response);
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        int id_type = Integer.parseInt(request.getParameter("id_type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id,id_type,name,birthday,gender,id_card,
                phone,email,address);
        iCustomerService.updateCustomer(newCustomer);
        response.sendRedirect("/customer?action=customer");
    }
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id_type = Integer.parseInt(request.getParameter("id_type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id_type,name,birthday,gender,id_card,
                phone,email,address);
        iCustomerService.insertCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");
        dispatcher.forward(request, response);
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = iCustomerService.getTotalCustomer();
        int endPage = count/3;
        if(count % 3 != 0){
            endPage++;
        }
        List<Customer> customerList = iCustomerService.pagingCustomer(index);
        request.setAttribute("endP", endPage);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<CustomerType> customerTypes = iCustomerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypes",customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.selectCustomer(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }
}

