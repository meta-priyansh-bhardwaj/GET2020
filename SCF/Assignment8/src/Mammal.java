
public abstract class Mammal implements Animal{
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	public String getCategory() {
		return "Mammal";
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
}
