package fit.se.de_01.daos;


import fit.se.de_01.models.LoaiThuoc;
import fit.se.de_01.models.Thuoc;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */
@Stateless
public class QuanlyLoaiThuocDao {
   @PersistenceContext
   private EntityManager entityManager;

   public Optional<LoaiThuoc> getLoaiThuoc(String id) {
      return Optional.ofNullable(entityManager.find(LoaiThuoc.class, id));
   }

   public Set<LoaiThuoc> getLoaiThuocs() {
      return entityManager.createNamedQuery("LoaiThuoc.findAll", LoaiThuoc.class)
                   .getResultStream()
                   .collect(Collectors.toSet());
   }

   public Set<Thuoc> getThuocsByLoai(String maLoai) {
      return entityManager.createNamedQuery("LoaiThuoc.findThuocByLoai", Thuoc.class)
                   .setParameter("maLoai", maLoai)
                   .getResultStream()
                   .filter(Objects::nonNull)
                   .collect(Collectors.toSet());
   }

   public boolean addLoaiThuoc(LoaiThuoc loaiThuoc) {
      try {
         entityManager.persist(loaiThuoc);
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   public boolean updateLoaiThuoc(LoaiThuoc loaiThuoc) {
      try {
         entityManager.merge(loaiThuoc);
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   public boolean deleteLoaiThuoc(String id) {
      try {
         LoaiThuoc loaiThuoc = entityManager.find(LoaiThuoc.class, id);
         entityManager.remove(loaiThuoc);
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }


}
