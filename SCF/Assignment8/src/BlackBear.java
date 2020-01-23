import java.util.ArrayList;
import java.util.List;

public class BlackBear extends Mammal {
	BlackBear(String name,int age,float weight){
		super.Name=name;
		super.Age=age;
		super.weight=weight;
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
		return "Growls";
	}
	public String getType() {
		return "Bear";
	}
	public int numberOfLegs() {
		int numberOfLegs= 2;
		return numberOfLegs;
	}
	public List<String> getInfo(){
		List<String> animalDetails=new ArrayList<String>();
		animalDetails.add(getName());
		animalDetails.add(getSound());
		animalDetails.add(getType());
		animalDetails.add(Integer.toString(getAge()));
		animalDetails.add(Integer.toString(numberOfLegs()));
		animalDetails.add(Float.toString(getweight()));
		return animalDetails;
	}
}
