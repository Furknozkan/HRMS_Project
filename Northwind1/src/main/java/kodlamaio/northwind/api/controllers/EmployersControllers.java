package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.northwind.business.abstracts.EmployersService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.EmployerUpdate;
import kodlamaio.northwind.entities.concretes.Employers;

@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersControllers {
	private EmployersService employersService;

	@Autowired
	public EmployersControllers(EmployersService employersService) {
		super();
		this.employersService = employersService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<Employers>>  getAll(){
		
		return this.employersService.getAll();
		
	}
	
	@GetMapping("/getbyid")
	public DataResult<Employers> getById(@RequestParam int id){
		return this.employersService.getById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employers employers) {
		return this.employersService.add(employers);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody EmployerUpdate employerUpdate){
		Result result = this.employersService.update(employerUpdate);
		if(result.isSuccess()) {
			return ResponseEntity.ok(result);
			
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PutMapping("/verifyUpdate")
	public ResponseEntity<?> verifyUpdate(@RequestParam int employerUpdateId){
		Result result = this.employersService.verifyUpdate(employerUpdateId);
		if(result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	
	
}
