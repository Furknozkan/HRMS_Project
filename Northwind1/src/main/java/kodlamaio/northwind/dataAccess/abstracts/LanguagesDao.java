package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{
	

}
