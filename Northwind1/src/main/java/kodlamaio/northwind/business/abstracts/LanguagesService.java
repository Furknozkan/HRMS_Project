package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.dtos.LanguagesRegisterDto;

public interface LanguagesService {
	DataResult<List<Languages>> getAll();
	Result add(Languages languages);
	
	

}
