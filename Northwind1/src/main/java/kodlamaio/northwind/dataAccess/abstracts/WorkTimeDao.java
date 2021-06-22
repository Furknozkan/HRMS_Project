package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.WorkTime;

public interface WorkTimeDao extends JpaRepository<WorkTime, Integer>{

}
