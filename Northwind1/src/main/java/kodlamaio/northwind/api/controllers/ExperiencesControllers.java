package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.business.abstracts.ExperiencesService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Experiences;

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
	
	
	
	@GetMapping("/getAllByDesc")
	public DataResult<List<Experiences>> getAllSorted(){
		return this.experiencesService.getAllSorted();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Experiences experiences) {
		return this.experiencesService.add(experiences);
	}
}
