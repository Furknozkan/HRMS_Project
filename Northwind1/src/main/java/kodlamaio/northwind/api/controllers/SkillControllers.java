package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.SkillsService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.School;
import kodlamaio.northwind.entities.concretes.Skills;

@CrossOrigin
@RestController
@RequestMapping("/api/skillController")
public class SkillControllers {
	private SkillsService skillService;

	@Autowired
	public SkillControllers(SkillsService skillService) {
		super();
		this.skillService = skillService;
	}


	@GetMapping("/getall")
	public DataResult<List<Skills>> getAll(){
		return this.skillService.getAll();
	}
	@GetMapping("/getByCandidate_id")
	public DataResult<List<Skills>> getByCandidate_id(@RequestParam int candidate){
		return this.skillService.getByCandidate_id(candidate);
	}
	@PostMapping("/add")
	public Result add(@RequestBody Skills skill) {
		return this.skillService.add(skill);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int skillId) {
		return this.skillService.delete(skillId);
	}
	
	
}
