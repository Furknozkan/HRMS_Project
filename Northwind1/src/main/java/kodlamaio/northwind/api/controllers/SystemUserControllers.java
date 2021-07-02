package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.SystemUserService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemUserController")
@CrossOrigin
public class SystemUserControllers {
	private SystemUserService systemUserService;

	@Autowired
	public SystemUserControllers(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll(){
		return this.systemUserService.getAll();
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody SystemUser systemUser) {
		return this.systemUserService.update(systemUser);
	}

}
