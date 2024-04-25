package br.com.univille.trabalho.poo.utils;


import br.com.univille.trabalho.poo.entity.Subject;
import lombok.Builder;

import java.util.List;

@Builder
public record CourseDTO (
        String courseName,
        List<Subject> subjects){

}
