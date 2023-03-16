package Controller.Admin;

import ViewModel.QLKhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.KhachHangRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/KhachHang/create","/KhachHang/store","/KhachHang/index","/KhachHang/delete","/KhachHang/edit"})
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
        this.store(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/KhachHang/create.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
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
        this.khRepo.insert(kh);
        response.sendRedirect("../KhachHang/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsKhachHang",this.khRepo.findAll());
        request.getRequestDispatcher("/Views/KhachHang/index.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String ma = req.getParameter("ma");
        QLKhachHang kh = this.khRepo.findByMa(ma);
        this.khRepo.delete(kh);
        resp.sendRedirect("../KhachHang/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang kh = this.khRepo.findByMa(ma);
        request.setAttribute("kh", kh);
        request.getRequestDispatcher("/Views/KhachHang/edit.jsp")
                .forward(request, response);
    }
}
