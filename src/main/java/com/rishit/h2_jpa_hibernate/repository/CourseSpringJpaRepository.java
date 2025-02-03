package com.rishit.h2_jpa_hibernate.repository;

import com.rishit.h2_jpa_hibernate.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringJpaRepository extends JpaRepository<Courses, Long> {
     /*
        There is no need to Implement any methods from JpaRepository<T, ID>
        All methods are already implemented in another class
     */
}
