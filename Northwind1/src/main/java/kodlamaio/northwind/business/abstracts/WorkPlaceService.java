package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.WorkPlace;

public interface WorkPlaceService {
	DataResult<List<WorkPlace>> getAll();

}
