package kodlamaio.northwind.entities.concretes;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
public class Languages {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="languages_id")
	private int languages_id;
	
	@Column(name="languages")
	private String languages;
	
	
	@Column(name="level")
	private String level;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
	
	
	
}
