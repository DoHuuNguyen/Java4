package repository;

import DomainModel.CuaHang;
import DomainModel.KhachHang;
import ViewModel.QLCuaHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {
    private Session hSession;

    public CuaHangRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(CuaHang ch){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            hSession.persist(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(CuaHang ch){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(CuaHang ch){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public List<CuaHang> findAll(){
        String hql = "SELECT ch FROM CuaHang ch";
        TypedQuery<CuaHang> query =this.hSession.createQuery(hql,CuaHang.class);
        return query.getResultList();
    }
    public CuaHang findByMa(String ma){
        String hql = "SELECT ch FROM CuaHang ch WHERE ch.ma = ?1";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql,CuaHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public CuaHang findByID(String id){
        return hSession.find(CuaHang.class,id);
    }
}
