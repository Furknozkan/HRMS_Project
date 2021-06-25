package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CandidateCv;

public interface CandidateCvService {
	DataResult<List<CandidateCv>> getAll();
	DataResult<List<CandidateCv>> getByCandidate_id(int candidate);
	Result add(CandidateCv candidateCv);
	Result update(int candidateCvId, CandidateCv candidateCv);

}
