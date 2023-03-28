package Controller.Admin;

import ViewModel.Account;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
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
        Account ac = new Account("aaa","123","1");
        this.dangNhap(request,response);
    }
    protected void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Account ac = new Account();
            BeanUtils.populate(ac,request.getParameterMap());
            request.setAttribute("a",this.accRepo.check(ac));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
