package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Department;

public interface DepartmentDao  extends JpaRepository<Department, Integer>{

	List<Department> getByCandidate_id(int candidate_id);

}
