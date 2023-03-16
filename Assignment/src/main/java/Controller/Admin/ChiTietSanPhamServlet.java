package Controller.Admin;

import ViewModel.QLChiTietSP;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/ChiTietSanPham/create","/ChiTietSanPham/store","/ChiTietSanPham/index"})
public class ChiTietSanPhamServlet extends HttpServlet {
    ArrayList<QLChiTietSP> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            //this.edit();
        }else if(uri.contains("delete")){
            //
        }else {
            this.index(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.store(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/ChiTietSanPham/create.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QLChiTietSP ctsp = new QLChiTietSP();
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
