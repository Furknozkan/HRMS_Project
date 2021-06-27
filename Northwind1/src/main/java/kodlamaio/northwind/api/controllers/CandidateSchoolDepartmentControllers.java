package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CandidateSchoolDepartmentService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CandidateSchoolDepartment;

@CrossOrigin
@RestController
@RequestMapping("/api/candidateschooldepartment")
public class CandidateSchoolDepartmentControllers {

	private CandidateSchoolDepartmentService candidateSchoolDepartmentService;

	@Autowired
	public CandidateSchoolDepartmentControllers(CandidateSchoolDepartmentService candidateSchoolDepartmentService) {
		super();
		this.candidateSchoolDepartmentService = candidateSchoolDepartmentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateSchoolDepartment>> getAll(){
		return this.candidateSchoolDepartmentService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchoolDepartment candidateSchoolDepartment) {
		return this.candidateSchoolDepartmentService.add(candidateSchoolDepartment);
		
	}
	@GetMapping("/getByCandidate_idOrderByDateOfGraduationDesc")
	public DataResult<List<CandidateSchoolDepartment>> getByCandidate_idOrderByDateOfGraduationDesc(@RequestParam int candidate_id){
	
		return this.candidateSchoolDepartmentService.getByCandidate_idOrderByDateOfGraduationDesc(candidate_id);
	}
	
}
