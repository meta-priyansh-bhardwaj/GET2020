import java.util.ArrayList;
import java.util.List;

public class Crocodile extends Reptile {

	public Crocodile(String name,int age,float weight,float length){
		// numberOfLegs = 4
		super(name, age, 4, weight, length);
	}

	@Override
	public String getSound() {
		return "Hiss";
	}
	
	@Override
	public String getType() {
		return "Crocodile";
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
