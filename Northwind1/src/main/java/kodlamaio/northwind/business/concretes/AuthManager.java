package kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.AuthService;
import kodlamaio.northwind.business.abstracts.CandidateCvService;
import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.business.abstracts.DepartmentService;
import kodlamaio.northwind.business.abstracts.ExperiencesService;
import kodlamaio.northwind.business.abstracts.LanguagesService;
import kodlamaio.northwind.business.abstracts.SchoolService;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.CandidateCv;
import kodlamaio.northwind.entities.concretes.Department;
import kodlamaio.northwind.entities.concretes.Experiences;
import kodlamaio.northwind.entities.concretes.Languages;
import kodlamaio.northwind.entities.concretes.School;
import kodlamaio.northwind.entities.dtos.CvAddDto;
import kodlamaio.northwind.entities.dtos.DepartmentAddDto;
import kodlamaio.northwind.entities.dtos.ExperiencesAddDto;
import kodlamaio.northwind.entities.dtos.LanguagesRegisterDto;
import kodlamaio.northwind.entities.dtos.SchoolRegisterDto;

@Service
public class AuthManager implements AuthService{

	private LanguagesService languagesService;
	private SchoolService schoolService;
	private ExperiencesService experiencesService;
	private DepartmentService departmentService;
	private CandidateService candidateService;
	private CandidateCvService candidateCvService;
	
	
	@Autowired
	public AuthManager(LanguagesService languagesService, SchoolService schoolService, ExperiencesService experiencesService, DepartmentService departmentService, CandidateService candidateService, CandidateCvService candidateCvService) {
		super();
		this.languagesService = languagesService;
		this.schoolService = schoolService;
		this.experiencesService = experiencesService;
		this.departmentService = departmentService;
		this.candidateService = candidateService;
		this.candidateCvService = candidateCvService;
	}
	
	@Override
	public Result LanguagesRegister(LanguagesRegisterDto languagesDto) {
		Result result = this.languagesService.add(new Languages(
				0,
				languagesDto.getLanguages(),
				languagesDto.getLevel(),
				null,
				null
				
				));
		
		return new SuccessResult("languages eklendi");
	}

	@Override
	public Result SchoolRegister(SchoolRegisterDto schoolDto) {
		Result result = this.schoolService.add(new School(
				0,
				schoolDto.getName(),
				schoolDto.is_graduate(),
				schoolDto.getDateOfEntry(),
				schoolDto.getDateOfGraduation(),
				null,
				null,
				null
				
				));
		return new SuccessResult("school eklendi");
	}

	@Override
	public Result ExperiencesAdd(ExperiencesAddDto experiencesDto) {
		Result result = this.experiencesService.add(new Experiences(
			0,
			experiencesDto.getExperiences(),
			experiencesDto.getStartDate(),
			experiencesDto.getEndDate(),
			experiencesDto.isWorkingNow(),
			experiencesDto.getCompanyName(),
			experiencesDto.getTitle(),
			null,
			null
			
				));
		return new SuccessResult("experiences eklendi");
	}

	@Override
	public Result DepartmentAdd(DepartmentAddDto departmentDto) {
		Result result = this.departmentService.add(new Department(
			0,
			departmentDto.getDepartmentName(),
			null,
			null,
			null
			
			
				));
		return new SuccessResult("department eklendi");
	}

	@Override
	public Result CvAdd(CvAddDto cvAddDto) {
		Result result = this.candidateCvService.add(new CandidateCv(
				0,
				null,
				cvAddDto.getOverLetter(),
				cvAddDto.getPictureUrl(),
				null,
				null,
				null,
				null,
				null
				
				
				
				
				));
		return new SuccessResult("cv eklendi");

	}

	
	

	
	
	}

	




