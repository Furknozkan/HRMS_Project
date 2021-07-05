package kodlamaio.northwind.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.EmployersService;
import kodlamaio.northwind.business.abstracts.UsersService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.ErrorResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.northwind.dataAccess.abstracts.EmployersDao;
import kodlamaio.northwind.entities.concretes.EmployerUpdate;
import kodlamaio.northwind.entities.concretes.Employers;
@Service
public class EmployersManager implements EmployersService{
	private EmployersDao employersDao;
	private UsersService userService;
	private EmployerUpdateDao employerUpdateDao;
	
	
	@Autowired
	public EmployersManager(EmployersDao employersDao, UsersService userService, EmployerUpdateDao employerUpdateDao) {
		super();
		this.employersDao=employersDao;
		this.userService=userService;
		this.employerUpdateDao=employerUpdateDao;
		
	}
	@Override
	public DataResult<List<Employers>> getAll() {
		// TODO Auto-generated method stub
		
		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll(),"datalar listelendi");
	}
	
	
	
	
	@Override
	public Result add(Employers employers) {
		
		if(!companyNameChecker(employers)) {
			return new ErrorDataResult<List<Employers>>(null,"şirket adı doldurulmak zorundadır");
		}
		else if(!webSiteChecker(employers)) {
			return new ErrorDataResult<List<Employers>>(null,"web site adresi doldurulmak zorundadır");
			
		}
		else if(!isRealEmployer(employers)) {
			return new ErrorDataResult<List<Employers>>(null,"geçersiz E-Mail adresi");
			
		}
		else if(!passwordNullChecker(employers)) {
			return new ErrorDataResult<List<Employers>>(null,"şifre bilgisi boş olamaz");
			
		}
		else if(!isRealPhoneNumber(employers)) {
			return new ErrorDataResult<List<Employers>>(null,"Telefon numarası geçersiz");
			
		}
		else if(!isEmailAlreadyRegistered(employers)) {
			return new ErrorDataResult<List<Employers>>(null,"girmiş olduğunuz E-Mail zaten kayıtlı");
			
		}
		
		
		
		
		this.employersDao.save(employers);
		return new SuccessResult("employers eklendi");
	}
	
	
	private boolean companyNameChecker(Employers employers) {
		if(employers.getCompanyName().isBlank() || employers.getWebAddress() == null) {
			return false;
			
		}
		return true;
		
	}
	private boolean webSiteChecker(Employers employers) {
		if(employers.getWebAddress().isBlank() || employers.getWebAddress() == null) {
			return false;
			
		}
		return true;
	}
	private boolean isRealEmployer(Employers employers) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employers.getEmailAddress());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     else if(!employers.getEmailAddress().contains(employers.getWebAddress())) {
	    	 return false;
	    	 
	     }
	     return true;
		
	}
	private boolean passwordNullChecker(Employers employers) {
		if(employers.getPassword().isBlank() || employers.getPassword() == null) {
			return false;
			
		}
		return true;
		
	}
	private boolean isRealPhoneNumber(Employers employers) {
		String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employers.getPhoneNumber());
		if(!matcher.matches()) {
			return false;
		}
		return true;
		
	}
	private boolean isEmailAlreadyRegistered(Employers employers) {
		if(employers.getCompanyName().isBlank() || employers.getCompanyName() == null) {
			return false;
			
		}
		return true;
		
	}
	
	@Override
	public DataResult<Employers> getById(int id) {
		
		if(this.employersDao.existsById(id)) {
			return new SuccessDataResult<Employers>(this.employersDao.getById(id),"data listelendi");
		}
		return new ErrorDataResult<>("İşveren bulunamadı");
		}
	
	@Override
	public Employers findByEmployerId(int id) {
		// TODO Auto-generated method stub
		return this.employersDao.getById(id);
	}
	
	@Override
	public Employers getByEmployerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result update(EmployerUpdate employerUpdate) {
		employerUpdate.setId(0);
		
		Employers employer = this.employersDao.getById(employerUpdate.getEmployerId());
		this.employerUpdateDao.save(employerUpdate);
		employer.setEnableWaitingUpdate(true);
		return new SuccessResult("güncelleme için onay bekleniyor");
	}
	@Override
	public Result verifyUpdate(int employerUpdateId) {
		if(!this.employerUpdateDao.existsById(employerUpdateId)) {
			return new ErrorResult("güncelleme talebi bulunamadı");
			
		}
		EmployerUpdate employerUpdate = this.employerUpdateDao.getById(employerUpdateId);
		Employers employer = this.employersDao.getById(employerUpdate.getEmployerId());
		
		employerUpdate.setVerifyed(true);
		this.employerUpdateDao.save(employerUpdate);
		
		employer.setEmailAddress(employerUpdate.getEmployerUpdate().getEmailAddress());
		employer.setCompanyName(employerUpdate.getEmployerUpdate().getCompanyName());
		employer.setPhoneNumber(employerUpdate.getEmployerUpdate().getPhoneNumber());
		employer.setWebAddress(employerUpdate.getEmployerUpdate().getWebAddress());
		employer.setEnableWaitingUpdate(false);
		this.employersDao.save(employer);
		return new SuccessResult("Bilgiler Güncellendi");
	}
	

}
