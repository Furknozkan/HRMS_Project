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

import kodlamaio.northwind.business.abstracts.DepartmentService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.entities.concretes.Department;
import kodlamaio.northwind.entities.concretes.Languages;
@CrossOrigin
@RestController
@RequestMapping("/api/departmentController")
public class DepartmentControllers {
	private DepartmentService departmentService;

	@Autowired
	public DepartmentControllers(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Department>> getAll(){
		return this.departmentService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<List<Department>> getByCandidate_id(@RequestParam int candidate){
		return this.departmentService.getByCandidate_id(candidate);
	}
	@PostMapping("/add")
	public Result add(@RequestBody Department department) {
		return this.departmentService.add(department);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int departmentId) {
		return this.departmentService.delete(departmentId);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("departmentId") int departmentId,
			@RequestBody Department department
			) {
		return this.departmentService.update(departmentId, department);
	}
}
