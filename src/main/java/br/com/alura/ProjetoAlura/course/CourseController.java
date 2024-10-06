package br.com.alura.ProjetoAlura.course;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.ProjetoAlura.util.ErrorItemDTO;

@RestController
public class CourseController {
	
	private final CourseRepository courseRepository;

	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
    @Transactional
    @PostMapping("/course/new")
    public ResponseEntity createCourse(@Valid @RequestBody NewCourseDTO newCourse) {

    	if(courseRepository.existsByCode(newCourse.getCode())) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    					.body(new ErrorItemDTO("code", "Código já cadastrado no sistema"));
    		}
    		
    		//checar se usuário é instrutor
    		    		
    		Course course = newCourse.toModel();
    		courseRepository.save(course);
    		
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Transactional
    @PostMapping("/course/{code}/inactive")
    public ResponseEntity createCourse(@PathVariable("code") String courseCode) {
        // TODO: Implementar a Questão 2 - Inativação de Curso aqui...

        return ResponseEntity.ok().build();
    }

}
