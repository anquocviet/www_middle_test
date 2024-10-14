package fit.se.de_01.daos;

import fit.se.de_01.models.Thuoc;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */
@Stateless
public class QuanlyThuocDao {
   @PersistenceContext
   private EntityManager entityManager;

   public Optional<Thuoc> getThuoc(String id) {
      return Optional.ofNullable(entityManager.find(Thuoc.class, id));
   }

   public Set<Thuoc> getThuocs() {
      return entityManager.createNamedQuery("Thuoc.findAll", Thuoc.class)
                   .getResultStream()
                   .collect(Collectors.toSet());
   }

   public boolean addThuoc(Thuoc thuoc) {
      try {
         entityManager.persist(thuoc);
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   public boolean updateThuoc(Thuoc thuoc) {
      try {
         entityManager.merge(thuoc);
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   public boolean deleteThuoc(String id) {
      try {
         Thuoc thuoc = entityManager.find(Thuoc.class, id);
         entityManager.remove(thuoc);
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }
}
