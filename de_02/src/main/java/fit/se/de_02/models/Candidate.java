package fit.se.de_02.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candidate")
@NamedQueries({
      @NamedQuery(name = "Candidate.findAll", query = "select c from Candidate c"),
      @NamedQuery(name = "Candidate.findCandidateByRole",
            query = "select distinct c from Candidate c inner join c.experiences experiences " +
                          "where experiences.role = :role"),
      @NamedQuery(name = "Candidate.findByEmailLike",
            query = "select c from Candidate c where c.email like :email")
})
public class Candidate {
   @Id
   @Column(name = "can_id")
   private long id;

   @Column(name = "full_name")
   private String fullName;

   @Column(name = "phone")
   private String phone;

   @Column(name = "email")
   private String email;

   @OneToMany(mappedBy = "candidate")
   private List<Experience> experiences;
}