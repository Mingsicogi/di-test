package mins.study.ditest.sevice;

import mins.study.ditest.entity.Course;
import mins.study.ditest.entity.Student;

public interface StudentService {

    Student registerCourse(Student student, Course... courses);
}
