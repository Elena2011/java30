package telran.java30.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.java30.student.dto.ScoreDto;
import telran.java30.student.dto.StudentDto;
import telran.java30.student.dto.StudentResponseDto;
import telran.java30.student.dto.StudentUpdateDto;
import telran.java30.student.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public boolean addStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}
	@GetMapping("/student/{id}")
	public StudentResponseDto findStudent(@PathVariable Integer id) {
		return studentService.findStudent(id);
	}
	  @DeleteMapping("/student/{id}")
	public StudentResponseDto deleteStudent( @PathVariable Integer id) {
		return studentService.deleteStudent(id);
	}
	  @PostMapping("/student/{id}")
	  StudentDto updateStudent( @PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto)
	  {
		  return studentService.updateStudent(id, studentUpdateDto);
	  }
	  @PutMapping("/student/{id}/score")
		boolean addScore( @PathVariable Integer id,@RequestBody ScoreDto scoreDto)
		{
		  return studentService.addScore(id, scoreDto);
		}
	  @GetMapping("/students/name/{name}")
	  public List<StudentResponseDto> findStudentsByName(@PathVariable String name){
		  return studentService.findStudentsByName(name);
	  }
	  @GetMapping("/students/count/{name}")
	  public long countStudentsByName (@PathVariable String name){
		  return studentService.countStudentsByName(name);
	  }
	  @GetMapping("/students/score/{exam}/{score}")
	  public List<StudentResponseDto> findStudentByExamScore(@PathVariable(name = "exam")String examName, 
			  @PathVariable(name = "score")int minScore){
		  return studentService.findStudentsByExamScore(examName, minScore);
	  }
}
