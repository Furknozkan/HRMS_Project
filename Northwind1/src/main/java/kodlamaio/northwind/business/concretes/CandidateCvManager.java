package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.CandidateCvService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.northwind.entities.concretes.CandidateCv;

@Service
public class CandidateCvManager implements CandidateCvService{

	private CandidateCvDao candidateCvDao;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		super();
		this.candidateCvDao = candidateCvDao;
	}


	@Override
	public DataResult<List<CandidateCv>> getByCandidate_id(int candidate) {
		List<CandidateCv> candidateCv = this.candidateCvDao.getByCandidate_id(candidate);
		return new SuccessDataResult<List<CandidateCv>>(candidateCv);
		
	}


	@Override
	public DataResult<List<CandidateCv>> getAll() {
		List<CandidateCv> candidateCv = this.candidateCvDao.findAll();
		return new SuccessDataResult<List<CandidateCv>>(candidateCv);
		
	}


	@Override
	public Result add(CandidateCv candidateCv) {
		this.candidateCvDao.save(candidateCv);
		return new SuccessResult("Candidate Cv eklendi");
	}


	
}
