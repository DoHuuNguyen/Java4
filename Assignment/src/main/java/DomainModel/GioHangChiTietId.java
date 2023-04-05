package DomainModel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangChiTietId implements Serializable {
    @Column(name = "IdGioHang")
    @Type(type = "uuid-char")
    private UUID IdGioHang;
    @Column(name = "IdChiTietSP")
    private UUID IdChiTietSP;

}
