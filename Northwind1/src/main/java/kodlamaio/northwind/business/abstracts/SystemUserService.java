package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.SystemUser;


public interface SystemUserService {
	DataResult<List<SystemUser>> getAll();
	
	Result update(SystemUser systemUser);

}
