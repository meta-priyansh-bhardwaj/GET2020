
public abstract class Reptile implements Animal {
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	float LengthInMeters;
	public String getCategory() {
		return "Reptile";
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
	public float getLengthOfAnimal() {
		return LengthInMeters;
	}
}
