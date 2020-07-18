package mins.study.ditest.controller;

import lombok.RequiredArgsConstructor;
import mins.study.ditest.dto.StudentDTO;
import mins.study.ditest.entity.Course;
import mins.study.ditest.entity.Student;
import mins.study.ditest.entity.StudentCourse;
import mins.study.ditest.repository.CourseRepository;
import mins.study.ditest.repository.StudentCourseRepository;
import mins.study.ditest.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;

    @PostMapping
    public ResponseEntity<Object> add(String name, Integer age) {
        return ResponseEntity.ok(studentRepository.save(new Student(name, age)));
    }

    @GetMapping
    public ResponseEntity<Object> get(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        return ResponseEntity.ok(StudentDTO.entityToDto(student));
    }

    @PostMapping(value = "/course/register")
    public ResponseEntity<Object> addStudentCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        return ResponseEntity.ok(studentCourseRepository.save(new StudentCourse(student, course)));
    }
}
