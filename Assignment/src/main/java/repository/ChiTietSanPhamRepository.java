package repository;

import ViewModel.QLChiTietSP;
import ViewModel.QLKhachHang;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {
    private ArrayList<QLChiTietSP> list;

    public ChiTietSanPhamRepository() {
        this.list = new ArrayList<>();
    }

    public void insert(QLChiTietSP ctsp){
        this.list.add(ctsp);
    }
    public void update(QLChiTietSP ctsp){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSP item = this.list.get(i);
            if(item.getIdSP().equals(ctsp.getIdSP()));
            this.list.set(i,ctsp);
        }
    }
    public void delete(QLChiTietSP ctsp){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSP item = this.list.get(i);
            if(item.getIdSP().equals(ctsp.getIdSP()));
            this.list.remove(i);
        }
    }
    public ArrayList<QLChiTietSP> findAll(){
        return list;
    }
    public QLChiTietSP findByMa(String idSP){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSP item = this.list.get(i);
            if(item.getIdSP().equals(idSP));
            return this.list.get(i);
        }
        return null;
    }
}
