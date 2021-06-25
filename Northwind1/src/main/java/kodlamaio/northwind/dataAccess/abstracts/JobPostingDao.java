package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	
	JobPosting getByCompanyName(String companyName);
	
	List<JobPosting> getByEnableTrue();
	List<JobPosting> getByEnableTrue(Pageable pageable);

	

}
