package Controller.Admin;

import ViewModel.QLNhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/NhanVien/create","/NhanVien/store"})
public class NhanVienServlet extends HttpServlet {
    ArrayList<QLNhanVien> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.create(request,response);
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
        list.add(nv);
        System.out.println(gioiTinh);
    }
}
