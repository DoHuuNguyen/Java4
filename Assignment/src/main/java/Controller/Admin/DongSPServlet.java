package Controller.Admin;

import DomainModel.ChucVu;
import DomainModel.DongSP;
import ViewModel.QLChucVu;
import ViewModel.QLDongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import repository.DongSPRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet({"/DongSP/create",
             "/DongSP/store",
            "/DongSP/update",
         "/DongSP/edit",
           "/DongSP/index",
        "/DongSP/delete"})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongRepo;
    String error ;
    String errorTen;
    String errorMa;
    public DongSPServlet(){
        this.dongRepo = new DongSPRepository();
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
        request.setAttribute("view","/Views/DongSP/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DongSP dong = new DongSP();
            BeanUtils.populate(dong, request.getParameterMap());
            errorTen = CheckString.checkValues(dong.getTen(),"tên");
            errorMa = CheckString.checkValues(dong.getMa(),"mã");
            DongSP cv = dongRepo.findByMa(dong.getMa());
            if (cv!=null){
                error="Trùng mã";
                response.sendRedirect("/Assignment_war_exploded/DongSP/create");
                return;
            }else{
                error="";
            }

            if (!errorTen.isEmpty()||!errorMa.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/DongSP/create");
                return;
            }
            this.dongRepo.insert(dong);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../DongSP/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("checkten", errorTen);
        String ma = request.getParameter("ma");
        DongSP dong = this.dongRepo.findByMa(ma);
        request.setAttribute("dong", dong);
        request.setAttribute("view","/Views/DongSP/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            DongSP dong = this.dongRepo.findByMa(ma);
            BeanUtils.populate(dong, request.getParameterMap());
            errorTen = CheckString.checkValues(dong.getTen(),"tên");
            if (!errorTen.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/DongSP/edit?ma="+dong.getMa());
                return;
            }
            this.dongRepo.update(dong);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../DongSP/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        DongSP cv = this.dongRepo.findByMa(ma);
        this.dongRepo.delete(cv);
        response.sendRedirect("../DongSP/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsDongSP",this.dongRepo.findAll());
        request.setAttribute("view","/Views/DongSP/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
}
