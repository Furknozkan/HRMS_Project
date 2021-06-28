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
import kodlamaio.northwind.business.abstracts.ExperiencesService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Experiences;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.concretes.School;

@CrossOrigin
@RestController
@RequestMapping("/api/experiences")
public class ExperiencesControllers {
	private ExperiencesService experiencesService;

	

	public ExperiencesControllers(ExperiencesService experiencesService) {
		super();
		this.experiencesService = experiencesService;
	}



	@GetMapping("/getall")
	public DataResult<List<Experiences>> getAll(){
		return this.experiencesService.getAll();
		
	}
	@GetMapping("/getByCandidate_id")
	public DataResult<List<Experiences>> getByCandidate_id(@RequestParam int candidate){
		return this.experiencesService.getByCandidate_id(candidate);
	}
	
	
	
	@GetMapping("/getAllByDesc")
	public DataResult<List<Experiences>> getAllSorted(){
		return this.experiencesService.getAllSorted();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Experiences experiences) {
		return this.experiencesService.add(experiences);
		 
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int experiencesId) {
		return this.experiencesService.delete(experiencesId);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("experiencesId") int experiencesId,
			@RequestBody Experiences experiences
			) {
		return this.experiencesService.update(experiencesId, experiences);
	}
}
