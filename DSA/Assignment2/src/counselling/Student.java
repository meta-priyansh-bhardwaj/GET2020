package counselling;

/**
 * Class to visualise a Student
 *
 */
public class Student {
	private String name;
	private String[] programPreference;
	private String allocatedProgram;
	
	/**
	 * Constructor to initialize name of student and his/her preference
	 * @param name of student
	 * @param programPreference array of preferences
	 */
	public Student(String name, String[] programPreference){
		this.name = name;
		this.programPreference = new String[programPreference.length];
		for(int i=0;i<programPreference.length;i++){
			this.programPreference[i] = programPreference[i];
		}
		this.allocatedProgram = "Not Allocated";
	}
	
	/**
	 * Function to get name of the student
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Function to get program preferences
	 * @return programPreferences
	 */
	public String[] getProgramPreference(){
		return this.programPreference;
	}
	
	/**
	 * Function to get program allocated to the student
	 * @return allocatedProgram
	 */
	public String getAllocatedProgram(){
		return this.allocatedProgram;
	}
	
	/**
	 * Function to set program allocated to the student
	 * @param allocatedProgram
	 */
	public void setAllocatedProgram(String allocatedProgram){
		this.allocatedProgram = allocatedProgram;
	}
}
