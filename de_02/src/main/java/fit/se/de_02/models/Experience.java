package fit.se.de_02.models;

import fit.se.de_02.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
@NamedQueries({
      @NamedQuery(name = "Experience.findAll", query = "select e from Experience e"),
})
public class Experience {
   @Id
   @Column(name = "exp_id")
   private long id;

   @Column(name = "work_desc")
   private String workDescription;

   @Column(name = "role")
   @Enumerated(EnumType.ORDINAL)
   private Roles role;

   @Column(name = "company")
   private String companyName;

   @Column(name = "from_date")
   private LocalDate fromDate;

   @Column(name = "to_date")
   private LocalDate toDate;

   @ManyToOne
   @JoinColumn(name = "can_id")
   private Candidate candidate;
}