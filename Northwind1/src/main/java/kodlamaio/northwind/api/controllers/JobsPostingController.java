package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.JobPostingService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Employers;
import kodlamaio.northwind.entities.concretes.JobPosting;
import kodlamaio.northwind.entities.dtos.JobPostingsFilterDto;
import kodlamaio.northwind.business.concretes.JobPostingManager;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("api/jobsposting")
@CrossOrigin
public class JobsPostingController {
	private JobPostingService jobPostingService;

	@Autowired
	public JobsPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@GetMapping("/getByEnable")
	public DataResult<List<JobPosting>> getByEnable(){
		return this.jobPostingService.getByEnable();
	}

	@GetMapping("/getByEnablePage")
	public DataResult<List<JobPosting>> getByEnable(int pageNo, int pageSize) {
		return this.jobPostingService.getByEnable(pageNo - 1, pageSize);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("jobPostingId") int jobPostingId,
			@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.update(jobPostingId, jobPosting);
	}
			
			
	
	
	
	@GetMapping("/getAllDesc")
	public DataResult<List<JobPosting>> getAllSorted(){
		return this.jobPostingService.getAllSorted();
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<JobPosting> getByCompanyName(@RequestParam String companyName){
		return this.jobPostingService.getByCompanyName(companyName);
	}
	
	@PostMapping("/getByEnableAndPageNumberAndFilter")
    public Result getByEnableAndPageNumberAndFilter(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobPostingsFilterDto jobPostingsFilter){
        return jobPostingService.getByEnableAndPageNumberAndFilter(pageNo, pageSize, jobPostingsFilter);
    }
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobPosting>> getByEmployerId(@RequestParam int employerId){
		return jobPostingService.getByEmployerId(employerId);
		
	}
}
