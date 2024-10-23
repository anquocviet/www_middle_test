package fit.se.de_02.services;

import fit.se.de_02.enums.Roles;
import fit.se.de_02.models.Candidate;
import fit.se.de_02.repositories.CandidateRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 14/10/24
 */
@Stateless
public class CandidateService {
   @Inject
   private CandidateRepository candidateRepository;

   public boolean addCandidate(Candidate c) {
      return candidateRepository.addCandidate(c);
   }

   public boolean updateCandidate(Candidate c) {
      return candidateRepository.updateCandidate(c);
   }

   public boolean deleteCandidate(Long id) {
      return candidateRepository.deleteCandidate(id);
   }

   public Optional<Candidate> find(Long id) {
      return candidateRepository.find(id);
   }

   public List<Candidate> findAll() {
      return candidateRepository.findAll();
   }

   public List<Candidate> findByRole(String role) {
      Roles roleEnum = Roles.valueOf(role);
      return candidateRepository.findByRole(roleEnum);
   }

   public List<Candidate> findCandidateUsingGmail() {
      return candidateRepository.findCandidateUsingGmail();
   }

}
