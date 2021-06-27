package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.School;

@CrossOrigin
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
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("candidateId") int candidateId,
			@RequestBody Candidate candidate
			) {
		return this.candidateService.update(candidateId, candidate);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int candidateId) {
		return this.candidateService.delete(candidateId);
		
	}



}
