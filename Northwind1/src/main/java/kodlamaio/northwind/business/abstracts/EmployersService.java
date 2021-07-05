package kodlamaio.northwind.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.EmployerUpdate;
import kodlamaio.northwind.entities.concretes.Employers;


public interface EmployersService {
	DataResult<List<Employers>>  getAll();
	DataResult<Employers> getById(int id);
	Employers findByEmployerId(int id);
	Result add(Employers employers);
	Result update(EmployerUpdate employerUpdate);
	Employers getByEmployerId(int id);
	Result verifyUpdate(int employerUpdateId );
}
