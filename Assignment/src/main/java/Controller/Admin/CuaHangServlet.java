package Controller.Admin;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import ViewModel.QLChucVu;
import ViewModel.QLCuaHang;
import ViewModel.QLKhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.CuaHangRepository;
import utils.CheckString;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/CuaHang/create", "/CuaHang/store", "/CuaHang/edit", "/CuaHang/delete", "/CuaHang/update", "/CuaHang/index"})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;
    String error;
    String errorTen;
    String errorMa;
    String errorDiaChi;

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("view", "/Views/CuaHang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang ch = new CuaHang();
        try {
            BeanUtils.populate(ch, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(ch.getTen(), "tên");
        errorMa = CheckString.checkValues(ch.getMa(), "mã");
        errorDiaChi = CheckString.checkValues(ch.getDiaChi(), "Địa Chỉ");
        CuaHang cv = chRepo.findByMa(ch.getMa());
        if (cv != null) {
            error = "Trùng mã";
            response.sendRedirect("/Assignment_war_exploded/CuaHang/create");
            return;
        } else {
            error = "";
        }

        if (!errorTen.isEmpty() || !errorMa.isEmpty()|| !errorDiaChi.isEmpty()) {
            response.sendRedirect("/Assignment_war_exploded/CuaHang/create");
            return;
        }
        this.chRepo.insert(ch);
        response.sendRedirect("../CuaHang/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.chRepo.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("ch", ch);
        request.setAttribute("view", "/Views/CuaHang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            CuaHang ch = this.chRepo.findByMa(ma);
            BeanUtils.populate(ch, request.getParameterMap());
            if (!errorTen.isEmpty()||!errorDiaChi.isEmpty()) {
                response.sendRedirect("/Assignment_war_exploded/CuaHang/edit?ma="+ch.getMa());
                return;
            }
            this.chRepo.update(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("../CuaHang/index");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        CuaHang ch = this.chRepo.findByMa(ma);
        this.chRepo.delete(ch);
        response.sendRedirect("../CuaHang/index");
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsCuaHang", this.chRepo.findAll());
        request.setAttribute("view", "/Views/CuaHang/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

}
