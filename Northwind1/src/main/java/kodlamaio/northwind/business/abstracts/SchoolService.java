package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAll();
	DataResult<List<School>> getByCandidate_id(int candidate_id);
	Result add(School school);
	Result update(int schoolId, School school);
	Result delete(int schoolId);
}
