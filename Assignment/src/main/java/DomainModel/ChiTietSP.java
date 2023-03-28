package DomainModel;


import jakarta.persistence.*;


@Entity
@Table(name="ChiTietSP")
public class ChiTietSP {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @Column(name="IdSP")
    private String IdSP;

    @Column(name="IdNsx")
    private String IdNsx;

    @Column(name="IdDongSP")
    private String IdDongSP;

    @Column(name="NamBH")
    private String namBH;

    @Column(name="MoTa")
    private String moTa;

    @Column(name="SoLuongTon")
    private int soLuongTon;

    @Column(name="GiaNhap")
    private double DiaChi;

    @Column(name="GiaBan")
    private double ThanhPho;

    public ChiTietSP(String id, String idSP, String idNsx, String idDongSP, String namBH, String moTa, int soLuongTon, double diaChi, double thanhPho) {
        Id = id;
        IdSP = idSP;
        IdNsx = idNsx;
        IdDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
    }

    public ChiTietSP() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIdSP() {
        return IdSP;
    }

    public void setIdSP(String idSP) {
        IdSP = idSP;
    }

    public String getIdNsx() {
        return IdNsx;
    }

    public void setIdNsx(String idNsx) {
        IdNsx = idNsx;
    }

    public String getIdDongSP() {
        return IdDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        IdDongSP = idDongSP;
    }

    public String getNamBH() {
        return namBH;
    }

    public void setNamBH(String namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(double diaChi) {
        DiaChi = diaChi;
    }

    public double getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(double thanhPho) {
        ThanhPho = thanhPho;
    }
}
