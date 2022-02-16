package controller;

import model.MatBang;
import service.IMatBangService;
import service.impl.MatBangService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PrivateKey;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet",urlPatterns = "/tcomplex")
public class Servlet extends HttpServlet {
    private IMatBangService iMatBangService = new MatBangService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createMatBangThue(request, response);
                    break;
                case "edit":
                    //updateService(request, response);
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
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteService(request, response);
//                    break;
//                case "search":
//                    searchService(request, response);
//                    break;
                default:
                    homePage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void createMatBangThue(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String ma_mat_bang = request.getParameter("ma_mat_bang");
        int dien_tich = Integer.parseInt(request.getParameter("dien_tich"));
        String trang_thai = request.getParameter("trang_thai");
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loai_van_phong = request.getParameter("loai_van_phong");
        String mo_ta = request.getParameter("mo_ta");
        Double gia_thue = Double.parseDouble(request.getParameter("gia_thue"));
        String ngay_bat_dau = request.getParameter("ngay_bat_dau");
        String ngay_ket_thuc = request.getParameter("ngay_ket_thuc");

        MatBang matBang = new MatBang(ma_mat_bang, dien_tich, trang_thai, tang, loai_van_phong,
                mo_ta, gia_thue, ngay_bat_dau, ngay_ket_thuc);

        Map<String, String> map = iMatBangService.createMatBangThue(matBang);
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("tcomplex/create.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/tcomplex");
        }
//        iMatBangService.createMatBangThue(matBang);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("tcomplex/create.jsp");
//        dispatcher.forward(request, response);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<MatBang> matBangList = iMatBangService.selectAllMatBang();

        request.setAttribute("matBangList", matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tcomplex/create.jsp");
        dispatcher.forward(request, response);
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<MatBang> matBangList = iMatBangService.selectAllMatBang();

        request.setAttribute("matBangList", matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tcomplex/list.jsp");
        dispatcher.forward(request, response);
    }
}
