package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.WorkPlace;

public interface WorkPlaceDao extends JpaRepository<WorkPlace, Integer>{

}
