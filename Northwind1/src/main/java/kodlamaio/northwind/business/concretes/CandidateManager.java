package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UsersService;
import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.IdentityValidation;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.CandidateDao;
import kodlamaio.northwind.entities.abstracts.User;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.CandidateCv;
import kodlamaio.northwind.entities.concretes.Employers;
import kodlamaio.northwind.entities.concretes.JobPosting;

import net.bytebuddy.asm.Advice.This;

@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		
	
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi");
		
	}
	
	

	@Override
	public Result add(Candidate candidate) {
		// TODO Auto-generated method stub
		
		if(!firstNameChecker(candidate)) {
			return new ErrorDataResult<List<Candidate>>(null,"İsim boş olamaz");
			
		}
		else if(!lastNameChecker(candidate)) {
			return new ErrorDataResult<List<Candidate>>(null,"Soy isim boş olamaz"); 
			
		}
		else if(!IdentityValidation.isRealPerson(candidate.getIdentificationNumber())) {
			return new ErrorDataResult<List<Candidate>>(null,"Kimlik doğrulanamadı");
		}
		else if(candidate.getIdentificationNumber().isBlank()){
			return new ErrorDataResult<List<Candidate>>(null,"kimlik bilgisi boş olamaz");			
		}
		else if(!birthDateChecker(candidate)) {
			return new ErrorDataResult<List<Candidate>>(null,"doğum tarihi bilgisi boş olamaz");
		}
		else if(!passwordNullChecker(candidate)) {
			return new ErrorDataResult<List<Candidate>>(null,"şifre boş olamaz");
		}
		else if(candidateDao.findAllByEmailAddress(candidate.getEmailAddress()).stream().count() != 0) {
			return new ErrorDataResult<List<Candidate>>(null,"Email zaten kayıtlı");
		}
		else if(candidateDao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream().count() != 0) {
			return new ErrorDataResult<List<Candidate>>(null,"Tc no zaten kayıtlı");
		}
		
		
		
		
		this.candidateDao.save(candidate);
		return new SuccessResult("candidate eklendi");
	}
	
	@Override
	public Result delete(int candidateId) {
		this.candidateDao.deleteById(candidateId);
		return new SuccessResult("candidate silindi");
	}

	@Override
	public Result update(int candidateId, Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("candidate güncellendi");
	}

	
	
	
	private boolean firstNameChecker(Candidate candidate) {
		if(candidate.getFirstName().isBlank() || candidate.getFirstName() == null) {
			return false ;
			
		}
		return true;
		
	}
	private boolean lastNameChecker(Candidate candidate) {
		if(candidate.getLastName().isBlank() || candidate.getLastName() == null) {
			return false; 
			
		}
		return true;
	}
	private boolean birthDateChecker(Candidate candidate) {
		if(candidate.getBirthDate().equals(null)) {
			return false;
			
		}
		return true;
	}
	private boolean passwordNullChecker(Candidate candidate) {
		if(candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<Candidate>> getByid(int id) {
		List<Candidate> candidate = this.candidateDao.getByid(id);
		return new SuccessDataResult<List<Candidate>>(candidate);
	}

	

	
	
	
}
	
	

	



	


	


