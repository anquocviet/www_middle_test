package fit.se.de_03.daos;

import fit.se.de_03.entities.Xe;
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
public class QuanlyXeDAO {
   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   public Xe save(Xe xe) {
      entityManager.persist(xe);
      return xe;
   }

   @Transactional
   public Xe update(Xe xe) {
      return entityManager.merge(xe);
   }

   @Transactional
   public boolean delete(Long maXe) {
      Xe xe = entityManager.find(Xe.class, maXe);
      if (xe == null) {
         return false;
      }
      entityManager.remove(xe);
      return true;
   }

   public Optional<Xe> findById(Long maXe) {
      Xe xe = entityManager.find(Xe.class, maXe);
      return Optional.ofNullable(xe);
   }

   public List<Xe> findAll() {
      return entityManager.createNamedQuery("Xe.findAll", Xe.class).getResultList();
   }

   public List<Xe> findByLoaiXe(Long maLoai) {
      return entityManager.createNamedQuery("Xe.findByLoaiXe", Xe.class)
            .setParameter("maLoai", maLoai)
            .getResultList();
   }
}
