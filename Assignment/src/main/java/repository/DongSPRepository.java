package repository;

import ViewModel.QLChucVu;
import ViewModel.QLDongSP;

import java.util.ArrayList;

public class DongSPRepository {
    private ArrayList<QLDongSP> list;

    public DongSPRepository(){
        this.list = new ArrayList<>();
    }

    public void insert(QLDongSP dsp){
        list.add(dsp);
    }
    public void update(QLDongSP dsp){
        for (int i = 0; i < list.size(); i++) {
            QLDongSP item = list.get(i);
            if(item.getMa().equals(dsp.getMa())) {
                list.set(i, dsp);
            }
        }
    }
    public void delete(QLDongSP dsp){
        for (int i = 0; i < list.size(); i++) {
            QLDongSP item = list.get(i);
            if(item.getMa().equals(dsp.getMa())) {
                list.remove(dsp);
            }
        }
    }
    public ArrayList<QLDongSP> findAll(){
        return list;
    }
    public QLDongSP findByMa(String ma){
        for (int i = 0; i < list.size(); i++) {
            QLDongSP item = list.get(i);
            if(item.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
