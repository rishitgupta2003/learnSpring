package com.rishit.h2_jpa_hibernate.runner;

import com.rishit.h2_jpa_hibernate.repository.CrudJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseCommandLineRunner implements CommandLineRunner{

    @Autowired
    private CrudJdbcRepository crudJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        crudJdbcRepository.insert();
    }
}
