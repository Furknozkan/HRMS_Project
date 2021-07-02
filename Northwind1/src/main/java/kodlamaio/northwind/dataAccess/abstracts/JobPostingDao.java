package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import kodlamaio.northwind.entities.concretes.JobPosting;
import kodlamaio.northwind.entities.dtos.JobPostingsFilterDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	
	JobPosting getByCompanyName(String companyName);
	
	List<JobPosting> getByEnableTrue();
	List<JobPosting> getByEnableTrue(Pageable pageable);
	
	@Query("Select j from kodlamaio.northwind.entities.concretes.JobPosting j where "
			+ "((:#{#filter.cityId}) IS NULL OR j.city.city_id IN (:#{#filter.cityId}))"
			+" and ((:#{#filter.workPlaceId}) IS NULL OR j.workPlace.WorkPlaceId IN (:#{#filter.workPlaceId}))"
			+" and ((:#{#filter.workTimeId}) IS NULL OR j.workTime.workTimeId IN (:#{#filter.workTimeId}))"
			+" and j.enable=true"
			)
		public Page<JobPosting> getByFilter(@Param("filter") JobPostingsFilterDto jobPostingsFilter, Pageable pageable);

	
}
