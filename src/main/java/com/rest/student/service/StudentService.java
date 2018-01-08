package com.rest.student.service;

import com.rest.student.model.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    static {
        //Intializing Data
        Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
        Course course2 = new Course("course2", "Spring MVC", "10 Examples", Arrays.asList("Learn Maven2", "Import Project2", "First Example2", "Second Example2"));
        Course course3 = new Course("Course3", "Spring Boot", "6K Students",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        Course course4 = new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));

        Student ranga = new Student("Student1", "Ranga karnanam", "Hiker, Programer and Architect", Arrays.asList(course1,course2,course3,course4));
        Student satish = new Student("Student2", "Satish T",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));
        students.add(ranga);
        students.add(satish);

    }

    public List<Student> retrieveAllStudents() {
        return students;
    }

    public Student retrieveStudent(String studentId) {
        for(Student student: students) {
            if(student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }


    public List<Course> retrieveCourse(String studentId) {
        Student student = retrieveStudent(studentId);
        if(student == null) {
            return null;
        }

        return student.getCourses();
    }

    public Course retrieveCourse(String studentId, String courseId) {
        Student student = retrieveStudent(studentId);

        if(student == null) return null;

        for(Course course: student.getCourses()) {
            if(course.getId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }

    private SecureRandom random = new SecureRandom();

    public Course addCourse(String studentId, Course course) {
        Student student = retrieveStudent(studentId);

        if(student == null) {
            return null;

        }
        String randomId = new BigInteger(130, random).toString(32);
        course.setId(randomId);
        student.getCourses().add(course);

        return course;
    }
}
