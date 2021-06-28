package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

	List<School> getByCandidate_id(int candidate_id);
	
	
}
