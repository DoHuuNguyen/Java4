package Controller.Admin;

import DomainModel.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.KhachHangRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/KhachHang/create","/KhachHang/store","/KhachHang/index","/KhachHang/delete","/KhachHang/edit","/KhachHang/update"})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public KhachHangServlet() {
        this.khRepo = new KhachHangRepository();
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
        }else{
            this.index(request,response);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/Views/KhachHang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
            KhachHang kh = new KhachHang();
            BeanUtils.populate(kh, request.getParameterMap());
            this.khRepo.insert(kh);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../KhachHang/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsKhachHang",this.khRepo.findAll());
        request.setAttribute("view","/Views/KhachHang/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String ma = req.getParameter("ma");
        System.out.println(ma);
        KhachHang kh = this.khRepo.findByMa(ma);
        this.khRepo.delete(kh);
        resp.sendRedirect("../KhachHang/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khRepo.findByMa(ma);
        request.setAttribute("kh", kh);
        request.setAttribute("view","/Views/KhachHang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            KhachHang kh = new KhachHang    ();
            BeanUtils.populate(kh, request.getParameterMap());
            this.khRepo.update(kh);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../KhachHang/index");
    }
}
