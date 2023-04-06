package repository;

import DomainModel.*;
import ViewModel.QLChiTietSP;
import ViewModel.QLKhachHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public ChiTietSP findByMa(String ma){
        String hql = "SELECT ms FROM ChiTietSP ms WHERE ms. id = ?1";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql,ChiTietSP.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public ChiTietSP findByID(String id){
        return hSession.find(ChiTietSP.class,id);
    }
    public List<SanPham> getAllSanPham() {
        Query query = hSession.createQuery("select ms From SanPham ms ", SanPham.class);
        return query.getResultList();
    }
    public List<DongSP> getAllDongSP() {
        Query query = hSession.createQuery("select ms From DongSP ms ", DongSP.class);
        return query.getResultList();
    }
    public List<MauSac> getAllMauSac() {
        Query query = hSession.createQuery("select ms From MauSac ms ", MauSac.class);
        return query.getResultList();
    }
    public List<NSX> getAllNSX() {
        Query query = hSession.createQuery("select ms From NSX ms ", NSX.class);
        return query.getResultList();
    }
    public DongSP findMaDongSP(String ma) {
        Query query = hSession.createQuery("select k from DongSP k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            DongSP ms = (DongSP) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public MauSac findMaMauSac(String ma) {
        Query query = hSession.createQuery("select k from MauSac k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            MauSac ms = (MauSac) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public NSX findMaNSX(String ma) {
        Query query = hSession.createQuery("select k from NSX k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            NSX ms = (NSX) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public SanPham findMaSanPham(String ma) {
        Query query = hSession.createQuery("select k from SanPham k where k.ma =:ma");
        query.setParameter("ma", ma);
        try {
            SanPham ms = (SanPham) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
}
