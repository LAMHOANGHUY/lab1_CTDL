package task1;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;

	}

	public Course getMaxPracticalCourse() {
		// tìm Course thực hành có nhiều sinh viên nhất.
		int maxStudent = -1;
		Course maxCourse = null;
		for (Course c : courses) {
			if (maxCourse == null)
				maxCourse = c;
			int number = c.getStudents().size();
			if (c.getType().equals("Thuc hanh") && number > maxStudent) {
				maxStudent = number;
				maxCourse = c;
			}
		}
		return maxCourse;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		// Thống kê danh sách sinh viên theo năm vào học
		Map<Integer, List<Student>> groupedStudent = new HashMap<>();
		for (Course c : courses) {
			List<Student> value = new ArrayList<Student>();
			for (Student student : c.getStudents()) {
				int year = student.getYear();
				if (!groupedStudent.containsKey(year)) {
					value.add(student);
					groupedStudent.put(year, value);
				} else {
					value = groupedStudent.get(year);
					if (!value.contains(student)) {
						value.add(student);
						groupedStudent.put(year, value);
					}
				}
			}
		}

		return groupedStudent;
	}

	public Set<Course> filterCourses(String type){
		 // Tạo một danh sách tạm thời để lưu trữ các khoá học theo loại
       List<Course> filteredList = new ArrayList<>();

       // Lọc các khoá học theo loại
       for (Course c : courses) {
           if (c.getType().equalsIgnoreCase(type)) {
               filteredList.add(c);
           }
       }

       // Sắp xếp danh sách giảm dần theo số lượng sinh viên
       Collections.sort(filteredList, new Comparator<Course>() {
           @Override
           public int compare(Course course1, Course course2) {
               int studentCount1 = course1.getStudents().size();
               int studentCount2 = course2.getStudents().size();

               // Sắp xếp giảm dần theo số lượng sinh viên
               return Integer.compare(studentCount2, studentCount1);
           }
       });

       // Chuyển đổi danh sách đã sắp xếp thành một Set và trả về
       return new HashSet<>(filteredList);
   }

	@Override
	public String toString() {
		return "Faculty name :" + name + ", address :" + address + ", courses :" + courses;
	}

}
