package repository;

import DomainModel.DongSP;
import ViewModel.QLChucVu;
import ViewModel.QLDongSP;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class DongSPRepository {
    private Session hSession;

    public DongSPRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(DongSP kh){
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
    public void update(DongSP kh){
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
    public void delete(DongSP kh){
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
    public List<DongSP> findAll(){
        String hql = "SELECT kh FROM DongSP kh";
        TypedQuery<DongSP> query =this.hSession.createQuery(hql,DongSP.class);
        return query.getResultList();
    }
    public DongSP findByMa(String ma){
        String hql = "SELECT kh FROM DongSP kh WHERE kh.ma = ?1";
        TypedQuery<DongSP> query = this.hSession.createQuery(hql,DongSP.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public DongSP findByID(String id){
        return hSession.find(DongSP.class,id);
    }
}
