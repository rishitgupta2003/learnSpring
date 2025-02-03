package com.rishit.h2_jpa_hibernate.runner;

import com.rishit.h2_jpa_hibernate.model.Courses;
import com.rishit.h2_jpa_hibernate.repository.CourseJpaRepository;
import com.rishit.h2_jpa_hibernate.repository.CourseSpringJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    //private @Autowired CourseJpaRepository courseJpaRepository;
    private @Autowired CourseSpringJpaRepository courseSpringJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        //Manual JPA Snippet
        /*
            courseJpaRepository.insert(new Courses(1, "Java Spring", "Sadhaka"));
            courseJpaRepository.insert(new Courses(2, "J2EE", "EPAM_CAMPUS"));
            courseJpaRepository.insert(new Courses(3, "Jakarta Persistence API", "Scaler"));

            courseJpaRepository.deleteByID(2);
        */

        //SpringJPA_Repository

        courseSpringJpaRepository.save(new Courses(1, "Java Spring", "Sadhaka"));
        courseSpringJpaRepository.save(new Courses(2, "J2EE", "EPAM_Campus"));
        courseSpringJpaRepository.save(new Courses(3, "Jakarta Persistence API", "Scaler"));

        courseSpringJpaRepository.findAll().forEach(System.out::println);
        courseSpringJpaRepository.findByVendor("Scaler").forEach(System.out::println);
        courseSpringJpaRepository.findByName("J2EE").forEach(System.out::println);
    }
}