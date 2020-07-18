package mins.study.ditest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter @NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue
    @Column(name = "professor_id")
    private Long id;

    private String name;
    private Integer age;

    @JsonManagedReference
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    public Professor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setCourse(Course course) {
        this.getCourses().add(course);
        course.setProfessor(this);
    }
}
