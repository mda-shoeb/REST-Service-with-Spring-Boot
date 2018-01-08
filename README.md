# REST-Service-with-Spring-Boot
REST Service with Spring Boot, Spring MVC, Java Security, Rest repositories and Spring Initializr. 
REST service is created using Spring Initializr. 

All applications need data. Instead of talking to a real database, we will use an ArrayList - kind of an in-memory data store.
A student can take multiple courses. A course has an id, name, description and a list of steps you need to complete to finish the course. A student has an id, name, description and a list of courses he/she is currently registered for. We have StudentService exposing methods to

public List<Student> retrieveAllStudents() - Retrieve details for all students
public Student retrieveStudent(String studentId) - Retrieve a specific student details
public List<Course> retrieveCourses(String studentId) - Retrieve all courses a student is registered for
public Course retrieveCourse(String studentId, String courseId) - Retrieve details of a specific course a student is registered for
public Course addCourse(String studentId, Course course) - Add a course to an existing student

The Rest Service StudentController exposes couple of get services. we will create three services using proper URIs and HTTP methods

@Autowired private StudentService studentService : We are using Spring Autowiring to wire the student service into the StudentController.
@GetMapping("/students/{studentId}/courses"): Exposing a Get Service with studentId as a path variable
You can ask the courses a specific student has registered for using request method Get and example uri /students/Student1/courses.

@GetMapping("/students/{studentId}/courses/{courseId}"): Exposing a Get Service for retrieving specific course of a student.
You can ask a specific course for a specific student using request method Get and example uri /students/Student1/courses/Course1.

@PathVariable String studentId: Value of studentId from the uri will be mapped to this parameter.
You can register a student for a course by sending a POST request to URI /students/Student1/courses
