package filters;

import DomainModel.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/KhachHang/*","/SanPham/*","/ChiTietSanPham/*","/ChucVu/*","/CuaHang/*","/DongSP/*","/MauSac/*","/NhanVien/*","/NhaSanXuat/*",
})
public class AuthenFilters  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        NhanVien nv = (NhanVien) session.getAttribute("nv");
        if (nv == null) {
            res.sendRedirect("/Assignment_war_exploded/login");
        } else {
            filterChain.doFilter(req, res);
        }
    }
}
