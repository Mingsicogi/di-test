package mins.study.ditest;

import mins.study.ditest.entity.Student;
import mins.study.ditest.repository.StudentRepository;
import mins.study.ditest.sevice.StudentService;
import mins.study.ditest.sevice.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest
class StudentServiceImplTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void registerCourse() {
//        StudentService studentService = new StudentServiceImpl(studentRepository);
//        Student student = studentService.registerCourse(SettingUtils.settingStudentData(), SettingUtils.settingCourseData());
//        Assertions.assertTrue(student.getStudentId() != 0);
    }
}