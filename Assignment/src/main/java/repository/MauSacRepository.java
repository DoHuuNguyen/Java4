package repository;

import DomainModel.KhachHang;
import DomainModel.MauSac;
import ViewModel.QLMauSac;
import ViewModel.QLNhaSanXuat;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(MauSac ms){
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
    public void update(MauSac ms){
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
    public void delete(MauSac ms){
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
    public List<MauSac> findAll(){
        String hql = "SELECT ms FROM MauSac ms";
        TypedQuery<MauSac> query =this.hSession.createQuery(hql,MauSac.class);
        return query.getResultList();
    }
    public MauSac findByMa(String ma){
        String hql = "SELECT ms FROM MauSac ms WHERE ms.ma = ?1";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql,MauSac.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public MauSac findByID(String id){
        return hSession.find(MauSac.class,id);
    }

}
