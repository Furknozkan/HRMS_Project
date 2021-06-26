package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CandidateCvService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CandidateCv;
import kodlamaio.northwind.entities.concretes.JobPosting;

@CrossOrigin
@RestController
@RequestMapping("/api/candidateCvController")
public class CandidateCvControllers {
	public CandidateCvService  candidateCvService;

	@Autowired
	public CandidateCvControllers(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	@GetMapping("/getall")
	public DataResult<List<CandidateCv>> getAll(){
		return this.candidateCvService.getAll(); 
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.add(candidateCv);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("candidateCvId") int candidateCvId,
			@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.update(candidateCvId, candidateCv);
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<CandidateCv>> getByCandidate_id(@RequestParam int candidate){
		return this.candidateCvService.getByCandidate_id(candidate);
	}
	
	
	
}
