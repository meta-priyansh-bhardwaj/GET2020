package counselling;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Class to implement the Counsellor
 *
 */
public class Counsellor {
	private Map<String, Program> programs;
	private StudentQueue students;
	
	/**
	 * Constructor to initialise programs (a Map from program name to Program)
	 * and to collect data from excel sheets
	 * @throws Exception
	 */
	public Counsellor() throws Exception {
		programs = new HashMap<String, Program>();
		fetchPrograms("files/Program.xls");
		fetchStudents("files/Student.xls");
	}
	
	/**
	 * Function to fetch Programs data from excel sheet
	 * @param fileSource source of program excel sheet
	 * @throws Exception if fileSource is null String
	 */
	private void fetchPrograms(String fileSource) throws Exception {
		if(fileSource == null){
			throw new Exception("Null fileSource passed!");
		}
		Workbook programWorkbook = Workbook.getWorkbook(new File("files/Program.xls"));
		if(programWorkbook == null){
			throw new Exception("No Sheet found!");
		}
		Sheet programSheet = programWorkbook.getSheet(0);
		int programSheetLength = programSheet.getRows();
		for(int i=0;i<programSheetLength;i++){
			String programName = programSheet.getCell(0,i).getContents();
			int availableSeats = Integer.parseInt(programSheet.getCell(1,i).getContents());
			programs.put(programName, new Program(programName, availableSeats));
		}
		programWorkbook.close();
	}
	
	/**
	 * Function to fetch Students data from excel sheet
	 * @param fileSource source of student excel sheet
	 * @throws Exception if fileSource is null String
	 */
	private void fetchStudents(String fileSource) throws Exception {
		if(fileSource == null){
			throw new Exception("Null fileSource passed!");
		}
		Workbook studentWorkbook = Workbook.getWorkbook(new File("files/Student.xls"));
		if(studentWorkbook == null){
			throw new Exception("No Sheet found!");
		}
		Sheet studentSheet = studentWorkbook.getSheet(0);
		int studentSheetLength = studentSheet.getRows();
		students = new StudentQueue(studentSheetLength);
		for(int i=0;i<studentSheetLength;i++){
			String studentName = studentSheet.getCell(0, i).getContents();
			String[] preference = new String[5];
			
			for(int j=1;j<=5;j++){
				preference[j-1] = studentSheet.getCell(j ,i).getContents();
			}
			students.enQueue(new Student(studentName, preference));
		}
		studentWorkbook.close();
	}
	
	/**
	 * Function to allocate Programs to students rank-wise
	 * @throws Exception if workbook is not created
	 */
	public void allocatePrograms() throws Exception {
		WritableWorkbook allocationWorkbook = Workbook.createWorkbook(new File("files/Allocation.xls"));
		WritableSheet allocationSheet = allocationWorkbook.createSheet("Allocation", 0);
		int index = 0;
		while(!students.isEmpty()) {
			Student student = students.deQueue();

			for(String preference: student.getProgramPreference()){
				if(programs.get(preference) == null){
					throw new Exception("Invalid Preference Found!");
				}
				if(programs.get(preference).isSeatAvailable()){
					student.setAllocatedProgram(preference);
					programs.get(preference).occupySeat();
					break;
				}
			}
			allocationSheet.addCell(new Label(0, index, student.getName()));
			allocationSheet.addCell(new Label(1, index, student.getAllocatedProgram()));
			index++;
		}
		allocationWorkbook.write();
		allocationWorkbook.close();
	}
}
