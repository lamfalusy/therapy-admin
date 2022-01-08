package hu.lamsoft.therapyadmin.web.persistence;

import hu.lamsoft.therapyadmin.web.persistence.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for User related operations.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByName(String name);
    
}
