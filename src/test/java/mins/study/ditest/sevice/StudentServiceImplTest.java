package mins.study.ditest.sevice;

import mins.study.ditest.entity.Student;
import mins.study.ditest.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//@SpringBootTest
@DataJpaTest
class StudentServiceImplTest {

    @Autowired
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    void init() {
        if(studentService == null) {
            studentService = new StudentServiceImpl(new CommonServiceImpl(), studentRepository);
        }
    }

    @Test
    void randomStr() {
        Assertions.assertNotNull(studentService.randomStr());
    }

    @Test
    void addRandomStudent() {
        Student student = studentService.addRandomStudent();
        Assertions.assertNotNull(student);
    }
}