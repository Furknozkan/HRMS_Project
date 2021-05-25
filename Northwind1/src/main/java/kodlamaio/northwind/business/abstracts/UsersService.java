package kodlamaio.northwind.business.abstracts;

import java.util.List;


import org.springframework.stereotype.Service;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.abstracts.User;

public interface UsersService {
	DataResult<List<User>> getAll();
	
	Result add(User user);

}
