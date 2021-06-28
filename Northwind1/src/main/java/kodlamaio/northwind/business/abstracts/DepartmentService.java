package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Department;
import kodlamaio.northwind.entities.concretes.Experiences;

public interface DepartmentService {
	DataResult<List<Department>> getAll();
	DataResult<List<Department>> getByCandidate_id(int candidate_id);
	Result add(Department department);
	Result delete(int departmentId);
	Result update(int departmentId, Department department);

}
