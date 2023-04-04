package repository;

import DomainModel.KhachHang;
import ViewModel.QLKhachHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private Session hSession;

    public KhachHangRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(KhachHang kh){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            hSession.persist(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(KhachHang kh){
            Transaction transaction = this.hSession.getTransaction();
            try {
                transaction.begin();
                hSession.merge(kh);
                transaction.commit();
        }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
    }
    public void delete(KhachHang kh){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public List<KhachHang> findAll(){
        String hql = "SELECT kh FROM KhachHang kh";
        TypedQuery<KhachHang> query =this.hSession.createQuery(hql,KhachHang.class);
        return query.getResultList();
    }
    public KhachHang findByMa(String ma){
        String hql = "SELECT kh FROM KhachHang kh WHERE kh.Ma = ?1";
        TypedQuery<KhachHang> query = this.hSession.createQuery(hql,KhachHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public KhachHang findByID(String id){
        return hSession.find(KhachHang.class,id);
    }
}
