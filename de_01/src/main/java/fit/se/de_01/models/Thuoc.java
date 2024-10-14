package fit.se.de_01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "thuoc")
@NamedQueries({
      @NamedQuery(name = "Thuoc.findAll", query = "select t from Thuoc t")
})
public class Thuoc {
   @Id
   @Column(name = "ma_thuoc")
   private String maThuoc;

   @Column(name = "ten_thuoc")
   private String tenThuoc;

   private double gia;

   @Column(name = "nam_sx")
   private int namSx;

   @ManyToOne
   @JoinColumn(name = "ma_loai")
   private LoaiThuoc loaiThuoc;
}
