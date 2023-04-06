package repository;

import DomainModel.SanPham;
import ViewModel.QLMauSac;
import ViewModel.QLSanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private Session hSession;

    public SanPhamRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(SanPham ms){
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
    public void update(SanPham ms){
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
    public void delete(SanPham ms){
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
    public List<SanPham> findAll(){
        String hql = "SELECT ms FROM SanPham ms";
        TypedQuery<SanPham> query =this.hSession.createQuery(hql,SanPham.class);
        return query.getResultList();
    }
    public SanPham findByMa(String ma){
        String hql = "SELECT ms FROM SanPham ms WHERE ms.ma = ?1";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql,SanPham.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public SanPham findByID(String id){
        return hSession.find(SanPham.class,id);
    }

}
