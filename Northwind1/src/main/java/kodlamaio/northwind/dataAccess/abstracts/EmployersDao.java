package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{

}
