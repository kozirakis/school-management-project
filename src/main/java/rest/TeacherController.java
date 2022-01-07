package rest;


import middlewear.entity.Teacher;
import middlewear.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/api/teachers")
    public String saveTeacher(@RequestBody Teacher teacher){
        teacherRepository.save(teacher);
        return "Added teacher with LastName: "+teacher.getLastName();
    }

    @GetMapping("/api/teachers")
    public List<Teacher> getTeachers( @RequestParam(name = "byLastName", required = false) String byLastName,
                                      @RequestParam(name = "lastNameStartingWith", required = false) String lastNameStartingWith
    ){
        if (byLastName != null && byLastName != "") {
            return teacherRepository.findAllByLastName(byLastName);
        }
        if ( (lastNameStartingWith != null) && (lastNameStartingWith != "") ) {
            return teacherRepository.findByLastNameStartingWith(lastNameStartingWith);
        }
        return teacherRepository.findAll();
    }

    @GetMapping("/api/teachers/{id}")
    public Teacher getTeacher(@PathVariable("id") String id){
        return teacherRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot find car with id " + id));
    }

    @PutMapping("/api/teachers/{id}")
    Teacher updateTeacher(@RequestBody Teacher newTeacher, @PathVariable String id) {

        return teacherRepository.findById(id)
                .map(match -> {
                    match.setFirstName(newTeacher.getFirstName());
                    match.setLastName(newTeacher.getLastName());
                    match.setAddress(newTeacher.getAddress());
                    match.setPhoneNumber(newTeacher.getPhoneNumber());
                    match.setComment(newTeacher.getComment());
                    return teacherRepository.save(match);
                })
                .orElseGet(() -> {
                    newTeacher.setId(id);
                    return teacherRepository.save(newTeacher);
                });
    }

    @DeleteMapping("/api/teachers")
    void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }

    @DeleteMapping("api/teachers/{id}")
    public String deleteTeacher(@PathVariable String id){
        teacherRepository.deleteById(id);
        return "Teacher deleted";
    }

}
