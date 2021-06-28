package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ExperiencesService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ExperiencesDao;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Experiences;
import kodlamaio.northwind.entities.concretes.Languages;

@Service
public class ExperiencesManager implements ExperiencesService{

	private ExperiencesDao experiencesDao;
	@Autowired
	public ExperiencesManager(ExperiencesDao experiencesDao) {
		super();
		this.experiencesDao = experiencesDao;
	}

	@Override
	public DataResult<List<Experiences>> getAll() {
		return new SuccessDataResult<List<Experiences>>(this.experiencesDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(Experiences experiences) {
		this.experiencesDao.save(experiences);
		return new SuccessResult("experiences eklendi");
	}

	@Override
	public DataResult<List<Experiences>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"experiences");
		return new SuccessDataResult<List<Experiences>>(this.experiencesDao.findAll(sort),"başarılı");

		

	}

	@Override
	public Result delete(int experiencesId) {
		this.experiencesDao.deleteById(experiencesId);
		return new SuccessResult("experiences silindi");
	}

	@Override
	public Result update(int experiencesId, Experiences experiences) {
		this.experiencesDao.save(experiences);
		return new SuccessResult("experiences güncellendi");
	}

	@Override
	public DataResult<List<Experiences>> getByCandidate_id(int candidate_id) {
		List<Experiences> result =  this.experiencesDao.getByCandidate_id(candidate_id);
		return new SuccessDataResult<List<Experiences>>(result);
	}

}
