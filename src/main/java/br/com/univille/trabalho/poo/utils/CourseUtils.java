package br.com.univille.trabalho.poo.utils;

import br.com.univille.trabalho.poo.entity.Course;
import lombok.Builder;

@Builder
public class CourseUtils {

    public Course convertDTOToEntity(CourseDTO courseDTO) {

        return Course.builder()
                .courseName(courseDTO.courseName())
                .subject(courseDTO.subjects())
                .build();
    }

    public CourseDTO convertEntityToDTO(Course course) {

        return CourseDTO.builder()
                .courseName(course.getCourseName())
                .subjects(course.getSubject())
                .build();
    }
}
