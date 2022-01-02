package hu.lamsoft.therapyadmin.web.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.therapyadmin.web.persistence.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByName(String name);
	
}
