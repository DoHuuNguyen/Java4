package Controller.Admin;

import DomainModel.*;
import ViewModel.QLChiTietSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSanPhamRepository;
import utils.CheckString;

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
        request.setAttribute("listNSX", ctspRepo.getAllNSX());
        request.setAttribute("listSanPham", ctspRepo.getAllSanPham());
        request.setAttribute("listDongSP", ctspRepo.getAllDongSP());
        request.setAttribute("listMauSac", ctspRepo.getAllMauSac());
        request.setAttribute("view","/Views/ChiTietSanPham/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSP ctsp = new ChiTietSP();
        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
            this.ctspRepo.insert(ctsp);
        }catch (Exception e){
            e.printStackTrace();
        }
        String maSanPham = request.getParameter("maSanPham");
        String maNSX = request.getParameter("maNSX");
        String maDongSP = request.getParameter("maDongSP");
        String maMauSac = request.getParameter("maMauSac");
        SanPham sanPham = ctspRepo.findMaSanPham(maSanPham);
        NSX nsx = ctspRepo.findMaNSX(maNSX);
        DongSP dongSP = ctspRepo.findMaDongSP(maDongSP);
        MauSac mauSac = ctspRepo.findMaMauSac(maMauSac);
        ctsp.setSanPham(sanPham);
        ctsp.setDongSP(dongSP);
        ctsp.setMauSac(mauSac);
        ctsp.setNsx(nsx);
        response.sendRedirect("../ChiTietSanPham/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsctsp",this.ctspRepo.findAll());
        request.setAttribute("view","/Views/ChiTietSanPham/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String idSP = req.getParameter("id");
        System.out.println(idSP);
        ChiTietSP kh = this.ctspRepo.findByID(idSP);
        this.ctspRepo.delete(kh);
        resp.sendRedirect("../ChiTietSanPham/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("listNSX", ctspRepo.getAllNSX());
        request.setAttribute("listSanPham", ctspRepo.getAllSanPham());
        request.setAttribute("listDongSP", ctspRepo.getAllDongSP());
        request.setAttribute("listMauSac", ctspRepo.getAllMauSac());
        ChiTietSP ctsp = this.ctspRepo.findByID(id);
        request.setAttribute("ctsp", ctsp);
        request.setAttribute("view","/Views/ChiTietSanPham/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("id");
            ChiTietSP ctsp = this.ctspRepo.findByID(ma);
            BeanUtils.populate(ctsp, request.getParameterMap());
            String maSanPham = request.getParameter("maSanPham");
            String maNSX = request.getParameter("maNSX");
            String maDongSP = request.getParameter("maDongSP");
            String maMauSac = request.getParameter("maMauSac");
            SanPham sanPham = ctspRepo.findMaSanPham(maSanPham);
            NSX nsx = ctspRepo.findMaNSX(maNSX);
            DongSP dongSP = ctspRepo.findMaDongSP(maDongSP);
            MauSac mauSac = ctspRepo.findMaMauSac(maMauSac);
            ctsp.setSanPham(sanPham);
            ctsp.setDongSP(dongSP);
            ctsp.setMauSac(mauSac);
            ctsp.setNsx(nsx);
            this.ctspRepo.update(ctsp);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("../ChiTietSanPham/index");
    }
}
