package studentmgmtsystem.service;

import java.util.List;

import studentmgmtsystem.model.Student;

/**
 * Class to implement service
 * to return data related to students 
 *
 */
public interface StudentService {
	
	/**
	 * Function to add new student to list
	 * @param newStudent
	 * @return true if student is added successfully
	 */
	boolean addStudent(Student newStudent);
	
	/**
	 * Function to get all students
	 * @return list of students
	 */
	List<Student> getAllStudents();
}
