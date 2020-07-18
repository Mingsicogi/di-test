package mins.study.ditest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private Long id;

    private String courseName;
    private Integer courseScore; // 학점

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "professor_id")
    private Professor professor; // 담당 교수

    @OneToMany(mappedBy = "student")
    private List<StudentCourse> students = new ArrayList<>();

    public Course(String courseName, Integer courseScore) {
        this.courseName = courseName;
        this.courseScore = courseScore;
    }
}
