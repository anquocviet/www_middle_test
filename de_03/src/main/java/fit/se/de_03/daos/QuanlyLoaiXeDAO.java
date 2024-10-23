package fit.se.de_03.daos;

import fit.se.de_03.entities.LoaiXe;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 23/10/24
 */
@Stateless
public class QuanlyLoaiXeDAO {
   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   public LoaiXe sav(LoaiXe loaiXe) {
      entityManager.persist(loaiXe);
      return loaiXe;
   }

   @Transactional
   public LoaiXe update(LoaiXe loaiXe) {
      entityManager.merge(loaiXe);
      return loaiXe;
   }

   @Transactional
   public boolean delete(String maLoai) {
      LoaiXe loaiXe = entityManager.find(LoaiXe.class, maLoai);
      if (loaiXe == null) {
         return false;
      }
      entityManager.remove(loaiXe);
      return true;
   }

   public Optional<LoaiXe> findById(Long maLoai) {
      LoaiXe loaiXe = entityManager.find(LoaiXe.class, maLoai);
      return Optional.ofNullable(loaiXe);
   }

   public List<LoaiXe> findAll() {
      return entityManager.createNamedQuery("LoaiXe.findAll", LoaiXe.class).getResultList();
   }
}
