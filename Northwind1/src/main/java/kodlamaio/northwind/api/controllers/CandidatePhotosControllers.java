package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.northwind.business.abstracts.CandidatePhotoService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.CandidatePhoto;

@CrossOrigin
@RestController
@RequestMapping("/api/candidatePhotoController")
public class CandidatePhotosControllers {
	private CandidatePhotoService candidatePhotoService;

	public CandidatePhotosControllers(CandidatePhotoService candidatePhotoService) {
		super();
		this.candidatePhotoService = candidatePhotoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int candidate_id, @RequestParam MultipartFile file) {
		CandidatePhoto candidatePhoto = new CandidatePhoto();
		Candidate candidate = new Candidate();
		candidate.setId(candidate_id);
		candidatePhoto.setCandidate(candidate);
		return this.candidatePhotoService.add(candidatePhoto, file);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidatePhoto>> getAll(){
		return this.candidatePhotoService.getAll();
	}
	
	@GetMapping("/getByCandidate_id")
	public DataResult<CandidatePhoto> getByCandidate_id(int candidate_id){
		return this.candidatePhotoService.getByCandidate_id(candidate_id);
	}
}
