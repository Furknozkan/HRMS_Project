package kodlamaio.northwind.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="job_posting")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cities"})
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_name")
	private String jobName;
	
	@Column(name="job_description")
	private String jobDescription;

	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="enable")
	private boolean enable = false;
	
	@Column(name="avatar_url")
	private String avatarUrl;
	
	@ManyToOne() 
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name="work_place_id")
	private WorkPlace workPlace;
	
	@ManyToOne()
	@JoinColumn(name="work_time_id")
	private WorkTime workTime;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employers employer;
}
