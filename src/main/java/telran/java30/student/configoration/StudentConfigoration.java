package telran.java30.student.configoration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import telran.java30.student.service.StudentService;
import telran.java30.student.service.StudentServiceImpl;
@Configuration
public class StudentConfigoration {
	//@Bean
public StudentService getStudentService() {
	return new StudentServiceImpl();
}
}
