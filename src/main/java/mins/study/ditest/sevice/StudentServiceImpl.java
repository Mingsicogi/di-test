package mins.study.ditest.sevice;

import lombok.RequiredArgsConstructor;
import mins.study.ditest.entity.Course;
import mins.study.ditest.entity.Student;
import mins.study.ditest.entity.StudentCourse;
import mins.study.ditest.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student registerCourse(Student student, Course... courses) {
        List<StudentCourse> studentCourses = new ArrayList<>();
        for (Course course : courses) {
            studentCourses.add(new StudentCourse(student, course));
        }

        student.getCourses().addAll(studentCourses);

        return studentRepository.save(student);
    }
}
