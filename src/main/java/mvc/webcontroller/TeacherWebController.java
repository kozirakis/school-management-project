package mvc.webcontroller;


import middlewear.entity.Teacher;
import middlewear.repository.TeacherRepository;
import mvc.model.TeacherSearchModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TeacherWebController {
    private final TeacherRepository teacherRepository;

    TeacherWebController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/teachers")
    public Object searchTeachersSubmit(
            @ModelAttribute TeacherSearchModel searchModel) {
            return "redirect:/teachers/searchresults?searchByLastName=" + searchModel.getLastName();

    }

    @GetMapping("/teachers")
    public Object showTeachers(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String searchByLastName
    ) {
        if (page < 1) {

            return "redirect:/teachers?page=1&size="+ size;

        }

//        Page<Teacher> teachers = findPaginated(
//                !searchByLastName.equals("") ?
//                        teacherRepository.findByLastNameStartingWith(searchByLastName) :
//                        teacherRepository.findAll(),
//                PageRequest.of(page - 1, size)
//        );

        Page<Teacher> teachers = findPaginated(teacherRepository.findAll(),PageRequest.of(page - 1, size));

        int totalPages = teachers.getTotalPages();

        if ( (totalPages>0) && (page > totalPages) ) {

            return "redirect:/teachers?size="+ size + "&page=" + totalPages;
        }

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(Math.max(1, page-2), Math.min(page + 2, totalPages))
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("page", page);
        model.addAttribute("teachers", teachers);
        model.addAttribute("searchModel", new TeacherSearchModel(searchByLastName));
        return "teachers";
    }

    @GetMapping("/teachers/searchresults")
        public Object showSearchResults( Model model,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "") String searchByLastName
        ){
            if (page < 1) {

                return "redirect:/teachers/searchresults?page=1&size="+ size;

            }

            Page<Teacher> teachers = findPaginated(teacherRepository.findByLastNameStartingWith(searchByLastName),PageRequest.of(page - 1, size));

            int totalPages = teachers.getTotalPages();

            if ( (totalPages>0) && (page > totalPages) ) {

                return "redirect:/teachers/searchresults?size="+ size + "&page=" + totalPages;
            }

            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(Math.max(1, page-2), Math.min(page + 2, totalPages))
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
            }

            model.addAttribute("page", page);
            model.addAttribute("teachers", teachers);
            model.addAttribute("searchModel", new TeacherSearchModel(searchByLastName));
            return "search-results";
    }

    @GetMapping("/teachers/addteacher")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "add-teacher";
    }

    @PostMapping("/teachers/addteacher")
    public String addTeacher(Teacher teacher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-teacher";
        }

        teacherRepository.save(teacher);
        model.addAttribute("teacher", teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/update/{id}")
    public String updateTeacher(@PathVariable("id") String id, Model model) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));

        model.addAttribute("teacher", teacher);
        return "update-teacher";
    }

    @PostMapping("/teachers/update/{id}")
    public String updateTeacher(@PathVariable("id") String id, Teacher teacher,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            teacher.setId(id);
            return "update-teacher";
        }

        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") String id, Model model) {
      Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
        teacherRepository.delete(teacher);
        return "redirect:/teachers";
    }

    private Page<Teacher> findPaginated(List<Teacher> teachers, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List<Teacher> result;

        if (teachers.size() < startItem) {
            result = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, teachers.size());
            result = teachers.subList(startItem, toIndex);
        }

        Page<Teacher> teacherPage = new PageImpl<Teacher>(result, PageRequest.of(currentPage, pageSize), teachers.size());

        return teacherPage;
    }

}
