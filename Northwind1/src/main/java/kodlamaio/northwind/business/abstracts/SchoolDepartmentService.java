package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentService {
	DataResult<List<SchoolDepartment>> getAll();
	Result add(SchoolDepartment schoolDepartment);

}
