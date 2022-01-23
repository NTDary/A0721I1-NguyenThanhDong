package controller;

import model.RentType;
import model.ServiceType;
import service.rent_type.IRentTypeService;
import service.rent_type.impl.RentTypeService;
import service.service.IService;
import service.service.impl.Service;
import service.service_type.IServiceTypeService;
import service.service_type.impl.ServiceTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletService", urlPatterns = "/service")
public class ServletService extends HttpServlet {
    private IService iService = new Service();
    private IServiceTypeService iServiceTypeService = new ServiceTypeService();
    private IRentTypeService iRentTypeService = new RentTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createService(request, response);
                    break;
                case "edit":
                    updateService(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    //deleteCustomer(request, response);
                    break;
                case "search":
                    //searchCustomer(request, response);
                    break;
                case "service":
                    listService(request, response);
                    break;
                default:
                    homePage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    private void updateService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int serviceId = Integer.parseInt(request.getParameter("id"));
        String serviceName = request.getParameter("name");
        int serviceArea = Integer.parseInt(request.getParameter("area"));
        Double serviceCost = Double.parseDouble(request.getParameter("cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("max_people"));
        int rentType = Integer.parseInt(request.getParameter("rent_type"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type"));
        String standardRoom = request.getParameter("room");
        String description = request.getParameter("description");
        int poolArea = Integer.parseInt(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_floor"));

        model.Service newService = new model.Service(serviceId,serviceName,serviceArea,serviceCost,serviceMaxPeople,
                rentType,serviceTypeId,standardRoom,description,poolArea,numberOfFloors);

        iService.updateService(newService);
        response.sendRedirect("/service?action=service");

    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        model.Service service = iService.selectService(id);
        List<RentType> rentTypeList = iRentTypeService.selectAllRentType();
        List<ServiceType> serviceTypeList = iServiceTypeService.selectAllServiceType();
        request.setAttribute("rentType",rentTypeList);
        request.setAttribute("serviceTypeList",serviceTypeList);
        request.setAttribute("service",service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<model.Service> serviceList = iService.selectAllService();
        List<ServiceType> serviceTypeList = iServiceTypeService.selectAllServiceType();
        List<RentType> rentTypeList = iRentTypeService.selectAllRentType();

        request.setAttribute("serviceList",serviceList);
        request.setAttribute("serviceTypeList",serviceTypeList);
        request.setAttribute("rentTypeList",rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
    }
    private void listService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = iService.getTotalService();
        int endPage = count/3;
        if(count % 3 != 0){
            endPage++;
        }
        List<model.Service> serviceList = iService.pagingService(index);
        request.setAttribute("endP", endPage);
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/service.jsp");
        dispatcher.forward(request, response);
    }
    private void createService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int serviceId = Integer.parseInt(request.getParameter("id"));
        String serviceName = request.getParameter("name");
        int serviceArea = Integer.parseInt(request.getParameter("area"));
        Double serviceCost = Double.parseDouble(request.getParameter("cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("max_people"));
        int rentType = Integer.parseInt(request.getParameter("rent_type"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type"));
        String standardRoom = request.getParameter("room");
        String description = request.getParameter("description");
        int poolArea = Integer.parseInt(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_floor"));

        model.Service newService = new model.Service(serviceId,serviceName,serviceArea,serviceCost,serviceMaxPeople,
                rentType,serviceTypeId,standardRoom,description,poolArea,numberOfFloors);

        Map<String,String> map = iService.createService(newService);
        if(!map.isEmpty()){
            for(Map.Entry<String,String> entry : map.entrySet()){
                request.setAttribute(entry.getKey(),entry.getValue());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("/service?action=service");
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
    }
}
