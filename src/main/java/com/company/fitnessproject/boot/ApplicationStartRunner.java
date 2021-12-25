package com.company.fitnessproject.boot;

import com.company.fitnessproject.entity.Gym;
import com.company.fitnessproject.entity.Role;
import com.company.fitnessproject.entity.User;
import com.company.fitnessproject.repository.GymRepository;
import com.company.fitnessproject.repository.RoleRepository;
import com.company.fitnessproject.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final GymRepository gymRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(Role.builder()
                .nameRole("ROLE_ADMIN")
                .build());
        roleRepository.save(Role.builder()
                .nameRole("ROLE_USER")
                .build());

        gymRepository.save(Gym.builder()
                .description("FitnessPro")
                .address("Ахунбаева/Советская")
                .build());
        gymRepository.save(Gym.builder()
                .description("Terra sport")
                .address("Турусбекова, 109/1")
                .build());
        gymRepository.save(Gym.builder()
                .description("Life Fitness")
                .address("Чуй, 135")
                .build());
        gymRepository.save(Gym.builder()
                .description("HardGym")
                .address("Боконбаева/Белинская, 15")
                .build());
    }
}