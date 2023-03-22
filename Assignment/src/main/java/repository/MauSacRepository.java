package repository;

import ViewModel.QLMauSac;
import ViewModel.QLNhaSanXuat;

import java.util.ArrayList;

public class MauSacRepository {
    private ArrayList<QLMauSac> list;

    public MauSacRepository(){
        this.list = new ArrayList<>();
    }

    public void insert(QLMauSac ms){
        list.add(ms);
    }
    public void update(QLMauSac ms){
        for (int i = 0; i < list.size(); i++) {
            QLMauSac item = list.get(i);
            if(item.getMa().equals(ms.getMa())) {
                list.set(i, ms);
            }
        }
    }
    public void delete(QLMauSac ms){
        for (int i = 0; i < list.size(); i++) {
            QLMauSac item = list.get(i);
            if(item.getMa().equals(ms.getMa())) {
                list.remove(ms);
            }
        }
    }
    public ArrayList<QLMauSac> findAll(){
        return list;
    }
    public QLMauSac findByMa(String ma){
        for (int i = 0; i < list.size(); i++) {
            QLMauSac item = list.get(i);
            if(item.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }

}
