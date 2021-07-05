package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
	Employers getById(int id);

	boolean existsById(int id);

}
