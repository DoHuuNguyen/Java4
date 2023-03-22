package ViewModel;

public class QLGioHangChiTiet {
    private String idGioHang;
    private String idChiTietSP;
    private String SoLuong;
    private String DonGia;
    private String DonGiaKhiGiam;

    public QLGioHangChiTiet() {
    }

    public QLGioHangChiTiet(String idGioHang, String idChiTietSP, String soLuong, String donGia, String donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        SoLuong = soLuong;
        DonGia = donGia;
        DonGiaKhiGiam = donGiaKhiGiam;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String donGia) {
        DonGia = donGia;
    }

    public String getDonGiaKhiGiam() {
        return DonGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(String donGiaKhiGiam) {
        DonGiaKhiGiam = donGiaKhiGiam;
    }
}

