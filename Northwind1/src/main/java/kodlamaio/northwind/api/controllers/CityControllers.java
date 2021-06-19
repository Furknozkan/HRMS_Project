package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CityService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.City;
@CrossOrigin
@RestController
@RequestMapping("/api/city")
public class CityControllers {
	private CityService cityService;

	@Autowired
	public CityControllers(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	

}
