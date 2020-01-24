import java.util.ArrayList;
import java.util.List;

public class Lion extends Mammal {

	public Lion(String name,int age,float weight){
		// numberOfLegs = 4
		super(name, age, weight, 4);
	}

	@Override
	public String getSound() {
		return "Roar";
	}
	
	@Override
	public String getType() {
		return "Lion";
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
		return animalDetails;
	}
}
