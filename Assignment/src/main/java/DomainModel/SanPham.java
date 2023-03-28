package DomainModel;

import jakarta.persistence.*;



@Entity
@Table(name="SanPham")
public class SanPham {
    @jakarta.persistence.Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

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

    public SanPham() {
    }

    public SanPham(String id, String ma, String ten) {
        Id = id;
        Ma = ma;
        Ten = ten;
    }
}
