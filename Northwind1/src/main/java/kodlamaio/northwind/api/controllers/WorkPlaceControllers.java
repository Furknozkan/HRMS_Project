package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.WorkPlaceService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.WorkPlace;

@CrossOrigin
@RestController
@RequestMapping("/api/workPlaceContollers")
public class WorkPlaceControllers {
	private WorkPlaceService workPlaceService;

	@Autowired
	public WorkPlaceControllers(WorkPlaceService workPlaceService) {
		super();
		this.workPlaceService = workPlaceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkPlace>> getAll(){
		return this.workPlaceService.getAll();
	}
	

}
