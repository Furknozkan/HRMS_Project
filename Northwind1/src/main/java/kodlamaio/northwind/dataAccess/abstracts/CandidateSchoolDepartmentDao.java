package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentDao extends JpaRepository<CandidateSchoolDepartment, Integer>{
	List<CandidateSchoolDepartment> getByCandidate_idOrderByDateOfGraduationDesc(int candidate_id);

}
