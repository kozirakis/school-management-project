package middlewear.repository;

import middlewear.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface TeacherRepository extends MongoRepository<Teacher,String> {
    List<Teacher> findAllByLastName(String lastName);
    List<Teacher> findByLastNameStartingWith(String lastName);
}
