package kodlamaio.northwind.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Languages;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	List<Candidate> findAllByEmailAddress(String emailAddress);
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
	List<Candidate> getByid(int id);


	
}
