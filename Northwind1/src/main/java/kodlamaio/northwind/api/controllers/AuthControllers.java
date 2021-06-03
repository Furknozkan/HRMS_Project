package kodlamaio.northwind.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.AuthService;
import kodlamaio.northwind.business.concretes.AuthManager;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.dtos.DepartmentAddDto;
import kodlamaio.northwind.entities.dtos.ExperiencesAddDto;
import kodlamaio.northwind.entities.dtos.LanguagesRegisterDto;
import kodlamaio.northwind.entities.dtos.SchoolRegisterDto;

@RestController
@RequestMapping("/api/authController")
public class AuthControllers {
		
	private AuthManager authManager;
	
	@Autowired
	public AuthControllers(AuthManager authManager) {
		super();
		this.authManager = authManager;
	}


	@PostMapping("languages/register")
	public ResponseEntity<?> languagesRegister(
		@Valid @RequestBody LanguagesRegisterDto languagesDto){
		Result result = this.authManager.LanguagesRegister(languagesDto);
		return ResponseEntity.ok(result);
	}
	@PostMapping("school/register")
	public ResponseEntity<?> SchoolRegister(
		@Valid @RequestBody SchoolRegisterDto schoolDto){
			Result result = this.authManager.SchoolRegister(schoolDto);
			return ResponseEntity.ok(result);
		}
	@PostMapping("experiences/add")
	public ResponseEntity<?> ExperiencesAdd(
		@Valid @RequestBody ExperiencesAddDto experiencesDto){
		Result result = this.authManager.ExperiencesAdd(experiencesDto);
		return ResponseEntity.ok(result);
	}
	@PostMapping("department/add")
	public ResponseEntity<?> DepartmentAdd(
		@Valid @RequestBody DepartmentAddDto departmentDto){
		Result result = this.authManager.DepartmentAdd(departmentDto);
		return ResponseEntity.ok(result);
	}
	
	
}
