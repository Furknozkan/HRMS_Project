package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAll();
	Result add(School school);
	Result update(int schoolId, School school);
	Result delete(int schoolId);
}
