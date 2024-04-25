package br.com.univille.trabalho.poo.repository;

import br.com.univille.trabalho.poo.entity.Course;
import br.com.univille.trabalho.poo.utils.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("""
        select c.courseName from Course c where c.courseName = :courseName
        """)
    List<String> findByCourse(String courseName);
}
