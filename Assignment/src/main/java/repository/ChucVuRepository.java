package repository;

import ViewModel.QLChucVu;

import java.util.ArrayList;

public class ChucVuRepository {
    private ArrayList<QLChucVu> list;

    public ChucVuRepository (){
        this.list = new ArrayList<>();
    }

    public void insert(QLChucVu cv){
        list.add(cv);
    }
    public void update(QLChucVu cv){
        for (int i = 0; i < list.size(); i++) {
            QLChucVu item = list.get(i);
            if(item.getMa().equals(cv.getMa())) {
                list.set(i, cv);
            }
        }
    }
    public void delete(QLChucVu cv){
        for (int i = 0; i < list.size(); i++) {
            QLChucVu item = list.get(i);
            if(item.getMa().equals(cv.getMa())) {
                list.remove(cv);
            }
        }
    }
    public ArrayList<QLChucVu> findAll(){
        return list;
    }
    public QLChucVu findByMa(String ma){
        for (int i = 0; i < list.size(); i++) {
            QLChucVu item = list.get(i);
            if(item.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
