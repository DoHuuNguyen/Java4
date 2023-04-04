package repository;

import DomainModel.ChucVu;
import DomainModel.KhachHang;
import ViewModel.QLChucVu;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    private Session hSession;

    public ChucVuRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(ChucVu kh){
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
    public void update(ChucVu kh){
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
    public void delete(ChucVu kh){
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
    public List<ChucVu> findAll(){
        String hql = "SELECT kh FROM ChucVu kh";
        TypedQuery<ChucVu> query =this.hSession.createQuery(hql,ChucVu.class);
        return query.getResultList();
    }
    public ChucVu findByMa(String ma){
        String hql = "SELECT kh FROM ChucVu kh WHERE kh.Ma = ?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public ChucVu findByID(String id){
        return hSession.find(ChucVu.class,id);
    }
}
