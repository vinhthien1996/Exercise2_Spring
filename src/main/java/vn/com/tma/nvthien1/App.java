package vn.com.tma.nvthien1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
		ListStudent listStudent = (ListStudent) factory.getBean("listStudent");

		while (true) {

//			MENU
			System.out.println("-----MENU-----");
			System.out.println("1. Add student");
			System.out.println("2. Show student");
			System.out.println("3. Finding student largest and lowest GPA.");
			Scanner scan = new Scanner(System.in);
			int choose = scan.nextInt();
			
			switch (choose) {
//			ADD STUDENT
			case 1: {
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

				Student student = new Student(name, math, physical, english);
				listStudent.addStudent(student);
				break;
			}

//			SHOW STUDENT
			case 2: {
				System.out.println("----- LIST STUDENT -----");
				for (Student item : listStudent.getListStudent()) {
					System.out.println("Name: " + item.getName());
					System.out.println("Math: " + item.getMath());
					System.out.println("Physical: " + item.getPhysical());
					System.out.println("English: " + item.getEnglish());
					System.out.println("GPA: " + item.getGPA());
					System.out.println(" ");
				}
				break;
			}

//			FIND STUDENT
			case 3: {

				System.out.println("1. Find student largest");
				System.out.println("2. Find student lowest");
				System.out.println("0. Back");
				int sfind = scan.nextInt();

				switch (sfind) {
//					FIND LARGEST
					case 1: {
						Student st = listStudent.findLargest();
						System.out.println("----- STUDENT LARGEST -----");
						System.out.println("Name: " + st.getName());
						System.out.println("Math: " + st.getMath());
						System.out.println("Physical: " + st.getPhysical());
						System.out.println("English: " + st.getEnglish());
						System.out.println("GPA: " + st.getGPA());
						System.out.println(" ");
						break;
					}
//					FIND LOWEST
					case 2: {
						Student st = listStudent.findLowest();
						System.out.println("----- STUDENT LOWEST -----");
						System.out.println("Name: " + st.getName());
						System.out.println("Math: " + st.getMath());
						System.out.println("Physical: " + st.getPhysical());
						System.out.println("English: " + st.getEnglish());
						System.out.println("GPA: " + st.getGPA());
						System.out.println(" ");
						break;
					}
				}
				break;
			}
			}
		}
	}
}
