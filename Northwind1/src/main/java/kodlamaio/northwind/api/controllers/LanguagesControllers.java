package kodlamaio.northwind.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Response;
import kodlamaio.northwind.business.abstracts.LanguagesService;
import kodlamaio.northwind.business.concretes.LanguagesManager;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.dtos.LanguagesRegisterDto;

@RestController
@RequestMapping("/api/languagesService")
public class LanguagesControllers {
	
	private LanguagesService languagesService;
	
	@Autowired
	public LanguagesControllers(LanguagesService languagesService) {
		super();
		this.languagesService = languagesService;
	}

	

	
	
	@GetMapping("/getall")
	public DataResult<List<Languages>> getAll(){
		return this.languagesService.getAll();
	}
	
	
	
	

}
