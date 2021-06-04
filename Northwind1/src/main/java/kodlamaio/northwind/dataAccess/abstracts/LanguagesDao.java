package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{
	List<Languages> getByCandidate_id(int candidate_id);

	
}
