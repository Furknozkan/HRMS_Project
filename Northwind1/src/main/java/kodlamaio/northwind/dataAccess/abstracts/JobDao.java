package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

	List<Job> findAllByTitle(String title);
}
