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
@Entity
@Table(name="skills")
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id")
	private int skillId;
	
	@Column(name="skill_name")
	private String skill;

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
