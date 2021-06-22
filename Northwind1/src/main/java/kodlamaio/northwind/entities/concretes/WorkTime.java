package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="work_time")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class WorkTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="work_time_id")
	private int workTimeId;
	
	@Column(name="work_time_name")
	private String workTimeName;
	
	@JsonIgnore
	@OneToMany(mappedBy="workTime")
	private List<JobPosting> jobPostings;
	
	

}
