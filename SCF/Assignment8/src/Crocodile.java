import java.util.ArrayList;
import java.util.List;

public class Crocodile extends Reptile {

	Crocodile(String name,int age,float weight,float length){
		super.Name=name;
		super.Age=age;
		super.weight=weight;
		super.LengthInMeters=length;
	}
	public String getName() {
		return Name;
	}
	public int getAge() {
		return Age;
	}
	public float getweight() {
		return weight;
	}
	public String getSound() {
		return "Hiss";
	}
	public String getType() {
		return "Crocodile";
	}
	public int numberOfLegs() {
		int numberOfLegs= 4;
		return numberOfLegs;
	}
	public float getLength() {
		return LengthInMeters;
	}
	public List<String> getInfo(){
		List<String> animalDetails=new ArrayList<String>();
		animalDetails.add(getName());
		animalDetails.add(getSound());
		animalDetails.add(getType());
		animalDetails.add(Integer.toString(getAge()));
		animalDetails.add(Integer.toString(numberOfLegs()));
		animalDetails.add(Float.toString(getweight()));
		animalDetails.add(Float.toString(getLength()));
		return animalDetails;
	}
}
