package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CandidateSchoolDepartment;

public interface CandidateSchoolDepartmentService {
	DataResult<List<CandidateSchoolDepartment>> getAll();
	Result add(CandidateSchoolDepartment candidateSchoolDepartment);
	DataResult<List<CandidateSchoolDepartment>> getByCandidate_idOrderByDateOfGraduationDesc(int candidate_id);

}
