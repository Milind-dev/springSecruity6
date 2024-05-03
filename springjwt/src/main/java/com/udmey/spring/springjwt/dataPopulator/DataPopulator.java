package com.udmey.spring.springjwt.dataPopulator;
import com.udmey.spring.springjwt.entities.User;
import com.udmey.spring.springjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class DataPopulator implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder().username("user").password(passwordEncoder.encode("user")).build();
        userRepository.save(user);

        User admin = User.builder().username("admin").password(passwordEncoder.encode("admin")).build();
        admin.getUserRoles().add(  "ADMIN");
        userRepository.save(admin);

    }
}
