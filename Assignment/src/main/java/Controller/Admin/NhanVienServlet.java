package Controller.Admin;

import ViewModel.QLKhachHang;
import ViewModel.QLNhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.NhanVienRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/NhanVien/create",
        "/NhanVien/store",
"/NhanVien/delete","/NhanVien/edit","/NhanVien/index"})
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
        this.store(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/NhanVien/create.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String idCuaHang = request.getParameter("idCuaHang");
        String idChucVu = request.getParameter("idChucVu");
        String quocGia = request.getParameter("quocGia");
        String thanhPho = request.getParameter("thanhPho");

        QLNhanVien nv = new QLNhanVien(ma,ho,ten,tenDem,gioiTinh,ngaySinh,sdt,diaChi,matKhau,idChucVu,idCuaHang,quocGia,thanhPho);
        this.nvRepo.insert(nv);
        response.sendRedirect("../NhanVien/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsnv",this.nvRepo.findAll());
        request.getRequestDispatcher("/Views/NhanVien/index.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String ma = req.getParameter("ma");
        System.out.println(ma);
        QLNhanVien kh = this.nvRepo.findByMa(ma);
        this.nvRepo.delete(kh);
        resp.sendRedirect("../NhanVien/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien nv = this.nvRepo.findByMa(ma);
        request.setAttribute("nv", nv);
        request.getRequestDispatcher("/Views/NhanVien/edit.jsp")
                .forward(request, response);
    }
}
