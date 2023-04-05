package DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "HoaDonChiTiet")
public class HoaDonCT implements Serializable {
    @EmbeddedId
    private HoaDonChiTietId hoaDonChiTietId;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
    private ChiTietSP ChiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonCT that = (HoaDonCT) o;
        return hoaDonChiTietId.equals(that.hoaDonChiTietId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoaDonChiTietId);
    }
}
