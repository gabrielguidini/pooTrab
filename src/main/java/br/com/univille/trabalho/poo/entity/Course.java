package br.com.univille.trabalho.poo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String courseName;
    @ManyToMany
    @ToString.Exclude
    private List<Subject> subject;

    public Course(String courseName, List<Subject> subject) {
        this.courseName = courseName;
        this.subject = subject;
    }

}
