package mins.study.ditest.sevice;

import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

//    @Autowired
    private final StudentService studentService;

    public ProfessorServiceImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void init() {
        System.out.println("StudentServiceImpl init = " + studentService.getClass().getName());
    }
}
