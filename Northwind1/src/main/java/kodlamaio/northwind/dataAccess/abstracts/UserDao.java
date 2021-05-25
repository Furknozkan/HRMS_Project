package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
