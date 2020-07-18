package mins.study.ditest.controller;

import lombok.RequiredArgsConstructor;
import mins.study.ditest.entity.Course;
import mins.study.ditest.entity.Professor;
import mins.study.ditest.repository.CourseRepository;
import mins.study.ditest.repository.ProfessorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<Object> add(String name, Integer age) {
        return ResponseEntity.ok(professorRepository.save(new Professor(name, age)));
    }

    @GetMapping
    public ResponseEntity<Object> get(Long professorId) {
        return ResponseEntity.ok(professorRepository.findById(professorId).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<Object> put(Long professorId, Long courseId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        professor.setCourse(course);

        return ResponseEntity.ok(professorRepository.save(professor));
    }
}
