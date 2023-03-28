package DomainModel;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="NhanVien")
public class NhanVien {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    @Column(name="TenDem")
    private String TenDem;

    @Column(name="Ho")
    private String Ho;

    @Column(name="NgaySinh")
    private Date NgaySinh;

    @Column(name="Sdt")
    private String Sdt;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="Sdt")
    private String SDT;

    @Column(name="MatKhau")
    private String MatKhau;


    @Column(name="IdCH")
    private String IdCH;


    @Column(name="IdCV")
    private String IdCV;


    @Column(name="IdGuiBC")
    private String idGuiBC;


    @Column(name="TrangThai")
    private String trangThai;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String tenDem) {
        TenDem = tenDem;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getIdCH() {
        return IdCH;
    }

    public void setIdCH(String idCH) {
        IdCH = idCH;
    }

    public String getIdCV() {
        return IdCV;
    }

    public void setIdCV(String idCV) {
        IdCV = idCV;
    }

    public String getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien(String id, String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String SDT, String matKhau, String idCH, String idCV, String idGuiBC, String trangThai) {
        Id = id;
        Ma = ma;
        Ten = ten;
        TenDem = tenDem;
        Ho = ho;
        NgaySinh = ngaySinh;
        Sdt = sdt;
        DiaChi = diaChi;
        this.SDT = SDT;
        MatKhau = matKhau;
        IdCH = idCH;
        IdCV = idCV;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }

    public NhanVien() {
    }
}
