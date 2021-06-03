package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CandidateCv;

public interface CandidateCvService {
	DataResult<List<CandidateCv>> getAll();
	Result add(CandidateCv candidateCv);

}
