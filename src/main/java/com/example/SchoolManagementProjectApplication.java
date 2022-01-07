package com.example;

import com.example.middlewear.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

@ComponentScan(basePackages = {"com.example.*"})
@Configuration
@EnableMongoRepositories
public class SchoolManagementProjectApplication implements CommandLineRunner {


    @Autowired
    TeacherRepository teacherRepository;

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        teacherRepository.deleteAll();
        teacherRepository.saveAll(LoadDatabase.generateRandomTeachers());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
