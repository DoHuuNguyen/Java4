package Controller.Admin;

import DomainModel.ChucVu;
import DomainModel.MauSac;
import ViewModel.QLChucVu;
import ViewModel.QLMauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import repository.MauSacRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet({"/MauSac/create",
             "/MauSac/store",
            "/MauSac/update",
         "/MauSac/edit",
           "/MauSac/index",
        "/MauSac/delete"})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;
    String error ;
    String errorTen;
    String errorMa;

    public MauSacServlet(){
        this.msRepo = new MauSacRepository();
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
        request.setAttribute("view","/Views/MauSac/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MauSac ms = new MauSac();
            BeanUtils.populate(ms, request.getParameterMap());
            errorTen = CheckString.checkValues(ms.getTen(),"tên");
            errorMa = CheckString.checkValues(ms.getMa(),"mã");
            MauSac cv = msRepo.findByMa(ms.getMa());
            if (cv!=null){
                error="Trùng mã";
                response.sendRedirect("/Assignment_war_exploded/MauSac/create");
                return;
            }else{
                error="";
            }

            if (!errorTen.isEmpty()||!errorMa.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/MauSac/create");
                return;
            }
            this.msRepo.insert(ms);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../MauSac/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = this.msRepo.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("ms", ms);
        request.setAttribute("view","/Views/MauSac/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            MauSac ms = this.msRepo.findByMa(ma);
            BeanUtils.populate(ms, request.getParameterMap());
            errorTen = CheckString.checkValues(ms.getTen(),"tên");
            if (!errorTen.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/MauSac/edit?ma="+ms.getMa());
                return;
            }
            this.msRepo.update(ms);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../MauSac/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        MauSac ms = this.msRepo.findByMa(ma);
        this.msRepo.delete(ms);
        response.sendRedirect("../MauSac/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsMauSac",this.msRepo.findAll());
        request.setAttribute("view","/Views/MauSac/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
}
