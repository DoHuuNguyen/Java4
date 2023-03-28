package DomainModel;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="HoaDon")
public class HoaDon {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @Column(name="IdKH")
    private String IdKH;

    @Column(name="IdNV")
    private String IdNV;

    @Column(name="Ma")
    private String ma;

    @Column(name="NgayTao")
    private Date ngayTao;


//    @Column(name="IdSP")
//    private String IdSP;
//
//
//    @Column(name="IdSP")
//    private String IdSP;
//
//
//    @Column(name="IdSP")
//    private String IdSP;
//
//    @Column(name="IdSP")
//    private String IdSP;
//
//    @Column(name="IdSP")
//    private String IdSP;
//
//    @Column(name="IdSP")
//    private String IdSP;
//
//    @Column(name="IdSP")
//    private String IdSP;
//
//    @Column(name="IdSP")
//    private String IdSP;


}
