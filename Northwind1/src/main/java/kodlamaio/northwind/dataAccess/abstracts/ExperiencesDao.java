package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Experiences;

public interface ExperiencesDao extends JpaRepository<Experiences, Integer>{

	
	Experiences getAllByExperiences(String experiences);
}
