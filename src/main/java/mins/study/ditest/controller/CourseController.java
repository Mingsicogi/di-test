package mins.study.ditest.controller;

import lombok.RequiredArgsConstructor;
import mins.study.ditest.entity.Course;
import mins.study.ditest.entity.Professor;
import mins.study.ditest.repository.CourseRepository;
import mins.study.ditest.repository.ProfessorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/course")
public class CourseController {

    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<Object> add(String courseName, Integer courseScore) {
        Course course = new Course(courseName, courseScore);
        courseRepository.save(course);

        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<Object> get(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        return ResponseEntity.ok(course);
    }

    @PutMapping
    public ResponseEntity<Object> put(Long courseId, Long professorId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Professor professor = professorRepository.findById(professorId).orElseThrow();

        course.setProfessor(professor);

        return ResponseEntity.ok(courseRepository.save(course));
    }
}
