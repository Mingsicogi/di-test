package mins.study.ditest.sevice;

import mins.study.ditest.entity.Student;
import mins.study.ditest.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final CommonService commonService;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(CommonService commonService, StudentRepository studentRepository) {
        this.commonService = commonService;
        this.studentRepository = studentRepository;
    }

    @Override
    public void init() {
//        System.out.println("StudentServiceImpl init = " + professorService.getClass().getName());
    }

    @Override
    public String randomStr() {
        return commonService.makeRandomString();
    }

    @Override
    public Student addRandomStudent() {
        Student savedStudent = studentRepository.save(new Student(UUID.randomUUID().toString(), (int) (Math.random() * 10)));
        return savedStudent;
    }

//    private final StudentRepository studentRepository;
//
//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//    @Override
//    public Student registerCourse(Student student, Course... courses) {
//        List<StudentCourse> studentCourses = new ArrayList<>();
//        for (Course course : courses) {
//            studentCourses.add(new StudentCourse(student, course));
//        }
//
//        student.getCourses().addAll(studentCourses);
//
//        return studentRepository.save(student);
//    }
}
