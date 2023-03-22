package repository;

import ViewModel.QLMauSac;
import ViewModel.QLSanPham;

import java.util.ArrayList;

public class SanPhamRepository {
    private ArrayList<QLSanPham> list;

    public SanPhamRepository(){
        this.list = new ArrayList<>();
    }

    public void insert(QLSanPham sp){
        list.add(sp);
    }
    public void update(QLSanPham sp){
        for (int i = 0; i < list.size(); i++) {
            QLSanPham item = list.get(i);
            if(item.getMa().equals(sp.getMa())) {
                list.set(i, sp);
            }
        }
    }
    public void delete(QLSanPham sp){
        for (int i = 0; i < list.size(); i++) {
            QLSanPham item = list.get(i);
            if(item.getMa().equals(sp.getMa())) {
                list.remove(sp);
            }
        }
    }
    public ArrayList<QLSanPham> findAll(){
        return list;
    }
    public QLSanPham findByMa(String ma){
        for (int i = 0; i < list.size(); i++) {
            QLSanPham item = list.get(i);
            if(item.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
