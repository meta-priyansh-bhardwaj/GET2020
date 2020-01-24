import java.util.List;

public abstract class Animal {
	private String name;
	private int age;
	private float weight;
	private int id;
	public static int noOfAnimals = 0;
	
	public Animal(String name,int age,float weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.id = noOfAnimals++;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public int getId(){
		return id;
	}
	
	public abstract String getSound();
	public abstract String getCategory();
	public abstract String getType();
	public abstract List<String> getInfo();
}
