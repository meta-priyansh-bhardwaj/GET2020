
public abstract class Reptile extends Animal {
	int numberOfLegs;
	float LengthInMeters;
	
	public Reptile(String name,int age,int numberOfLegs,float weight,float length){
		super(name, age, weight);
		this.LengthInMeters = length;
		this.numberOfLegs = numberOfLegs;
	}
	
	@Override
	public String getCategory() {
		return "Reptile";
	}
	
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	
	public float getLengthOfAnimal() {
		return LengthInMeters;
	}
	
	public float getLength() {
		return LengthInMeters;
	}
}
