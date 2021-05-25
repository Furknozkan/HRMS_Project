package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.JobService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.JobDao;
import kodlamaio.northwind.entities.concretes.Job;
@Service
public class JobManager implements JobService{
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao=jobDao;
			
	}
	
	@Override
	public DataResult<List<Job> > getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Job>>(jobDao.findAll());
	}

	@Override
	public Result add(Job job) {
		if(jobDao.findAllByTitle(job.getTitle()).stream().count() !=0 ) {
			return new ErrorDataResult<Job>(null,"bu iş pozisyonu zaten kayıtlı ");
			
		}
		
		
		
		this.jobDao.save(job);
			
		return new SuccessResult("Job eklendi");
	}

}
