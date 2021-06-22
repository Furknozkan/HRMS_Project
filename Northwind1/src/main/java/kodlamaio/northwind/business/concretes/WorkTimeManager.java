package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.WorkTimeService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.northwind.entities.concretes.WorkTime;


@Service
public class WorkTimeManager implements WorkTimeService{
	private WorkTimeDao workTimeDao;

	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		super();
		this.workTimeDao = workTimeDao;
	}

	@Override
	public DataResult<List<WorkTime>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.findAll(),"datalar listelendi");
	}

}
