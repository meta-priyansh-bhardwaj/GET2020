import java.util.ArrayList;
import java.util.List;

public class BlackBear extends Mammal {
	
	public BlackBear(String name,int age,float weight){
		// numberOfLegs = 2
		super(name, age, weight, 2);
	}
	
	@Override
	public String getSound() {
		return "Growls";
	}
	
	@Override
	public String getType() {
		return "Bear";
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
