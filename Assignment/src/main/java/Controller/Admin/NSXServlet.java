package Controller.Admin;

import DomainModel.ChucVu;
import DomainModel.NSX;
import ViewModel.QLNhaSanXuat;
import ViewModel.QLSanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.NSXRepository;
import repository.SanPhamRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet({"/NhaSanXuat/create",
             "/NhaSanXuat/store",
            "/NhaSanXuat/update",
         "/NhaSanXuat/edit",
           "/NhaSanXuat/index",
        "/NhaSanXuat/delete"})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepo;
    String error ;
    String errorTen;
    String errorMa;

    public NSXServlet(){
        this.nsxRepo = new NSXRepository();
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
    //test

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
        request.setAttribute("view","/Views/NhaSanXuat/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NSX nsx = new NSX();
            BeanUtils.populate(nsx, request.getParameterMap());
            errorTen = CheckString.checkValues(nsx.getTen(),"tên");
            errorMa = CheckString.checkValues(nsx.getMa(),"mã");
            NSX cv = nsxRepo.findByMa(nsx.getMa());
            if (cv!=null){
                error="Trùng mã";
                response.sendRedirect("/Assignment_war_exploded/NhaSanXuat/create");
                return;
            }else{
                error="";
            }

            if (!errorTen.isEmpty()||!errorMa.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/NhaSanXuat/create");
                return;
            }
            this.nsxRepo.insert(nsx);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../NhaSanXuat/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = this.nsxRepo.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("nsx", nsx);
        request.setAttribute("view","/Views/NhaSanXuat/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            NSX nsx = this.nsxRepo.findByMa(ma)
;            BeanUtils.populate(nsx, request.getParameterMap());
            errorTen = CheckString.checkValues(nsx.getTen(),"tên");
            if (!errorTen.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/NhaSanXuat/edit?ma="+nsx.getMa());
                return;
            }
            this.nsxRepo.update(nsx);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../NhaSanXuat/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        NSX nsx = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(nsx);
        response.sendRedirect("../NhaSanXuat/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsNsx",this.nsxRepo.findAll());
        request.setAttribute("view","/Views/NhaSanXuat/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
}
