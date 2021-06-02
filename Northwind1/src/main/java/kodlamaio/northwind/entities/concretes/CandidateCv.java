package kodlamaio.northwind.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates_cv")

public class CandidateCv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="over_letter")
	private String overLetter;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<Experiences> experiences;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<Languages> languages;
	

	@OneToMany(mappedBy = "candidate")
	private List<CandidateSchoolDepartment> candidateSchoolDepartments;
	

}
