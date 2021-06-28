            package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.CandidateCv;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();	
	DataResult<List<Candidate>> getByid(int id);
    Result add(Candidate candidate);
    Result delete(int candidateId);
    Result update(int candidateId, Candidate candidate);
   
    

}
