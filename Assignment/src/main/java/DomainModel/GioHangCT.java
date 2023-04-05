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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHangChiTiet")
public class GioHangCT implements Serializable {
    @EmbeddedId
    private GioHangChiTietId gioHangChiTietId;

    @ManyToOne()
    @JoinColumn(name = "IdGioHang",updatable = false,insertable = false)
    private GioHang gioHang;

    @ManyToOne()
    @JoinColumn(name = "IdChiTietSP",updatable = false,insertable = false)
    private ChiTietSP CTSanPham;

    @Column(name = "SoLuong")
    private Integer SoLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GioHangCT that = (GioHangCT) o;
        return gioHangChiTietId == that.gioHangChiTietId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gioHangChiTietId, gioHang, CTSanPham, SoLuong, donGia, donGiaKhiGiam);
    }
}
