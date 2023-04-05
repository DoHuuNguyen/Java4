package Controller.Admin;

import DomainModel.ChiTietSP;
import ViewModel.QLChiTietSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSanPhamRepository;

import java.io.IOException;

@WebServlet({"/ChiTietSanPham/create",
        "/ChiTietSanPham/store",
        "/ChiTietSanPham/index",
        "/ChiTietSanPham/edit",
        "/ChiTietSanPham/delete",
        "/ChiTietSanPham/update"})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamRepository ctspRepo;

    public ChiTietSanPhamServlet(){
        this.ctspRepo = new ChiTietSanPhamRepository();
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
        }else {
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
        request.setAttribute("view","/Views/ChiTietSanPham/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ChiTietSP ctsp = new ChiTietSP();
            BeanUtils.populate(ctsp, request.getParameterMap());
            this.ctspRepo.insert(ctsp);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../ChiTietSanPham/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsctsp",this.ctspRepo.findAll());
        request.setAttribute("view","/Views/ChiTietSanPham/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String idSP = req.getParameter("idSP");
        System.out.println(idSP);
        ChiTietSP kh = this.ctspRepo.findByID(idSP);
        this.ctspRepo.delete(kh);
        resp.sendRedirect("../ChiTietSanPham/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSP = request.getParameter("idSP");
        ChiTietSP ctsp = this.ctspRepo.findByID(idSP);
        request.setAttribute("ctsp", ctsp);
        request.setAttribute("view","/Views/ChiTietSanPham/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ChiTietSP ctsp = new ChiTietSP();
            BeanUtils.populate(ctsp, request.getParameterMap());
            this.ctspRepo.update(ctsp);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../ChiTietSanPham/index");
    }
}
