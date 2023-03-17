package Controller.Admin;

import ViewModel.QLChiTietSP;
import ViewModel.QLKhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChiTietSanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/ChiTietSanPham/create",
        "/ChiTietSanPham/store",
        "/ChiTietSanPham/index",
        "/ChiTietSanPham/edit",
        "/ChiTietSanPham/delete"})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamRepository ctsp;

    public ChiTietSanPhamServlet(){
        this.ctsp = new ChiTietSanPhamRepository();
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
        this.store(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/ChiTietSanPham/create.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSP = request.getParameter("idSP");
        String tenSp = request.getParameter("tenSp");
        String idNSX = request.getParameter("idNSX");
        String idMauSac = request.getParameter("idMauSac");
        String idDongSP = request.getParameter("idDongSP");
        int namBh = Integer.parseInt(request.getParameter("namBh"));
        String moTa = request.getParameter("moTa");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
        double giaBan = Double.parseDouble(request.getParameter("giaBan"));

        QLChiTietSP ctsp = new QLChiTietSP(idSP,tenSp,idNSX,idMauSac,idDongSP,namBh,moTa,soLuong,giaNhap,giaBan);
        this.ctsp.insert(ctsp);
        response.sendRedirect("../ChiTietSanPham/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsctsp",this.ctsp.findAll());
        request.getRequestDispatcher("/Views/ChiTietSanPham/index.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String idSP = req.getParameter("idSP");
        System.out.println(idSP);
        QLChiTietSP kh = this.ctsp.findByMa(idSP);
        this.ctsp.delete(kh);
        resp.sendRedirect("../ChiTietSanPham/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSP = request.getParameter("idSP");
        QLChiTietSP kh = this.ctsp.findByMa(idSP);
        request.setAttribute("kh", kh);
        request.getRequestDispatcher("/Views/ChiTietSanPham/edit.jsp")
                .forward(request, response);
    }
}
