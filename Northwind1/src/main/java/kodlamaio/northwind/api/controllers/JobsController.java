package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.JobService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	private JobService jobService;
	
	
	public JobsController(JobService jobService) {
		super();
		this.jobService=jobService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();
		
	}

	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
		
	}
}
