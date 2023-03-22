package repository;

import ViewModel.QLNhaSanXuat;

import java.util.ArrayList;

public class NSXRepository {
    private ArrayList<QLNhaSanXuat> list;

    public NSXRepository() {
        this.list = new ArrayList<>();
    }

    public void insert(QLNhaSanXuat nsx) {
        list.add(nsx);
    }

    public void update(QLNhaSanXuat nsx) {
        for (int i = 0; i < list.size(); i++) {
            QLNhaSanXuat item = list.get(i);
            if (item.getMa().equals(nsx.getMa())) {
                list.set(i, nsx);
            }
        }
    }

    public void delete(QLNhaSanXuat nsx) {
        for (int i = 0; i < list.size(); i++) {
            QLNhaSanXuat item = list.get(i);
            if (item.getMa().equals(nsx.getMa())) {
                list.remove(nsx);
            }
        }
    }

    public ArrayList<QLNhaSanXuat> findAll() {
        return list;
    }

    public QLNhaSanXuat findByMa(String ma) {
        for (int i = 0; i < list.size(); i++) {
            QLNhaSanXuat item = list.get(i);
            if (item.getMa().equals(ma)) {
                return list.get(i);
            }
        }
        return null;
    }
}
