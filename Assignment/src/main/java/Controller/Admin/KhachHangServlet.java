package Controller.Admin;

import ViewModel.QLKhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/KhachHang/create","/KhachHang/store"})
public class KhachHangServlet extends HttpServlet {
    private ArrayList<QLKhachHang> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.create(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.store(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/KhachHang/create.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request,HttpServletResponse response) throws ServletException{
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String quocGia = request.getParameter("quocGia");
        String thanhPho = request.getParameter("thanhPho");

        QLKhachHang kh = new QLKhachHang(ma,ho,tenDem,ten,ngaySinh,sdt,diaChi,matKhau,quocGia,thanhPho);
        list.add(kh);

        System.out.println(ngaySinh);
    }
}
