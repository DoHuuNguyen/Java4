package Controller.Admin;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import ViewModel.QLKhachHang;
import ViewModel.QLNhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.NhanVienRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/NhanVien/create",
        "/NhanVien/store",
"/NhanVien/delete","/NhanVien/edit","/NhanVien/index","/NhanVien/update"})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    public NhanVienServlet(){
        this.nvRepo = new NhanVienRepository();
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
        request.setAttribute("listChucVu",nvRepo.getAllChucVu());
        request.setAttribute("listCuaHang",nvRepo.getAllCuaHang());
        request.setAttribute("view","/Views/NhanVien/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        try {

            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.insert(nv);
        }catch (Exception e){
            e.printStackTrace();
        }
        String maCuaHang = request.getParameter("maCuaHang");
        String maChucVu = request.getParameter("maChucVu");
        CuaHang cuaHang = nvRepo.findCuaHangByMa(maCuaHang);
        ChucVu chucVu = nvRepo.findChucVuByMa(maChucVu);
        nv.setChucVu(chucVu);
        nv.setCuaHang(cuaHang);
        response.sendRedirect("../NhanVien/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsnv",this.nvRepo.findAll());
        request.setAttribute("view","/Views/NhanVien/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String ma = req.getParameter("ma");
        System.out.println(ma);
        NhanVien nv = this.nvRepo.findByMa(ma);
        this.nvRepo.delete(nv);
        resp.sendRedirect("../NhanVien/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nvRepo.findByMa(ma);
        request.setAttribute("listChucVu",nvRepo.getAllChucVu());
        request.setAttribute("listCuaHang",nvRepo.getAllCuaHang());
        request.setAttribute("nv", nv);
        request.setAttribute("view","/Views/NhanVien/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            String ma = request.getParameter("ma");
            NhanVien nv = this.nvRepo.findByMa(ma);
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.update(nv);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../NhanVien/index");
    }
}
