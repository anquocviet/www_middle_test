package fit.se.de_02.repositories;

import fit.se.de_02.enums.Roles;
import fit.se.de_02.models.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */
public interface CandidateRepository {
   public boolean addCandidate(Candidate c);

   public boolean updateCandidate(Candidate c);

   public boolean deleteCandidate(Long id);

   public Optional<Candidate> find(Long id);

   public List<Candidate> findAll();

   public List<Candidate> findByRole(Roles role);

   public List<Candidate> findCandidateUsingGmail();
}

class CandidateRepositoryImp implements CandidateRepository {
   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public boolean addCandidate(Candidate c) {
      try {
         entityManager.persist(c);
         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }

   @Override
   public boolean updateCandidate(Candidate c) {
      try {
         entityManager.merge(c);
         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }

   @Override
   public boolean deleteCandidate(Long id) {
      try {
         Candidate c = entityManager.find(Candidate.class, id);
         entityManager.remove(c);
         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }

   @Override
   public Optional<Candidate> find(Long id) {
      return Optional.ofNullable(entityManager.find(Candidate.class, id));
   }

   @Override
   public List<Candidate> findAll() {
      return entityManager.createNamedQuery("Candidate.findAll", Candidate.class).getResultList();
   }

   @Override
   public List<Candidate> findByRole(Roles role) {
      return entityManager.
                   createNamedQuery("Candidate.findCandidateByRole", Candidate.class)
                   .setParameter("role", role)
                   .getResultStream()
                   .distinct()
                   .toList();
   }

   @Override
   public List<Candidate> findCandidateUsingGmail() {
      return entityManager.
                   createNamedQuery("Candidate.findByEmailLike", Candidate.class)
                   .setParameter("email", "%@gmail.com")
                   .getResultStream()
                   .toList();
   }
}
