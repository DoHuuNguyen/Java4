package repository;

import ViewModel.Account;

import java.util.ArrayList;

public class AccountRepository {
    private ArrayList<Account> list;

    public AccountRepository(){
        this.list = new ArrayList<>();
    }
     public void insert(Account ac){
        this.list.add(ac);
     }
     public void update(Account acc,String ten){
         for (int i = 0; i < list.size(); i++) {
             Account item = new Account();
             if(item.getTen() == ten){
                 list.set(i,acc);
             }
         }
     }
     public boolean check(Account acc){
         for (int i = 0; i < list.size(); i++) {
             Account item = new Account();
             if(item.getTen() == acc.getTen()&&item.getMatKhau()==acc.getMatKhau()){
                 return true;
             }
         }
         return false;
     }
}
