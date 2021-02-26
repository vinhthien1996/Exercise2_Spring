package vn.com.tma.nvthien1;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Menu {
	
	ArrayList<Student> listStudent = new ArrayList<Student>();
	
	@Autowired
	Student student;

	public int getMenu() {
		System.out.println("-----MENU-----");
		System.out.println("1. Add student");
		System.out.println("2. Show student");
		System.out.println("3. Finding student largest and lowest GPA.");

		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		return choose;
	}

	public boolean addStudent() {
		String name;
		float math, physical, english;

		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		name = sc.nextLine();
		System.out.println("Math score: ");
		math = sc.nextFloat();
		System.out.println("Physical score: ");
		physical = sc.nextFloat();
		System.out.println("English score: ");
		english = sc.nextFloat();
		
		student.setName(name);
		student.setMath(math);
		student.setPhysical(physical);
		student.setEnglish(english);
		
		System.out.println(student.getName());
		
		listStudent.add(student);

		System.out.println("Add student success!");
		System.out.println("1. Continue");
		System.out.println("0. Back");
		int result = sc.nextInt();

		if (result == 1)
			return true;
		else
			return false;
	}

	public void showListStudent() {
		System.out.println("-----LIST STUDENT-----");
		for (Student item : listStudent) {
			showStudent(item);
		}
	}

	public void showStudent(Student st) {
		System.out.println("Name: " + st.getName());
		System.out.println("Math: " + st.getMath());
		System.out.println("Physical: " + st.getPhysical());
		System.out.println("English: " + st.getEnglish());
		System.out.println("GPA: " + st.getGPA());
		System.out.println(" ");
	}

	public boolean menuFind() {
		System.out.println("1. Find student largest");
		System.out.println("2. Find student lowest");
		System.out.println("0. Back");

		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();

		switch (choose) {
		case 1: {
			findLargest();
			break;
		}
		case 2: {
			findLowest();
			break;
		}
		}
		return true;
	}

	public void findLargest() {
		int max = 0;

		for (Student item : listStudent) {
			if (item.getGPA() >= max) {
				student = item;
			}
		}
		System.out.println("-----STUDENT LARGEST-----");
		showStudent(student);
	}

	public void findLowest() {
		float min = listStudent.get(0).getGPA();

		for (Student item : listStudent) {
			if (item.getGPA() <= min) {
				student = item;
			}
		}
		System.out.println("-----STUDENT LOWEST-----");
		showStudent(student);
	}
}
