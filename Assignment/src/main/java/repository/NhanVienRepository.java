package repository;

import DomainModel.NhanVien;
import ViewModel.QLKhachHang;
import ViewModel.QLNhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private Session hSession;

    public NhanVienRepository(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(NhanVien kh){
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
    public void update(NhanVien kh){
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
    public void delete(NhanVien kh){
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
    public List<NhanVien> findAll(){
        String hql = "SELECT kh FROM NhanVien kh";
        TypedQuery<NhanVien> query =this.hSession.createQuery(hql,NhanVien.class);
        return query.getResultList();
    }
    public NhanVien findByMa(String ma){
        String hql = "SELECT kh FROM NhanVien kh WHERE kh.ma = ?1";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql,NhanVien.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public NhanVien findByID(String id){
        return hSession.find(NhanVien.class,id);
    }
    public NhanVien login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma = ?1 AND nv.mat_khau = ?2";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        query.setParameter(2, matKhau);
        try {
            NhanVien nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
