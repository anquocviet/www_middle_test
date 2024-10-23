package fit.se.de_03.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "xe")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
      @NamedQuery(name = "Xe.findAll", query = "select x from Xe x"),
      @NamedQuery(name = "Xe.findByLoaiXe", query = "select x from Xe x where x.loaiXe.maLoai = :maLoai")
})
public class Xe implements Serializable {
   @Id
   @Column(name = "ma_xe", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long maXe;

   @Column(name = "ten_xe")
   private String tenXe;

   private double gia;

   @Column(name = "nam_sx")
   private int namSX;

   @ManyToOne
   @JoinColumn(name = "ma_loai")
   @JsonbTransient
   private LoaiXe loaiXe;

   public Xe(String tenXe, double gia, int namSX) {
      this.tenXe = tenXe;
      this.gia = gia;
      this.namSX = namSX;
   }
}