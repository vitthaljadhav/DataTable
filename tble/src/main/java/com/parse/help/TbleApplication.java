package com.parse.help;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class TbleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TbleApplication.class, args);
	}

	@Autowired
	private StudentRepos repos;
	@RequestMapping(value = "/")
	public String hello() {
		return "hello";
	}

	@ResponseBody
	@PostMapping(value="/save")
	public void save(@RequestBody Student student) {
		repos.save(student);
	}
	@ResponseBody
	@RequestMapping(value = "/getData")
	public List<Student> helloStudent() {

		List<Student> findAll = repos.findAll();
		return findAll;
	}
}

@Repository
interface StudentRepos extends JpaRepository<Student, Integer> {

}

@Entity
class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String last_name;
	private String position;
	private String office;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
}