package fit.se.de_02.repositories;

import fit.se.de_02.models.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */

public interface ExperienceRepository {
   Optional<Experience> find(Long id);

   List<Experience> findAll();

   boolean addExperience(Experience e);

   boolean updateExperience(Experience e);

   boolean deleteExperience(Long id);
}

class ExperienceRepositoryImp implements ExperienceRepository {
   @PersistenceContext
   private EntityManager entityManager;

   public Optional<Experience> find(Long id) {
      return Optional.ofNullable(entityManager.find(Experience.class, id));
   }

   public List<Experience> findAll() {
      return entityManager.createNamedQuery("Experience.findAll", Experience.class).getResultList();
   }

   public boolean addExperience(Experience e) {
      try {
         entityManager.persist(e);
         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }

   public boolean updateExperience(Experience e) {
      try {
         entityManager.merge(e);
         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }

   public boolean deleteExperience(Long id) {
      try {
         Experience e = entityManager.find(Experience.class, id);
         entityManager.remove(e);
         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }
}
