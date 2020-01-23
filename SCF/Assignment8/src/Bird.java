
public abstract class Bird implements Animal{
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	float lengthOfFeathers;
	boolean canFly;
	public String getCategory() {
		return "Bird";
	}
	public String getNameOfAnimal() {
		return Name;
	}
	public int getAgeOfAnimal() {
		return Age;
	}
	public float getWeightOfAnimal() {
		return weight;
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
}
