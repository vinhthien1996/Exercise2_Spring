package vn.com.tma.nvthien1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListStudent {
	
	@Autowired
	Student student;
	
	List<Student> listStudent = new ArrayList<Student>();
	
//	ADD STUDENT
	public void addStudent(Student student) {
		listStudent.add(student);
		System.out.println("Add student success!");
	}
	
//	GET LIST STUDENT
	public List<Student> getListStudent() {
		return listStudent;
	}
	
//	MENU LARGEST
	public Student findLargest() {
		int max = 0;

		for (Student item : listStudent) {
			if (item.getGPA() >= max) {
				student = item;
			}
		}
		return student;
	}
	
//	MENU LOWEST
	public Student findLowest() {
		float min = listStudent.get(0).getGPA();

		for (Student item : listStudent) {
			if (item.getGPA() <= min) {
				student = item;
			}
		}
		return student;
	}
}
