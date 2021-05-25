package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UsersService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.UserDao;
import kodlamaio.northwind.entities.abstracts.User;


@Service
public class UserManager implements UsersService{
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"datalar listelendi");
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		
		return new SuccessResult("user eklendi");
	}

	


	
}
