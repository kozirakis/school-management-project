package com.example.middlewear.repository;

import com.example.middlewear.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TeacherRepository extends MongoRepository<Teacher,String> {
    List<Teacher> findAllByLastName(String lastName);
    List<Teacher> findByLastNameStartingWith(String lastName);
}
