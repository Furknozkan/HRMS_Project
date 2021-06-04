package kodlamaio.northwind.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CandidatePhoto;

public interface CandidatePhotoService {
	DataResult<List<CandidatePhoto>> getAll();
	DataResult<CandidatePhoto> getByCandidate_id(int candidate_id);
	Result add(CandidatePhoto candidatePhoto);
	Result add(CandidatePhoto candidatePhoto, MultipartFile file);

}
