package fit.se.de_03.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "loai_xe")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries({
      @NamedQuery(name = "LoaiXe.findAll", query = "select l from LoaiXe l")
})
public class LoaiXe implements Serializable {
   @Id
   @Column(name = "ma_loai", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long maLoai;

   @Column(name = "ten_loai")
   private String tenLoai;

   @OneToMany(mappedBy = "loaiXe")
   @ToString.Exclude
   @JsonbTransient
   private List<Xe> xeList;

   public LoaiXe(String tenLoai) {
      this.tenLoai = tenLoai;
   }
}