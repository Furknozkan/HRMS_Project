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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="departments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolDepartments"})
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="department_name")
	private String departmentName;


	@OneToMany(mappedBy = "department")
	private List<SchoolDepartment> schoolDepartments;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
	
	
}
