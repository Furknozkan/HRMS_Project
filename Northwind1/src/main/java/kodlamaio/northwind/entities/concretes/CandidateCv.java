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
	
	@JsonIgnore
	@Column(name="created_date")
	private LocalDate createdAt = LocalDate.now();
	
	@Column(name="over_letter")
	private String overLetter;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	
	@JsonIgnore
	@OneToMany(mappedBy = "candidateCv")
	private List<Languages> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidateCv")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidateCv")
	private List<Experiences> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidateCv")
	private List<Department> departments;
}
