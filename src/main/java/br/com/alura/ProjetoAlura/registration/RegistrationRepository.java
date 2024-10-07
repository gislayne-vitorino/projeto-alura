package br.com.alura.ProjetoAlura.registration;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.ProjetoAlura.course.Course;
import br.com.alura.ProjetoAlura.user.User;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
   
	boolean existsByUserAndCourse(User user, Course course);
}
