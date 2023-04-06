package Controller.Admin;

import DomainModel.DongSP;
import DomainModel.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.KhachHangRepository;
import utils.CheckString;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/KhachHang/create","/KhachHang/store","/KhachHang/index","/KhachHang/delete","/KhachHang/edit","/KhachHang/update"})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;
    String error ;
    String errorTen;
    String errorMa;
    String errorTenDem ;
    String errorHo;
    String errorSdt;
    String errorDiaChi ;
    String errorMatKhau;


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
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("checkHo",errorHo);
        request.setAttribute("checkTenDem", errorTenDem);
        request.setAttribute("checkSdt", errorSdt);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkMatKhau", errorMatKhau);
        request.setAttribute("view","/Views/KhachHang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void store(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
            KhachHang kh = new KhachHang();
            BeanUtils.populate(kh, request.getParameterMap());
            errorTen = CheckString.checkValues(kh.getTen(),"tên");
            errorMa = CheckString.checkValues(kh.getMa(),"mã");
            errorTenDem = CheckString.checkValues(kh.getTenDem(),"tên đệm");
            errorHo = CheckString.checkValues(kh.getHo(),"họ");
            errorDiaChi = CheckString.checkValues(kh.getDiaChi(),"địa chỉ");
            errorMatKhau = CheckString.checkValues(kh.getMatKhau(),"mật khẩu");
            errorSdt = CheckString.checkValues(kh.getSdt(),"số điện thoại");
            KhachHang cv = khRepo.findByMa(kh.getMa());
            if (cv!=null){
                error="Trùng mã";
                response.sendRedirect("/Assignment_war_exploded/KhachHang/create");
                return;
            }else{
                error="";
            }

            if (!errorTen.isEmpty()||!errorMa.isEmpty()||!errorHo.isEmpty()||!errorTenDem.isEmpty()||
                    !errorDiaChi.isEmpty()||!errorMatKhau.isEmpty()||!errorSdt.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/KhachHang/create");
                return;
            }
            this.khRepo.insert(kh);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../KhachHang/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsKhachHang",this.khRepo.findAll());
        request.setAttribute("view","/Views/KhachHang/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String ma = req.getParameter("ma");
        System.out.println(ma);
        KhachHang kh = this.khRepo.findByMa(ma);
        this.khRepo.delete(kh);
        resp.sendRedirect("../KhachHang/index");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khRepo.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkHo",errorHo);
        request.setAttribute("checkTenDem", errorTenDem);
        request.setAttribute("checkSdt", errorSdt);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkMatKhau", errorMatKhau);
        request.setAttribute("kh", kh);
        request.setAttribute("view","/Views/KhachHang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request,response);
    }
    protected void update(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            String ma = request.getParameter("ma");
            KhachHang kh = this.khRepo.findByMa(ma);
            BeanUtils.populate(kh, request.getParameterMap());
            errorTen = CheckString.checkValues(kh.getTen(),"tên");
            errorTenDem = CheckString.checkValues(kh.getTenDem(),"tên đệm");
            errorHo = CheckString.checkValues(kh.getHo(),"họ");
            errorDiaChi = CheckString.checkValues(kh.getDiaChi(),"địa chỉ");
            errorMatKhau = CheckString.checkValues(kh.getMatKhau(),"mật khẩu");
            errorSdt = CheckString.checkValues(kh.getSdt(),"số điện thoại");
            if (!errorTen.isEmpty()||!errorHo.isEmpty()||!errorTenDem.isEmpty()||
                    !errorDiaChi.isEmpty()||!errorMatKhau.isEmpty()||!errorSdt.isEmpty()){
                response.sendRedirect("/Assignment_war_exploded/KhachHang/edit?ma="+kh.getMa());
                return;
            }
            this.khRepo.update(kh);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("../KhachHang/index");
    }
}
