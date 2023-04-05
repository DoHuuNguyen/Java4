package repository;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import ViewModel.QLKhachHang;
import ViewModel.QLNhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
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
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma = ?1 AND nv.matKhau = ?2";
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
    public CuaHang findCuaHangByMa(String ma) {
        Query query = hSession.createQuery("select k from CuaHang k where k.ma =:ma ");
        query.setParameter("ma", ma);
        try {
            CuaHang ms = (CuaHang) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public ChucVu findChucVuByMa(String ma) {
        Query query = hSession.createQuery("select k from ChucVu k where k.ma =:ma ");
        query.setParameter("ma", ma);
        try {
            ChucVu ms = (ChucVu) query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            return null;
        }
    }
    public List<ChucVu> getAllChucVu() {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("select ms From ChucVu ms ", ChucVu.class);
        return query.getResultList();
    }
    public List<CuaHang> getAllCuaHang() {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("select ms From CuaHang ms ", CuaHang.class);
        return query.getResultList();
    }
}
