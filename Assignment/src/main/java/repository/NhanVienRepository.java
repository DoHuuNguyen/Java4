package repository;

import ViewModel.QLKhachHang;
import ViewModel.QLNhanVien;

import java.util.ArrayList;

public class NhanVienRepository {
    private ArrayList<QLNhanVien> list;

    public NhanVienRepository(){
        this.list = new ArrayList<>();
    }

    public void insert(QLNhanVien nv){
        //
        this.list.add(nv);
    }
    public void update(QLNhanVien nv){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLNhanVien item =this.list.get(i);
            if(item.getMa().equals(nv.getMa()));
            this.list.set(i,nv);
        }
    }
    public void delete(QLNhanVien nv){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLNhanVien item = this.list.get(i);
            if(item.getMa().equals(nv.getMa()));
            this.list.remove(i);
        }
    }
    public ArrayList<QLNhanVien> findAll(){
        return list;
    }
    public QLNhanVien findByMa(String ma){
        //
        for (int i = 0; i < this.list.size(); i++) {
            QLNhanVien item = this.list.get(i);
            if(item.getMa().equals(ma));
            return this.list.get(i);
        }
        return null;
    }
}
