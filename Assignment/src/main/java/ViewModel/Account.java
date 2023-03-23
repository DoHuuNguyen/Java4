package ViewModel;

public class Account {
    private String ten;
    private String matKhau;
    private String quyen;

    public Account() {
    }

    public Account(String ten, String matKhau, String quyen) {
        this.ten = ten;
        this.matKhau = matKhau;
        this.quyen = quyen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
}
