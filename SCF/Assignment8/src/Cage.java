import java.util.ArrayList;
import java.util.List;

public class Cage {
	int totalCapacityOfCage;
	int capacityOfCage;
	String cageType;
	List<Animal> animalList=new ArrayList<Animal>();
	public Cage(int capacityOfCage,String cageType){
		this.totalCapacityOfCage=capacityOfCage;
		this.capacityOfCage=0;	
		this.cageType=cageType;
	}
	/**
	 * Add animal to cage compatible with type of animal 
	 * @param name animal name should be unique
	 * @param age animal age
	 * @param weight animal weight
	 * @param type
	 * @return true if animal added to cage successfully else false
	 */
	public boolean addAnimalToCage(String name,int age,float weight,String type) {
		boolean successOfAddingAnimal=false;
		if(capacityOfCage<totalCapacityOfCage && cageType.equals(type)) {
			switch(type) {
				case "Lion":
					animalList.add(new Lion(name,age,weight));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
				case "BlackBear":
					animalList.add(new BlackBear(name,age,weight));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
				default :
					System.out.println("No Such Animal");
					break;
			}
		}
		return successOfAddingAnimal;
			
	}
	//function overloading
	/**
	 * Add animal to cage compatible with type of animal 
	 * @param name animal name should be unique
	 * @param age animal age
	 * @param weight animal weight
	 * @param type
	 * @return true if animal added to cage successfully else false
	 */
	public boolean addAnimalToCage(String name,int age,float weight,float lengthInMeters,String type) {
		boolean successOfAddingAnimal=false;
		if(capacityOfCage<totalCapacityOfCage && cageType.equals(type)) {
			switch(type) {
				case "Snake":
					animalList.add(new Snake(name,age,weight,lengthInMeters));
					capacityOfCage++;
					successOfAddingAnimal=true;;
					break;
				case "Crocodile":
					animalList.add(new Crocodile(name,age,weight,lengthInMeters));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
				default :
					System.out.println("No Such Animal");
					break;
			}
		}
		return successOfAddingAnimal;
	}
	//function overloading
	/**
	 * Add animal to cage compatible with type of animal 
	 * @param name animal name should be unique
	 * @param age animal age
	 * @param weight animal weight
	 * @param type
	 * @return true if animal added to cage successfully else false
	 */
	public boolean addAnimalToCage(String name,int age,float weight,float lengthOfFeathers,boolean canFly,String type) {
		boolean successOfAddingAnimal=false;
		if(capacityOfCage<totalCapacityOfCage && cageType.equals(type)) {
			switch(type) {
				case "Snake":
					animalList.add(new Peacock(name,age,weight,lengthOfFeathers,canFly));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
			
				default :
					System.out.println("No Such Animal");
					break;
		
			}
		}
		return successOfAddingAnimal;
	}
	public boolean deathOfAnimal(String name,String type,String category){
		Animal animal1=null;
		boolean death=false;
		for(Animal animal:animalList){
			if(animal.getName().equals(name)){
				animal1=animal;
				
			}
		}
		if(animal1!=null){
		animalList.remove(animal1);
		capacityOfCage--;
		death = true;
		}
		return death;
	}
	/**
	 * @return current capacity of cage
	 */
	public int getCageCapacity() {
		return capacityOfCage;
	}
	/**
	 * @return type of cage 
	 */
	public String getCageType() {
		return cageType;
	}
	/**
	 * return list of all animals in specific cage 
	 * @return list of name of all animals
	 */
	public List<String> getNameOfAllAnimalsInCage() {
		List<String> animalNameList=new ArrayList<String>();
		for(Animal animal:animalList) {
			animalNameList.add(animal.getName());
		}
		return animalNameList;
	}
	/**
	 * search animal by unique animal name
	 * @param animalName unique name of animal
	 * @return list of animal information
	 */
	public List<String> findAnimals(String animalName){
		List<String> animalDetails=new ArrayList<String>();
		for(Animal animal:animalList) {
			if(animal.getName().equals(animalName)) {
				animalDetails=animal.getInfo();
			}
		}
		return animalDetails;
	}
	/**
	 * @return total capacity of cage
	 */
	public int totalCapacityOfCage() {
		return totalCapacityOfCage;
	}
	/**
	 * @return spare capacity of cage
	 */
	public int occupiedCapacityOfCage() {
		return capacityOfCage;
	}
	public int spareCapacityOfCage() {
		return totalCapacityOfCage-capacityOfCage;
	}
	
}
