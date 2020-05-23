package edu.soham.vr.app.backend.repository;


import edu.soham.vr.app.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sohamc.
 */
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUserId(String id);

}
