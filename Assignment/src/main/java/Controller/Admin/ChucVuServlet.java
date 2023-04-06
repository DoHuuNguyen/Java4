package Controller.Admin;

import DomainModel.ChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import utils.CheckString;

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
    String error ;
    String errorTen;
    String errorMa;

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
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view","/Views/ChucVu/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu chucVu = new ChucVu();
        try {
            BeanUtils.populate(chucVu, request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(chucVu.getTen(),"tên");
        errorMa = CheckString.checkValues(chucVu.getMa(),"mã");
        ChucVu cv = cvRepo.findByMa(chucVu.getMa());
        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/Assignment_war_exploded/ChucVu/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/Assignment_war_exploded/ChucVu/create");
            return;
        }
        this.cvRepo.insert(chucVu);
        response.sendRedirect("../ChucVu/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        request.setAttribute("checkten", errorTen);
        ChucVu cv = this.cvRepo.findByMa(ma);
        request.setAttribute("cv", cv);
        request.setAttribute("view","/Views/ChucVu/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChucVu chucVu = this.cvRepo.findByMa(ma);
            BeanUtils.populate(chucVu, request.getParameterMap());
            errorTen = CheckString.checkValues(chucVu.getTen(),"tên");
            if (!errorTen.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/ChucVu/edit?ma="+chucVu.getMa());
                return;
            }
            this.cvRepo.update(chucVu);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../ChucVu/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        ChucVu cv = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(cv);
        response.sendRedirect("../ChucVu/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsChucVu",this.cvRepo.findAll());
        request.setAttribute("view","/Views/ChucVu/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
}
