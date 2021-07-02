package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.SystemUserService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.SystemUserDao;
import kodlamaio.northwind.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService{
	private SystemUserDao systemUserDao;

	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao) {
		super();
		this.systemUserDao = systemUserDao;
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {
		List<SystemUser> systemUser = this.systemUserDao.findAll();
		return new SuccessDataResult<List<SystemUser>>(systemUser,"Data Listelendi");
		
	}

	@Override
	public Result update(SystemUser systemUser) {
		this.systemUserDao.save(systemUser);
		return new SuccessResult("başarılı");
		
	}

}
