package br.com.univille.trabalho.poo.repository;

import br.com.univille.trabalho.poo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value = """
        select s.subjectName, s.lectureTime, s.dayOfTheWeek from Subject s where s.subjectName = :subjectName 
            """)
    List<String> findByName(String subjectName);

    @Query("""
       select s.dayOfTheWeek,s.lectureTime, s.teacher from Subject s where s.dayOfTheWeek = :dayOfTheWeek
           \s""")
    List<String> findByLectureTime(String dayOfTheWeek);

}