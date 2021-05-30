package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.JobPosting;


public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getAllSorted();
	DataResult<JobPosting> getByCompanyName(String companyName);
	
	Result add(JobPosting jobPosting);
	Result delete(JobPosting jobPosting);
	Result update(int jobPostingId, JobPosting jobPosting);
	

}
