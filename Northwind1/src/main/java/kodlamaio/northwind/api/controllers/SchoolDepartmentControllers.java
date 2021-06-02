package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.SchoolDepartmentService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.SchoolDepartment;

@RestController
@RequestMapping("/api/schoolDepartmentController")
public class SchoolDepartmentControllers {
	private SchoolDepartmentService schoolDepartmentService;

	@Autowired
	public SchoolDepartmentControllers(SchoolDepartmentService schoolDepartmentService) {
		super();
		this.schoolDepartmentService = schoolDepartmentService;
	}
	@GetMapping("/getall")
	public DataResult<List<SchoolDepartment>> getAll(){
		return this.schoolDepartmentService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody SchoolDepartment schoolDepartment) {
		return this.schoolDepartmentService.add(schoolDepartment);
	}
	

}
