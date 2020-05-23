package edu.soham.vr.app.backend.repository;


import edu.soham.vr.app.backend.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sohamc.
 */
public interface PassowrdRepository extends JpaRepository<Password, String> {

    Password findPasswordByPasswordId(String id);
}
