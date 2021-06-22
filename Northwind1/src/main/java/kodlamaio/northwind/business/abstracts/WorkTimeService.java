package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.WorkTime;

public interface WorkTimeService {
	DataResult<List<WorkTime>> getAll();

}
