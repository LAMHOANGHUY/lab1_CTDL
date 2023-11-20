package task1;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		// tạo danh sách sinh viên .
		List<Student> students = new ArrayList<>();
		students.add(new Student("1", "Student 1", 2022));
		students.add(new Student("2", "Student 2", 2022));
		students.add(new Student("3", "Student 3", 2022));
		students.add(new Student("4", "Student 4", 2022));
		students.add(new Student("5", "Student 5", 2022));

		List<Student> addStudents = new ArrayList<>(students);
		addStudents.add(new Student("6", "Student 6", 2022));

		List<Course> courses = new ArrayList<>();
		courses.add(new Course("C1", "Course 1", "Thuc hanh", students, "Nguyen Van A"));
		courses.add(new Course("C2", "Course 2", "Thuc hanh", addStudents, "Nguyen Van A"));
		courses.add(new Course("C3", "Course 3", "Ly thuyet", students, "Nguyen Van B"));

		Faculty faculty1 = new Faculty("Đại học Bách Khoa Hà Nội", "It", courses);
		System.out.println("Course có nhiều sv đăng kí nhất là :");
		System.out.println(faculty1.getMaxPracticalCourse());

		System.out.println();
		System.out.println("------------------------------");

		Faculty faculty2 = new Faculty("DH", "It", courses);
		System.out.println("Danh sách sinh viên theo năm vào học : ");
		System.out.println(faculty2.groupStudentsByYear());
		
		Faculty faculty3 = new Faculty("YH", "It", courses);
		System.out.println("Danh sách sinh viên theo năm vào học : ");
		System.out.println(faculty3.filterCourses("Thuc hanh"));

	}
}
