package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.SchoolService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.JobPosting;
import kodlamaio.northwind.entities.concretes.School;

@CrossOrigin
@RestController
@RequestMapping("/api/schoolController")
public class SchoolControllers {
	private SchoolService schoolService;

	@Autowired
	public SchoolControllers(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("schoolId") int schoolId,
			@RequestBody School school
			) {
		return this.schoolService.update(schoolId, school);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int schoolId) {
		return this.schoolService.delete(schoolId);
	}
	
}
