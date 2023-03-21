package Controller.Admin;

import ViewModel.QLChucVu;
import ViewModel.QLKhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/ChucVu/create",
             "/ChucVu/store",
            "/ChucVu/update",
         "/ChucVu/edit",
           "/ChucVu/index",
        "/ChucVu/delete"})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;

    public ChucVuServlet(){
        this.cvRepo = new ChucVuRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else{
            this.index(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else {
            this.index(request,response);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/ChucVu/create.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLChucVu cv = new QLChucVu();
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.insert(cv);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../ChucVu/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu cv = this.cvRepo.findByMa(ma);
        request.setAttribute("cv", cv);
        request.getRequestDispatcher("/Views/ChucVu/edit.jsp")
                .forward(request, response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLChucVu cv = new QLChucVu();
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.update(cv);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../ChucVu/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        QLChucVu cv = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(cv);
        response.sendRedirect("../ChucVu/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsChucVu",this.cvRepo.findAll());
        request.getRequestDispatcher("/Views/ChucVu/index.jsp").forward(request,response);
    }
}
