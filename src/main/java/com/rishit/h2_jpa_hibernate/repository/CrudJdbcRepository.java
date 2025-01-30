package com.rishit.h2_jpa_hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CrudJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =
            """
                    insert into courses (id, name, vendor)
                    values(1, 'Java Persistence API', 'Sadhaka')
                    """;

    public void insert(){
        jdbcTemplate.update(INSERT_QUERY);
    }
}
