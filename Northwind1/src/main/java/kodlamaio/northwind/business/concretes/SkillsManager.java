package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.SkillsService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.SkillDao;
import kodlamaio.northwind.entities.concretes.School;
import kodlamaio.northwind.entities.concretes.Skills;

@Service
public class SkillsManager implements SkillsService{

	private SkillDao skillDao;
	
	@Autowired
	public SkillsManager(SkillDao skillDao) {
		super();
		this.skillDao=skillDao;
	}
	
	@Override
	public DataResult<List<Skills>> getAll() {
		return new SuccessDataResult<List<Skills>>(this.skillDao.findAll(),"data listelendi");
	}

	@Override
	public DataResult<List<Skills>> getByCandidate_id(int candidate_id) {
		List<Skills> result =  this.skillDao.getByCandidate_id(candidate_id);
		return new SuccessDataResult<List<Skills>>(result);
	}

	@Override
	public Result add(Skills skill) {
		this.skillDao.save(skill);
		return new SuccessResult("skill eklendi");
	}

	@Override
	public Result delete(int skillId) {
		this.skillDao.deleteById(skillId);
		return new SuccessResult("skill bilgileri silindi");
	}

}
