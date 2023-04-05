package repository;

import DomainModel.ChiTietSP;
import DomainModel.MauSac;
import ViewModel.QLChiTietSP;
import ViewModel.QLKhachHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamRepository {
    private Session hSession;

    public ChiTietSanPhamRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(ChiTietSP ms){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            hSession.persist(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(ChiTietSP ms){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(ChiTietSP ms){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public List<ChiTietSP> findAll(){
        String hql = "SELECT ms FROM ChiTietSP ms";
        TypedQuery<ChiTietSP> query =this.hSession.createQuery(hql, ChiTietSP.class);
        return query.getResultList();
    }
//    public ChiTietSP findByMa(String ma){
//        String hql = "SELECT ms FROM ChiTietSP ms WHERE ms. = ?1";
//        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql,ChiTietSP.class);
//        query.setParameter(1,ma);
//        return query.getSingleResult();
//    }
    public ChiTietSP findByID(String id){
        return hSession.find(ChiTietSP.class,id);
    }

}
