package Controller.Admin;

import DomainModel.SanPham;
import ViewModel.QLSanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.SanPhamRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet({"/SanPham/create",
             "/SanPham/store",
            "/SanPham/update",
         "/SanPham/edit",
           "/SanPham/index",
        "/SanPham/delete"})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;
    String error ;
    String errorTen;
    String errorMa;

    public SanPhamServlet(){
        this.spRepo = new SanPhamRepository();
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
        request.setAttribute("view","/Views/SanPham/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SanPham sp = new SanPham();
            BeanUtils.populate(sp, request.getParameterMap());
            errorTen = CheckString.checkValues(sp.getTen(),"tên");
            errorMa = CheckString.checkValues(sp.getMa(),"mã");
            SanPham cv = spRepo.findByMa(sp.getMa());
            if (cv!=null){
                error="Trùng mã";
                response.sendRedirect("/Assignment_war_exploded/SanPham/create");
                return;
            }else{
                error="";
            }

            if (!errorTen.isEmpty()||!errorMa.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/SanPham/create");
                return;
            }
            this.spRepo.insert(sp);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../SanPham/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.spRepo.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("sp", sp);
        request.setAttribute("view","/Views/SanPham/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            SanPham sp = this.spRepo.findByMa(ma);
            BeanUtils.populate(sp, request.getParameterMap());
            errorTen = CheckString.checkValues(sp.getTen(),"tên");
            if (!errorTen.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/SanPham/edit?ma="+sp.getMa());
                return;
            }
            this.spRepo.update(sp);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../SanPham/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        SanPham sp = this.spRepo.findByMa(ma);
        this.spRepo.delete(sp);
        response.sendRedirect("../SanPham/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsSanPham",this.spRepo.findAll());
        request.setAttribute("view","/Views/SanPham/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
}
