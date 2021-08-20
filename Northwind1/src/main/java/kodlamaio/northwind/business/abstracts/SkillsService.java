package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Skills;

public interface SkillsService {
	DataResult<List<Skills>> getAll();
	DataResult<List<Skills>> getByCandidate_id(int candidate_id);
	Result add(Skills skill);
	Result delete(int skillId);

}
