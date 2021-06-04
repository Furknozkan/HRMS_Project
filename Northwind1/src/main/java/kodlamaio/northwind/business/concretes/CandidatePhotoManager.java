package kodlamaio.northwind.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.northwind.business.abstracts.CandidatePhotoService;
import kodlamaio.northwind.core.utilities.helpers.imageHelper.ImageUploadService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidatePhotoDao;
import kodlamaio.northwind.entities.concretes.CandidatePhoto;

@Service
public class CandidatePhotoManager implements CandidatePhotoService{

	private CandidatePhotoDao candidatePhotoDao;
	private ImageUploadService imageUploadService;
	
	
	
	
	@Autowired
	
	public CandidatePhotoManager(CandidatePhotoDao candidatePhotoDao, ImageUploadService imageUploadService) {
		super();
		this.candidatePhotoDao = candidatePhotoDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public DataResult<List<CandidatePhoto>> getAll() {
		List<CandidatePhoto> candidatePhoto = this.candidatePhotoDao.findAll();
		return new SuccessDataResult<List<CandidatePhoto>>(candidatePhoto);
	}

	@Override
	public DataResult<CandidatePhoto> getByCandidate_id(int candidate_id) {
		CandidatePhoto candidatePhoto = this.candidatePhotoDao.getByCandidate_id(candidate_id);
		return new SuccessDataResult<CandidatePhoto>(candidatePhoto);
	}

	@Override
	public Result add(CandidatePhoto candidatePhoto) {
		this.candidatePhotoDao.save(candidatePhoto );
		return new SuccessResult("candidate photo eklendi");
	}

	@Override
	public Result add(CandidatePhoto candidatePhoto, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageUploadService.save(file).getData();
	String url = result.get("url");
	
	candidatePhoto.setPhototUrl(url);
		candidatePhoto.setUploatedDate(LocalDate.now());
	   
	
	return add(candidatePhoto);
	}

	
}
