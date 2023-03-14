package Controller.Admin;

import ViewModel.QLKhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/KhachHang/create","/KhachHang/store","/KhachHang/index","/KhachHang/delete"})
public class KhachHangServlet extends HttpServlet {
    private ArrayList<QLKhachHang> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            //this.edit(request,response);
        }else if(uri.contains("delete")){
            //this.delete(request,response);
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
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list.add(new QLKhachHang("PH1", "Ng", "Van", "AAA", "12/12/2020", "0123123123", "HN", "123456", "VN", "HN"));
        list.add(new QLKhachHang("PH2", "Tran", "Van", "B", "12/12/2018", "0123123423", "ND", "123456", "VN", "HN"));
        request.setAttribute("dsKhachHang",this.list);
        request.getRequestDispatcher("/Views/KhachHang/index.jsp").forward(request,response);
    }
}
