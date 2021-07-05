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

import kodlamaio.northwind.business.abstracts.EmployerUpdateService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employerUpdateController")
@CrossOrigin
public class EmployerUpdateControllers {
	private EmployerUpdateService employerUpdateService;

	
	public EmployerUpdateControllers(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployerUpdate>> getAll(){
		return this.employerUpdateService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<EmployerUpdate> getByEmployerId(@RequestParam int employerId){
		return this.employerUpdateService.getByEmployerId(employerId);
	}
	
	@PostMapping("/confirm")
	public Result confirm(@RequestParam int id) {
		// TODO Auto-generated method stub
		return this.employerUpdateService.confirm(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUpdate employerUpdate) {
		return this.employerUpdateService.add(employerUpdate);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody EmployerUpdate employerUpdate) {
		return this.employerUpdateService.update(employerUpdate);
	}
	
	

}
