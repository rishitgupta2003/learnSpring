package com.rishit.h2_jpa_hibernate.repository;

import com.rishit.h2_jpa_hibernate.model.Courses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    private @PersistenceContext EntityManager entityManager;

    public void insert(Courses course){
        entityManager.merge(course);
    }

    public Courses findByID(long id){
        return entityManager.find(Courses.class, id);
    }

    public void deleteByID(long id){
        entityManager.remove(findByID(id));
    }
}