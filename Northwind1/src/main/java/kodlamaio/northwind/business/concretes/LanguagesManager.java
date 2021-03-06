package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.northwind.business.abstracts.LanguagesService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.LanguagesDao;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.dtos.LanguagesRegisterDto;

@Service
public class LanguagesManager implements LanguagesService{

	
	private LanguagesDao languagesDao; 
	

	@Autowired
	public LanguagesManager(LanguagesDao languagesDao) {
		super();
		this.languagesDao = languagesDao;
	}

	
	
	@Override
	public DataResult<List<Languages>> getAll() {
		return new SuccessDataResult<List<Languages>>(this.languagesDao.findAll(),"data listelendi");
	}


	@Override
	public Result add(Languages languages) {
		this.languagesDao.save(languages);
		return new SuccessResult("languages eklendi");
	}



	@Override
	public DataResult<List<Languages>> getByCandidate_id(int candidate_id) {
		List<Languages> result =  this.languagesDao.getByCandidate_id(candidate_id);
		return new SuccessDataResult<List<Languages>>(result);
	}



	@Override
	public Result delete(int languagesId) {
		this.languagesDao.deleteById(languagesId);
		return new SuccessResult("Languages Silindi");
	}



	@Override
	public Result update(int languagesId, Languages languages) {
		this.languagesDao.save(languages);
		return new SuccessResult("languages bilgileri güncellendi");
	}

}
