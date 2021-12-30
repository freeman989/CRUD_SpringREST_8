package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.*;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    void deleteById(Long id);
}
