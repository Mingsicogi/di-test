package mins.study.ditest;

import mins.study.ditest.entity.Student;
import mins.study.ditest.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.TransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionManager transactionManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void initTest() {
        Assertions.assertNotNull(dataSource);
        Assertions.assertNotNull(entityManager);
        Assertions.assertNotNull(transactionManager);
    }

    @Test
    void repositoryTest() {
        // GIVE
        Student student = SettingUtils.settingStudentData();

        // WHEN
        Student save = studentRepository.save(student);

        // THEN
        Assertions.assertTrue(save.getStudentId() != 0);
    }
}
