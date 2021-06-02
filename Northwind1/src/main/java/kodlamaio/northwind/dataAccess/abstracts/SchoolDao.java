package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	
}
