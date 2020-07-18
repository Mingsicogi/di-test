package mins.study.ditest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Long studentId;

    private String name;
    private Integer age;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> courses = new ArrayList<>();

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
