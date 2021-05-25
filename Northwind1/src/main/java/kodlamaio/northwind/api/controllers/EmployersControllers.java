package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.EmployersService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Employers;

@RestController
@RequestMapping("/api/employers")
public class EmployersControllers {
	private EmployersService employersService;

	public EmployersControllers(EmployersService employersService) {
		super();
		this.employersService = employersService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<Employers>>  getAll(){
		
		return this.employersService.getAll();
		
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employers employers) {
		return this.employersService.add(employers);
		
	}
}
