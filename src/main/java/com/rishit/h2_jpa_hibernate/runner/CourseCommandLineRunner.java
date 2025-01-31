package com.rishit.h2_jpa_hibernate.runner;

import com.rishit.h2_jpa_hibernate.model.Courses;
import com.rishit.h2_jpa_hibernate.repository.CrudJdbcRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//    @Autowired
    private CrudJdbcRepository crudJdbcRepository;

    //No Need of @Autowired for constructor dependency injection...
    public CourseCommandLineRunner(CrudJdbcRepository crudJdbcRepository) {
        this.crudJdbcRepository = crudJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        crudJdbcRepository.insert(
                new Courses(
                        1,
                        "Java Spring Boot",
                        "Sadhaka"
                )
        );
        crudJdbcRepository.insert(
                new Courses(
                        2,
                        "Java Persistence API",
                        "LinkedIN"
                )
        );
        crudJdbcRepository.insert(
                new Courses(
                        3,
                        "Java Spring Framework",
                        "in28minutes"
                )
        );

        crudJdbcRepository.deleteById(1);

        System.out.println(crudJdbcRepository.findById(2L));
        System.out.println(crudJdbcRepository.findById(3L));
    }
}


/*
* H2 is an in-memory database, provides a connection on runtime.
* Steps Followed:-
* 1. Created CRUD Repository using JDBCTemplate present in SpringJDBC
* 2. Used CommandLineRunner Interface to run the desired query after the initiation of Spring Web-Server
*/