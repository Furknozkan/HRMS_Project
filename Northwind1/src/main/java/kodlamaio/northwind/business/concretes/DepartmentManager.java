package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.DepartmentService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.DepartmentDao;
import kodlamaio.northwind.entities.concretes.Department;
import kodlamaio.northwind.entities.concretes.Experiences;

@Service
public class DepartmentManager implements DepartmentService{

	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("department eklendi");
	}

	@Override
	public DataResult<List<Department>> getByCandidate_id(int candidate_id) {
		List<Department> result =  this.departmentDao.getByCandidate_id(candidate_id);
		return new SuccessDataResult<List<Department>>(result);
	}

	@Override
	public Result delete(int departmentId) {
		this.departmentDao.deleteById(departmentId);
		return new SuccessResult("department silindi");
	}

	@Override
	public Result update(int departmentId, Department department) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
