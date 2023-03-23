package Controller.Admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.AccountRepository;

import java.io.IOException;

@WebServlet({
        "/dangNhap","/dangKy"
})
public class DangNhapServlet extends HttpServlet {
    private AccountRepository accRepo;

    public DangNhapServlet(){
        this.accRepo = new AccountRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //this.accRepo.check()
    }

}
