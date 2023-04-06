package repository;

import DomainModel.ChucVu;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class ChucVuRepository {
    private Session hSession;

    public ChucVuRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            hSession.persist(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public List<ChucVu> findAll(){
        String hql = "SELECT cv FROM ChucVu cv";
        TypedQuery<ChucVu> query =this.hSession.createQuery(hql,ChucVu.class);
        return query.getResultList();
    }
    public ChucVu findByMa(String ma){
        String hql = "SELECT cv FROM ChucVu cv WHERE cv.ma = ?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public ChucVu findByID(String id){
        return hSession.find(ChucVu.class,id);
    }
}
