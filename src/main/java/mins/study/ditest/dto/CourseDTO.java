package mins.study.ditest.dto;

import lombok.Builder;
import lombok.Data;
import mins.study.ditest.entity.Course;

@Data
@Builder
public class CourseDTO {

    private Long courseId;

    private String courseName;
    private Integer courseScore;

    public static CourseDTO entityToDto(Course course) {

        return CourseDTO.builder()
                .courseId(course.getId())
                .courseName(course.getCourseName())
                .courseScore(course.getCourseScore())
                .build();
    }
}
