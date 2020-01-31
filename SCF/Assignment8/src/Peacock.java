import java.util.ArrayList;
import java.util.List;

public class Peacock extends Bird {
	public Peacock(String name,int age,float weight,float length,boolean canFly){
		// numberOfLegs = 0
		super(name, age, weight, 0, length, canFly);
	}

	@Override
	public String getSound() {
		return "Scream";
	}
	
	@Override
	public String getType() {
		return "Peacock";
	}
	
	
	
	@Override
	public List<String> getInfo(){
		List<String> animalDetails=new ArrayList<String>();
		animalDetails.add(getName());
		animalDetails.add(getSound());
		animalDetails.add(getType());
		animalDetails.add(Integer.toString(getAge()));
		animalDetails.add(Integer.toString(getNumberOfLegs()));
		animalDetails.add(Float.toString(getWeight()));
		animalDetails.add(Float.toString(getLength()));
		return animalDetails;
	}

}
