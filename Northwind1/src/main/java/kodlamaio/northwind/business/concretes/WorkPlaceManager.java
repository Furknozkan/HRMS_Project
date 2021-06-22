package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.WorkPlaceService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.WorkPlaceDao;
import kodlamaio.northwind.entities.concretes.WorkPlace;


@Service
public class WorkPlaceManager implements WorkPlaceService{

	private WorkPlaceDao workPlaceDao;
	
	@Autowired
	public WorkPlaceManager(WorkPlaceDao workPlaceDao) {
		super();
		this.workPlaceDao = workPlaceDao;
	}

	@Override
	public DataResult<List<WorkPlace>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WorkPlace>>(this.workPlaceDao.findAll(),"data listelendi");
	}

}
