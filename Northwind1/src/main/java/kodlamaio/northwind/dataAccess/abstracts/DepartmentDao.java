package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Department;

public interface DepartmentDao  extends JpaRepository<Department, Integer>{

}
