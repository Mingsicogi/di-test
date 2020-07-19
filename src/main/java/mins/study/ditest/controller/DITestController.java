package mins.study.ditest.controller;

import mins.study.ditest.repository.CourseRepository;
import mins.study.ditest.repository.ProfessorRepository;
import mins.study.ditest.repository.StudentCourseRepository;
import mins.study.ditest.repository.StudentRepository;
import mins.study.ditest.sevice.CommonService;
import mins.study.ditest.sevice.ProfessorService;
import mins.study.ditest.sevice.StudentService;
import mins.study.ditest.sevice.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class DITestController {

    private final StudentService studentService;
    private final ProfessorService professorService;
    private final CommonService commonService;
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public DITestController(StudentService studentService, ProfessorService professorService,
                            CommonService commonService, CourseRepository courseRepository,
                            ProfessorRepository professorRepository, StudentRepository studentRepository,
                            StudentCourseRepository studentCourseRepository) {
        this.studentService = studentService;
        this.professorService = professorService;
        this.commonService = commonService;
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @GetMapping
    public ResponseEntity<Object> init() {
        studentService.init();
        professorService.init();
        return ResponseEntity.ok("OK");
    }

    @GetMapping(value = "/check/studentServiceImpl")
    public ResponseEntity<Object> studentRepo() {

        if(studentService instanceof StudentServiceImpl) {
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.badRequest().body("This object class type is " + studentService.getClass().getName());
        }
    }

    @GetMapping(value = "/change/studentService")
    public ResponseEntity<Object> studentServiceImplChange() {
//        studentService = new StudentService2Impl();

        return ResponseEntity.ok("OK");
    }
}
