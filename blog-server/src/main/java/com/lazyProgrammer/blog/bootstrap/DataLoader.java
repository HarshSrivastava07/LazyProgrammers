package com.lazyProgrammer.blog.bootstrap;

import com.lazyProgrammer.blog.model.Category;
import com.lazyProgrammer.blog.model.Role;
import com.lazyProgrammer.blog.model.User;
import com.lazyProgrammer.blog.repository.CategoryRepository;
import com.lazyProgrammer.blog.repository.RoleRepository;
import com.lazyProgrammer.blog.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.lazyProgrammer.blog.model.Role.Roles.ROLE_ADMIN;
import static com.lazyProgrammer.blog.model.Role.Roles.ROLE_USER;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CategoryRepository categoryRepository;

    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            Role adminRole = new Role(ROLE_ADMIN);
            Role userRole = new Role(ROLE_USER);
            roleRepository.save(adminRole);
            roleRepository.save(userRole);

            User user = User.builder()
                    .email("admin@test.com")
                    .password(passwordEncoder.encode("secret"))
                    .isAccExpired(false)
                    .isAccLocked(false)
                    .isCredExpired(false)
                    .isEnabled(true)
                    .roles(Set.of(adminRole, userRole))
                    .build();
            userRepository.save(user);

            Category general = new Category("General");
            Category java = new Category("Java");
            categoryRepository.save(general);
            categoryRepository.save(java);
        }

    }
}
