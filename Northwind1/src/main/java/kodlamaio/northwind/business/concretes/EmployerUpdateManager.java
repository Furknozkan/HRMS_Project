package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.EmployerUpdateService;
import kodlamaio.northwind.business.abstracts.EmployersService;
import kodlamaio.northwind.business.abstracts.UsersService;
import kodlamaio.northwind.core.utilities.Business.BusinnesEngine;
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
public class EmployerUpdateManager implements EmployerUpdateService{
	private EmployerUpdateDao employerUpdateDao;
	private UsersService userService;
	private EmployersService employerService;

	@Autowired
	public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao, EmployersService employerService, UsersService userService) {
		super();
		this.employerUpdateDao = employerUpdateDao;
		this.employerService = employerService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<EmployerUpdate>> getAll() {
		return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.findAll(),"data listelendi");
	}

	@Override
	public DataResult<EmployerUpdate> getByEmployerId(int id) {
		return new SuccessDataResult<EmployerUpdate>(this.employerUpdateDao.getByEmployerId(id),"data listelendi");		
	}

/*	@Override
	public Result confirm(int id) {
		Employers referance = this.employerService.findByEmployerId(id);
		EmployerUpdate newDataReferance = getNewData(id);
		
		if(newDataReferance != null) {
			Result engine = BusinnesEngine.run(existsByEmployerId(id),updateChecker(referance, newDataReferance));
			if(!engine.isSuccess()) {
				return new ErrorDataResult(null,engine.getMessage());
			}
			return new SuccessResult();
			
		}
		return new ErrorResult("güncellem isteği bulunamadı");

	}
	
	private Result existsByEmployerId(int id) {
		if(this.employerUpdateDao.existsByEmployerId(id)) {
			return new SuccessResult();
		}
		return new ErrorResult("İşveren isteği bulunamadı");
	}
	
	private Result updateChecker(Employers referance, EmployerUpdate newDataReferance) {
		if(newDataReferance.getEmployerUpdate().getCompanyName() != null && newDataReferance.getEmployerUpdate().getCompanyName() !="" ) {
			referance.setCompanyName(newDataReferance.getEmployerUpdate().getCompanyName());
		}
		if(newDataReferance.getEmployerUpdate().getEmailAddress() != null && newDataReferance.getEmployerUpdate().getEmailAddress() !="" ) {
			referance.setEmailAddress(newDataReferance.getEmployerUpdate().getEmailAddress());
		}
		if(newDataReferance.getEmployerUpdate().getPassword() != null && newDataReferance.getEmployerUpdate().getPassword() !="") {
			referance.setPassword(newDataReferance.getEmployerUpdate().getPassword());
		}
		if(newDataReferance.getEmployerUpdate().getPhoneNumber() != null && newDataReferance.getEmployerUpdate().getPhoneNumber() !="") {
			referance.setPhoneNumber(newDataReferance.getEmployerUpdate().getPhoneNumber());
		}
		if(newDataReferance.getEmployerUpdate().getWebAddress() != null && newDataReferance.getEmployerUpdate().getWebAddress() != "") {
			referance.setWebAddress(newDataReferance.getEmployerUpdate().getWebAddress());
		}
		this.employerService.update(referance);
		this.employerUpdateDao.delete(newDataReferance);
		return new SuccessResult();
	}
	
	private EmployerUpdate getNewData(int employerId) {
		return this.employerUpdateDao.getByEmployerId(employerId);
	}*/
	
	
		

	@Override
	public Result add(EmployerUpdate employerUpdate) {
		if(this.employerUpdateDao.existsByEmployerId(employerUpdate.getEmployerId())) {
			return new ErrorResult("Zaten Bekleyen bir güncelleme isteği var");
			
		}else {
			this.employerUpdateDao.save(employerUpdate);
			return new SuccessResult("başarılı");
		}
		
		
	}

	@Override
	public Result update(EmployerUpdate employerUpdate) {
		this.employerUpdateDao.save(employerUpdate);
		return new SuccessResult("başarılı");
	}

	@Override
	public Result confirm(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
