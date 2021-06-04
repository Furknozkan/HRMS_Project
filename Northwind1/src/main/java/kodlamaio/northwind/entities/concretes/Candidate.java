package kodlamaio.northwind.entities.concretes;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.northwind.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
@Table(name="candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schools","departments","languages","experiences","candidateSchoolDepartments"})
public class Candidate extends User{

	
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identification_number")
	private String  identificationNumber;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="programing_languages")
	private String programingLanguages;
	
	@Column(name="github_adress")
	private String github;
	
	@Column(name="linkedin_adress")
	private String linkedin;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@JsonIgnore
	@OneToOne(mappedBy ="candidate")
	private CandidateCv candidateCv;
	
	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private CandidatePhoto candidatePhoto;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Languages> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Experiences> experiences;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Department> departments;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateSchoolDepartment> candidateSchoolDepartments;
	

	
	
}
