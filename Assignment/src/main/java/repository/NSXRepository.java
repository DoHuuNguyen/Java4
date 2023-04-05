package repository;

import DomainModel.NSX;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class NSXRepository {
    private Session hSession;

    public NSXRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(NSX ms){
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
    public void update(NSX ms){
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
    public void delete(NSX ms){
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
    public List<NSX> findAll(){
        String hql = "SELECT ms FROM NSX ms";
        TypedQuery<NSX> query =this.hSession.createQuery(hql,NSX.class);
        return query.getResultList();
    }
    public NSX findByMa(String ma){
        String hql = "SELECT ms FROM NSX ms WHERE ms.ma = ?1";
        TypedQuery<NSX> query = this.hSession.createQuery(hql,NSX.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public NSX findByID(String id){
        return hSession.find(NSX.class,id);
    }

}
