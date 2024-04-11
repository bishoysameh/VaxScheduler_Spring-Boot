package com.example.demo;

// import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import java.time.DayOfWeek;
// import java.time.LocalDate;
// import java.time.Month;
// import java.util.List;


// @RestController
 @SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//public String getMethodName(@RequestParam String param) {
//    return new String();
//}
//@GetMapping
//	public List<Student> hello() {
//		return List.of(
//				new Student(
//						1l,
//						"bishoy",
//						"bishoy@gmail.com",
//						LocalDate.of(2000 , Month.FEBRUARY , 5),
//						21
//				)
//		);
//	}

}
