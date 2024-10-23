package fit.se.de_02.services;

import fit.se.de_02.models.Experience;
import fit.se.de_02.repositories.ExperienceRepository;
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
public class ExperienceService {
   @Inject
   private ExperienceRepository experienceRepository;

   public boolean addExperience(Experience e) {
      return experienceRepository.addExperience(e);
   }

   public boolean updateExperience(Experience e) {
      return experienceRepository.updateExperience(e);
   }

   public boolean deleteExperience(Long id) {
      return experienceRepository.deleteExperience(id);
   }

   public Optional<Experience> find(Long id) {
      return experienceRepository.find(id);
   }

   public List<Experience> findAll() {
      return experienceRepository.findAll();
   }
}
