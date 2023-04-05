package Controller.Admin;

import DomainModel.NhanVien;
import ViewModel.QLChiTietSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSanPhamRepository;
import repository.NhanVienRepository;

import java.io.IOException;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nvRepo = new NhanVienRepository();
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/Views/Login.jsp");
        request.getRequestDispatcher("/Views/Login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NhanVien nv = this.nvRepo.login(ma, matKhau);
        HttpSession session = request.getSession();
        if (nv == null) {
            session.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
            response.sendRedirect("/Assignment_war_exploded/login");
        } else {
            session.setAttribute("nv", nv);
            response.sendRedirect("/Assignment_war_exploded/KhachHang/index");
        }
    }
}
