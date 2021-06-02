package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolDepartments"})
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int school_id;
	
	@Column(name="school_name")
	private String school_name;
	
	@Column(name="is_graduate")
	private boolean is_graduate;
	
	
	@OneToMany(mappedBy = "school")
	private List<SchoolDepartment> schoolDepartment;

}
