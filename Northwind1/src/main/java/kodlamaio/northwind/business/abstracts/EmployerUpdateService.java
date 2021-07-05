package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
	DataResult<List<EmployerUpdate>> getAll();
	DataResult<EmployerUpdate> getByEmployerId(int id);
	Result update(EmployerUpdate employerUpdate);
	Result confirm(int id);
	Result add(EmployerUpdate employerUpdate);
	

}
