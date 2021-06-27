package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Experiences;

public interface ExperiencesService {

	DataResult<List<Experiences>> getAll();
	DataResult<List<Experiences>> getAllSorted();
	Result add(Experiences experiences);
	Result delete(int experiencesId);
	Result update(int experiencesId, Experiences experiences);
}
