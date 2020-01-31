
public abstract class Mammal extends Animal{
	private int numberOfLegs;
	
	public Mammal(String name,int age,float weight,int numberOfLegs){
		super(name, age, weight);
		this.numberOfLegs = numberOfLegs;
	}
	
	@Override
	public String getCategory() {
		return "Mammal";
	}
	
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
}
