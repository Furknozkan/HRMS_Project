package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.dtos.DepartmentAddDto;
import kodlamaio.northwind.entities.dtos.ExperiencesAddDto;
import kodlamaio.northwind.entities.dtos.LanguagesRegisterDto;
import kodlamaio.northwind.entities.dtos.SchoolRegisterDto;

public interface AuthService {
	Result LanguagesRegister(LanguagesRegisterDto languagesDto);
	Result SchoolRegister(SchoolRegisterDto schoolDto);
	Result ExperiencesAdd(ExperiencesAddDto experiencesDto);
	Result DepartmentAdd(DepartmentAddDto departmentDto );
	
	

}
