package mins.study.ditest;

import mins.study.ditest.entity.Course;
import mins.study.ditest.entity.Professor;
import mins.study.ditest.entity.Student;

public class SettingUtils {

    static Course settingCourseData() {
        Course course = new Course();
        course.setCourseName("JAVA");
        course.setProfessor(settingProfessorData());
        course.setCourseScore(3);

        return course;
    }

    static Professor settingProfessorData() {
        Professor professor = new Professor();
        professor.setName("MinTeacher");
        professor.setAge(50);

        return professor;
    }

    static Student settingStudentData() {
        Student student = new Student();
        student.setName("minssogi");
        student.setAge(20);

        return student;
    }
}
