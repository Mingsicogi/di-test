package mins.study.ditest.sevice;

import mins.study.ditest.entity.Student;

public interface StudentService {

    void init();

    String randomStr();

    Student addRandomStudent();

//    Student registerCourse(Student student, Course... courses);
}
