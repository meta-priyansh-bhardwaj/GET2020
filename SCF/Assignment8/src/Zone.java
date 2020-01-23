import java.util.List;

public interface Zone {
	List<Cage> getInfoOfCages();
	void addCage(int capacityOfCage,String typeOfCage);
	int capacityOfZone();
	String getTypeOfZone();
	boolean addAnimalToZone(String name,int age,float weight,float lengthInMeters ,String type);
}
