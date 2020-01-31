
public abstract class Bird extends Animal{
	int numberOfLegs;
	float lengthOfFeathers;
	boolean canFly;
	
	public Bird(String name,int age,float weight, int numberOfLegs, float lengthOfFeathers, boolean canFly){
		super(name, age, weight);
		this.lengthOfFeathers = lengthOfFeathers;
		this.canFly = canFly;
	}
	
	@Override
	public String getCategory() {
		return "Bird";
	}
	
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	
	public float getFeatherLength() {
		return lengthOfFeathers;
	}
	
	public boolean canFly() {
		return canFly;
	}
	
	public float getLength() {
		return lengthOfFeathers;
	}
}
