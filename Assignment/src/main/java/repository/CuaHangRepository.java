package repository;

import ViewModel.QLChucVu;
import ViewModel.QLCuaHang;

import java.util.ArrayList;

public class CuaHangRepository {
    private ArrayList<QLCuaHang> list;

    public CuaHangRepository(){
        this.list = new ArrayList<>();
    }
    public void insert(QLCuaHang ch){
        list.add(ch);
    }
    public void update(QLCuaHang ch){
        for (int i = 0; i < list.size(); i++) {
            QLCuaHang item = list.get(i);
            if(item.getMa().equals(ch.getMa())) {
                list.set(i, ch);
            }
        }
    }
    public void delete(QLCuaHang ch){
        for (int i = 0; i < list.size(); i++) {
            QLCuaHang item = list.get(i);
            if(item.getMa().equals(ch.getMa())) {
                list.remove(ch);
            }
        }
    }
    public ArrayList<QLCuaHang> findAll(){
        return list;
    }
    public QLCuaHang findByMa(String ma){
        for (int i = 0; i < list.size(); i++) {
            QLCuaHang item = list.get(i);
            if(item.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
