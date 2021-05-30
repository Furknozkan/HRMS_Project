package kodlamaio.northwind.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.JobPostingService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.JobPostingDao;
import kodlamaio.northwind.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"datalar listelendi");
	}

	@Override
	public Result add(JobPosting jobPosting) {
		
		if(!JobNameChecker(jobPosting)) {
			return new ErrorDataResult<List<JobPosting>>(null,"job name kısmı boş olamaz");
		}
		else if(!JobDescriptionChecker(jobPosting)) {
			return new ErrorDataResult<List<JobPosting>>(null,"job description kısmı boş olamaz");
		}
		else if(!JobCityİdChecker(jobPosting)) {
			return new ErrorDataResult<List<JobPosting>>(null,"job city id boş bırakılamaz");
		}
		
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("job posting eklendi");
	}
	
	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("job posting silindi");
	}

	
	
	

	private boolean JobNameChecker(JobPosting jobPosting) {
		if(jobPosting.getJobName().isBlank() || jobPosting.getJobName() == null) {
			return false;
		}
		return true;
	}
	
	private boolean JobDescriptionChecker(JobPosting jobPosting) {
		if(jobPosting.getJobDescription().isBlank() || jobPosting.getJobDescription() == null) {
			return false;
		}
		return true;
	}
	private boolean JobCityİdChecker(JobPosting jobPosting) {
//		if(jobPosting.getCityİd().isBlank() || jobPosting.getCityİd() == null) {
//			return false; 
		//}
		return true;
	}

	@Override
	public DataResult<List<JobPosting>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"jobName");
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort),"başarılı");

	}

	@Override
	public DataResult<JobPosting> getByCompanyName(String companyName) {
		return new SuccessDataResult<JobPosting>
		(this.jobPostingDao.getByCompanyName(companyName),"data listelendi");
	}

	@Override
	public Result update(int jobPostingId, JobPosting jobPosting) {
		JobPosting Result = this.jobPostingDao.getOne(jobPostingId);
		Result.setEnable(jobPosting.isEnable());
		if(jobPosting.getApplicationDeadline().isBefore(LocalDate.now())) {
			jobPosting.setEnable(false);
			
		}
		this.jobPostingDao.save(Result);
		return new SuccessResult("başarılı");
	}

	
	

}
