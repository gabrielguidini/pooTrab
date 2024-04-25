package br.com.univille.trabalho.poo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String subjectName;
    @ManyToOne
    private Teacher teacher;
    private String lectureTime;
    private String dayOfTheWeek;
    @ManyToMany(cascade = CascadeType.MERGE)
    @ToString.Exclude
    private List<Course> course;

    public Subject(String subjectName, Teacher teacher,String lectureTime , String dayOfTheWeek) {
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.lectureTime = lectureTime;
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Subject(String subjectName, Teacher teacher) {
        this.subjectName = subjectName;
        this.teacher = teacher;
    }

    public Subject() {
    }
}
