package kodlamaio.northwind.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="experiences")
@Entity
public class Experiences {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experiences_id")
	private int experiences_id;
	
	@Column(name="experiences")
	private String experiences;
	
	@Column(name="start_date")
	private LocalDate start_date;
	
	@Column(name="end_date")
	private LocalDate end_date;
	
	@Column(name="is_working_now")
	private boolean is_working_now;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="title")
	private String title;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
}
