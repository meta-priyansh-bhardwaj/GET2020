import java.util.ArrayList;
import java.util.List;

public class Snake extends Reptile {
	Snake(String name,int age,float weight,float length){
		// numberOfLegs = 0
		super(name, age, 0, weight, length);
	}

	@Override
	public String getSound() {
		return "Hiss";
	}
	
	@Override
	public String getType() {
		return "Snake";
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
