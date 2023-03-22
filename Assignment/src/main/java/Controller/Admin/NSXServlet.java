package Controller.Admin;

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

import java.io.IOException;

@WebServlet({"/NhaSanXuat/create",
             "/NhaSanXuat/store",
            "/NhaSanXuat/update",
         "/NhaSanXuat/edit",
           "/NhaSanXuat/index",
        "/NhaSanXuat/delete"})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepo;

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
        request.setAttribute("view","/Views/NhaSanXuat/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhaSanXuat nsx = new QLNhaSanXuat();
            BeanUtils.populate(nsx, request.getParameterMap());
            this.nsxRepo.insert(nsx);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../NhaSanXuat/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhaSanXuat nsx = this.nsxRepo.findByMa(ma);
        request.setAttribute("nsx", nsx);
        request.setAttribute("view","/Views/NhaSanXuat/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhaSanXuat nsx = new QLNhaSanXuat();
            BeanUtils.populate(nsx, request.getParameterMap());
            this.nsxRepo.update(nsx);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../NhaSanXuat/index");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        System.out.println(ma);
        QLNhaSanXuat nsx = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(nsx);
        response.sendRedirect("../NhaSanXuat/index");
    }protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsNsx",this.nsxRepo.findAll());
        request.setAttribute("view","/Views/NhaSanXuat/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
}
