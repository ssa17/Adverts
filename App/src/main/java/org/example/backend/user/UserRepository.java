package org.example.backend.user;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@Transactional
public interface UserRepository extends CrudRepository<User, UUID> {

    User findByUsernameAndPassword(String username, String password);

}
