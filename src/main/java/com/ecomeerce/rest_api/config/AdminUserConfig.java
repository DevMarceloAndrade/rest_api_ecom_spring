package com.ecomeerce.rest_api.config;

import com.ecomeerce.rest_api.enums.UserRole;
import com.ecomeerce.rest_api.models.User;
import com.ecomeerce.rest_api.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    private UserService userService;

    @Autowired
    public AdminUserConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var userAdmin = userService.findByRole(UserRole.ADMIN);

        userAdmin.ifPresentOrElse(
                user -> System.out.println("Admin já existe"),
                ()->{
                    User user = new User();
                    user.setEmail("admin@admin.com");
                    user.setPassword("123");
                    user.setBirth(LocalDate.now());
                    user.setPhone("88998877");
                    user.setRole(UserRole.ADMIN);
                    user.setFirstName("admin");
                    user.setLastName("01");

                    userService.create(user);
                }
        );



    }
}
