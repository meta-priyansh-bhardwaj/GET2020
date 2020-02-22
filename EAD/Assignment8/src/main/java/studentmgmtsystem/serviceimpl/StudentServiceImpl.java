package studentmgmtsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmgmtsystem.dao.StudentDao;
import studentmgmtsystem.model.Student;
import studentmgmtsystem.service.StudentService;

/**
 * Class that implements StudentService interface 
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	
	/**
	 * Function to add new student to list
	 * @param newStudent
	 * @return true if student is added successfully
	 */
	@Override
	public boolean addStudent(Student newStudent) {
		return studentDao.addStudent(newStudent);
	}

	/**
	 * Function to get all students
	 * @return list of students
	 */
	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
}
