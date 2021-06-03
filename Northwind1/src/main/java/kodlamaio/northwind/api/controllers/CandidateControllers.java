package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Candidate;


@RestController
@RequestMapping("/api/candidate")
public class CandidateControllers {
	private CandidateService candidateService;

	public CandidateControllers(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>>  getAll(){
		
		return this.candidateService.getAll();
		
	}
	

	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this. candidateService.add(candidate);
	}
	
	



}
