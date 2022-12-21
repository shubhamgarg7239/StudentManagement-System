# StudentManagement-System portal
## Description
- We developed REST API for a Student-Management application. This API performs all the fundamental CRUD operations of any Student management platform with validation at every step.

## Techstack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA with Hibernate
- MySQL

## Module
- Student Module
- Course Module
- Profile Module
- StudentDTO Module
- CurrentAdminSession and CurrentStudentSesssion Module


## Features
- User and Admin authentication & validation with using Session management (UUID)
* Admin Features : 
   * Admin can add a student with his information.
   * Admin can upload a course details and assign a course to student.
   * Admin can search a student by name and get students assigned to a particular course.
   
 * Student Features : 
    *  Student Can update profile details.
    *  Student Can search for courses he assigned.
    *  Student Can leave a course.
    
## Installation & Run

- Before running the API server, you should update the database config inside the [application.properties](https://github.com/shubhamgarg7239/Student-Management-System/tree/main/src/main/resources ) file.
- Update the port number, database username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/stuManagementSystem
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
    
```
