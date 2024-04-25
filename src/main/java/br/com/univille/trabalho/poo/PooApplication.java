package br.com.univille.trabalho.poo;

import br.com.univille.trabalho.poo.entity.Course;
import br.com.univille.trabalho.poo.entity.Subject;
import br.com.univille.trabalho.poo.entity.Teacher;
import br.com.univille.trabalho.poo.repository.CourseRepository;
import br.com.univille.trabalho.poo.repository.SubjectRepository;
import br.com.univille.trabalho.poo.repository.TeacherRepository;
import br.com.univille.trabalho.poo.utils.CourseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class PooApplication {

	public static void main(String[] args) {
		SpringApplication.run(PooApplication.class, args);
	}

	@Bean
	public CommandLineRunner lecture(TeacherRepository teacherRepository, SubjectRepository subjectRepository, CourseRepository courseRepository){
		return args -> {
			var earlyTime = "18:50";
			var lateTime = "20:50";

			Teacher lea = teacherRepository.save(new Teacher("Leanderson"));
			Teacher van = teacherRepository.save(new Teacher("Vanessa"));
			Teacher lei = teacherRepository.save(new Teacher("Leila"));
			Teacher mar = teacherRepository.save(new Teacher("Marcelo"));

			subjectRepository.save(new Subject("POO II", lea,lateTime, "WED"));
			subjectRepository.save(new Subject("POO II", lea , earlyTime, "FRI"));
			subjectRepository.save(new Subject("ELCS I", van,earlyTime, "WED"));
			subjectRepository.save(new Subject("ELCS I",van,earlyTime ,"TUR"));
			subjectRepository.save(new Subject("VEXT III", lei,earlyTime,"MON"));
			subjectRepository.save(new Subject("VEXT III",lei,lateTime,"MON" ));
			subjectRepository.save(new Subject("SOP", mar,earlyTime,"THU"));

			List<Subject> subjectsEng = new ArrayList<>();
			subjectsEng.add(new Subject("POO II", lea));
			subjectsEng.add(new Subject("ELCS I", van));
			subjectsEng.add(new Subject("VEXT III", lei));
			subjectsEng.add(new Subject("SOP", mar));

			List<Subject> subjectsSis = new ArrayList<>();

			subjectRepository.saveAll(subjectsEng);
			subjectRepository.saveAll(subjectsSis);

			courseRepository.save(new Course("ENG SOFT", subjectsEng));
			courseRepository.save(new Course("SIS INFO", subjectsSis));

			log.info("--------------------------------FIND ALL---------------------------------");

			List<Teacher> teacherList = teacherRepository.findAll();
			teacherList.forEach(System.out::println);

			log.info("------------------------------FIND BY NAME (Subject)----------------------");

			List<String> subjectsList = subjectRepository.findByName("POO II");
			subjectsList.forEach(System.out::println);

			log.info("------------------------------GET BY DAY---------------------------------");

			List<String> dayList = subjectRepository.findByLectureTime("MON");
			dayList.forEach(System.out::println);

			log.info("------------------------------FIND TEACHER BY ID--------------------------");

			System.out.println(teacherRepository.findById(lea.getId()).get().getTeacherName());

			log.info("------------------------------FIND BY COURSE--------------------------");

			List<String> engSoft = courseRepository.findByCourse("ENG SOFT");
			engSoft.forEach(System.out::println);
			List<String> sisInfo = courseRepository.findByCourse("SIS INFO");
			sisInfo.forEach(System.out::println);


		};
	}
}
