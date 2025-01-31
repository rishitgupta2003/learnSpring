package com.rishit.h2_jpa_hibernate.repository;

import com.rishit.h2_jpa_hibernate.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public class CrudJdbcRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate;

    public CrudJdbcRepository() {}

    @Autowired
    public CrudJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String INSERT_QUERY =
            """
            insert into courses (id, name, vendor)
            values(?, ?, ?)
            """;

    private static String DELETE_QUERY =
            """
            delete from courses
            where id = ?
            """;

    private static String SELECT_QUERY =
            """
            select * from courses
            where id = ?
            """;

    public void insert(Courses course){
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getVendor());
    }

    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Courses findById(long id){
        // ResultSet -> Bean => RowMapper => id

        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Courses.class), id);

    }


}