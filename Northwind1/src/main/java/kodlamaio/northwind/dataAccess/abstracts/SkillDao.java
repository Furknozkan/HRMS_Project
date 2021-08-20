package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Skills;

public interface SkillDao extends JpaRepository<Skills, Integer>{

	List<Skills> getByCandidate_id(int candidate_id);

}
