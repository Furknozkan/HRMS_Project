package kodlamaio.northwind.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.CandidateCv;
import kodlamaio.northwind.entities.concretes.CandidateSchoolDepartment;
import kodlamaio.northwind.entities.concretes.Department;
import kodlamaio.northwind.entities.concretes.Experiences;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	@JsonIgnore
	private Candidate candidate;
	
	private List<School> school;
	private List<CandidateSchoolDepartment> candidateSchoolDepartments;
	private List<Languages> languages;
	private List<Experiences> experiences;
	private List<Department> department;
	private CandidateCv candidateCv;
	
}
