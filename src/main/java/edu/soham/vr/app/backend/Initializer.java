package edu.soham.vr.app.backend;

import at.favre.lib.crypto.bcrypt.BCrypt;
import edu.soham.vr.app.backend.model.Password;
import edu.soham.vr.app.backend.model.User;
import edu.soham.vr.app.backend.repository.PassowrdRepository;
import edu.soham.vr.app.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Instant;
import java.util.UUID;


/**
 * @author sohamc.
 */
@Component
public class Initializer implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PassowrdRepository passowrdRepository;

    public Initializer(UserRepository userRepository, PassowrdRepository passowrdRepository) {
        this.userRepository = userRepository;
        this.passowrdRepository = passowrdRepository;
    }

    @Override
    public void run(String... strings) throws ParseException {

        String adminPassword = "admin";
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, adminPassword.toCharArray());

        Password password = new Password();
        password.setPasswordId(UUID.randomUUID().toString());
        //password.setUser(user);
        password.setPasswordHash(bcryptHashString);

        passowrdRepository.save(password);

        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setFname("Andrew");
        user.setLname("Mellon");
        user.setEmail("xyz@soham.com");
        user.setDepartment("Dark arts");
        user.setCreatedBy("admin");
        user.setCreatedTime(Instant.now());
        user.setRole("ADMIN");
        user.setDeleted(false);
        user.setCourseName("English for kids");
        user.setSession("FALL 2019");
        user.setYear("2019");
        user.setPassword(password);
        userRepository.save(user);


    }
}
