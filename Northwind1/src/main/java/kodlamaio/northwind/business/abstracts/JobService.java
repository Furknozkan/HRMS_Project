package kodlamaio.northwind.business.abstracts;

import java.util.List;


import org.springframework.stereotype.Service;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Job;


public interface JobService {

	DataResult<List<Job>> getAll();
	
	Result add(Job job);
	
	
	

}
