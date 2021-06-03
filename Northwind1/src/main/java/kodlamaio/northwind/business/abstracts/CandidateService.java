package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Candidate;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();
    Result add(Candidate candidate);
   
    

}
