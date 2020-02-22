package studentmgmtsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import studentmgmtsystem.model.Student;

/**
 * Class to implement Data Access Object 
 *
 */
@Repository
public class StudentDao {
	private static List<Student> studentsList = new ArrayList<Student>();
	private static int counter = 1;
	
	/**
	 * Function to add student
	 * @param newStudent
	 * @return true if student is successfully added
	 */
	public boolean addStudent(Student newStudent) {
		newStudent.setId(counter);
		studentsList.add(newStudent);
		counter++;
		return true;
	}

	/**
	 * Function to get all students
	 * @return the list of students
	 */
	public List<Student> getAllStudents() {
		return studentsList;
	}
	
	
}
