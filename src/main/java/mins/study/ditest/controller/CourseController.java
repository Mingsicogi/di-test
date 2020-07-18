package mins.study.ditest.controller;

import lombok.RequiredArgsConstructor;
import mins.study.ditest.entity.Course;
import mins.study.ditest.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/course")
public class CourseController {

    private final CourseRepository courseRepository;

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
}
