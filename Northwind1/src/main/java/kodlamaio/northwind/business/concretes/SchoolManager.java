package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.SchoolService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.SchoolDao;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	
	
	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"data listelendi");
	
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("school eklendi");
	}



	@Override
	public Result update(int schoolId, School school) {
		this.schoolDao.save(school);
		return new SuccessResult("school bilgileri güncellendi");
	}



	@Override
	public Result delete(int schoolId) {
		this.schoolDao.deleteById(schoolId);
		return new SuccessResult("school bilgileri silindi");
	}



	@Override
	public DataResult<List<School>> getByCandidate_id(int candidate_id) {
		List<School> result =  this.schoolDao.getByCandidate_id(candidate_id);
		return new SuccessDataResult<List<School>>(result);
	}

}
