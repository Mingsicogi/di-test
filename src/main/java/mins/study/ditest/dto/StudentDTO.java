package mins.study.ditest.dto;

import lombok.Builder;
import lombok.Data;
import mins.study.ditest.entity.Student;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Builder
public class StudentDTO {

    private Long studentId;

    private String name;
    private Integer age;

    private List<CourseDTO> courses;

    public List<CourseDTO> getCourses() {
        if(courses == null) {
            courses = new ArrayList<>();
            return courses;
        }

        return courses;
    }

    public static StudentDTO entityToDto(Student student) {
        StudentDTO studentDTO = StudentDTO.builder()
                .studentId(student.getStudentId())
                .age(student.getAge())
                .name(student.getName())
                .build();

        studentDTO.getCourses().addAll(student.getCourses().stream()
                .map(studentCourse -> CourseDTO.entityToDto(studentCourse.getCourse())).collect(toList()));

        return studentDTO;
    }
}
