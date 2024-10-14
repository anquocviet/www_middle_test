package fit.se.de_01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loai_thuoc")
@NamedQueries({
      @NamedQuery(name = "LoaiThuoc.findAll", query = "select l from LoaiThuoc l"),
      @NamedQuery(name = "LoaiThuoc.findThuocByLoai", query = "select l.thuocs from LoaiThuoc l where l.maLoai = :maLoai")
})
public class LoaiThuoc {
   @Id
   @Column(name = "ma_loai")
   private String maLoai;

   @Column(name = "ten_loai")
   private String tenLoai;

   @OneToMany(mappedBy = "loaiThuoc")
   @ToString.Exclude
   private Set<Thuoc> thuocs;
}