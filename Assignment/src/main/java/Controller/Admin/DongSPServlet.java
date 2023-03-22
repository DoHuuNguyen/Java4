package Controller.Admin;

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

import java.io.IOException;

@WebServlet({"/DongSP/create",
             "/DongSP/store",
            "/DongSP/update",
         "/DongSP/edit",
           "/DongSP/index",
        "/DongSP/delete"})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongRepo;

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
        request.setAttribute("view","/Views/DongSP/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLDongSP dong = new QLDongSP();
            BeanUtils.populate(dong, request.getParameterMap());
            this.dongRepo.insert(dong);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../DongSP/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP dong = this.dongRepo.findByMa(ma);
        request.setAttribute("dong", dong);
        request.setAttribute("view","/Views/DongSP/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLDongSP dong = new QLDongSP();
            BeanUtils.populate(dong, request.getParameterMap());
            this.dongRepo.update(dong);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../DongSP/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        QLDongSP cv = this.dongRepo.findByMa(ma);
        this.dongRepo.delete(cv);
        response.sendRedirect("../DongSP/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsDongSP",this.dongRepo.findAll());
        request.setAttribute("view","/Views/DongSP/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
}
