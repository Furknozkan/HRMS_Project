package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer>{
	EmployerUpdate getByEmployerId(int id);
	boolean existsByEmployerId(int id);
	EmployerUpdate getById(int employerUpdateId);

}
