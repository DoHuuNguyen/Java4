package repository;

import ViewModel.QLKhachHang;

import java.util.ArrayList;

public class KhachHangRepository {
    private ArrayList<QLKhachHang> list;

    public KhachHangRepository(){
        this.list = new ArrayList<>();
    }
    public void insert(QLKhachHang kh){
        //
        this.list.add(kh);
    }
    public void update(QLKhachHang kh){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLKhachHang item =this.list.get(i);
            if(item.getMa().equals(kh.getMa()));
            this.list.set(i,kh);
        }
    }
    public void delete(QLKhachHang kh){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLKhachHang item =this.list.get(i);
            if(item.getMa().equals(kh.getMa()));
            this.list.remove(i);
        }
    }
    public ArrayList<QLKhachHang> findAll(){
        return list;
    }
    public QLKhachHang findByMa(String ma){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLKhachHang item = this.list.get(i);
            if(item.getMa().equals(ma));
           return this.list.get(i);
        }
        return null;
    }
}
