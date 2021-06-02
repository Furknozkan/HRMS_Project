package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.CandidateSchoolDepartmentService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidateSchoolDepartmentDao;
import kodlamaio.northwind.entities.concretes.CandidateSchoolDepartment;

@Service
public class CandidateSchoolDepartmentManager implements CandidateSchoolDepartmentService{

	private CandidateSchoolDepartmentDao candidateSchoolDepartmentDao;
	
	
	@Autowired
	public CandidateSchoolDepartmentManager(CandidateSchoolDepartmentDao candidateSchoolDepartmentDao) {
		super();
		this.candidateSchoolDepartmentDao = candidateSchoolDepartmentDao;
	}

	@Override
	public DataResult<List<CandidateSchoolDepartment>> getAll() {
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(this.candidateSchoolDepartmentDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(CandidateSchoolDepartment candidateSchoolDepartment) {
		this.candidateSchoolDepartmentDao.save(candidateSchoolDepartment);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<List<CandidateSchoolDepartment>> getByCandidate_idOrderByDateOfGraduationDesc(int candidate_id) {
		List<CandidateSchoolDepartment> candidateSchoolDepartments = this.candidateSchoolDepartmentDao.getByCandidate_idOrderByDateOfGraduationDesc(candidate_id);
		return new SuccessDataResult<List<CandidateSchoolDepartment>>(candidateSchoolDepartments);
	}

}
