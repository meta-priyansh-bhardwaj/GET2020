import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooManager {
	int capacityOfZoo;
	int spareCapacityOfZoo;
	Scanner sc=new Scanner(System.in);
	List<Zones> zoneList=new ArrayList<Zones>();
	public ZooManager(int capacityOfZoo) {
		this.capacityOfZoo=capacityOfZoo;
		spareCapacityOfZoo=0;
	}
	/**
	 * add new zone to zoo along with unique zone name,type and capacity
	 * @param capacityOfZone
	 * @param typeOfZone
	 * @param ZoneName name should be unique
	 */
	public boolean addNewZone(int capacityOfZone,String typeOfZone,String ZoneName) {
		if(spareCapacityOfZoo<capacityOfZoo) {
			zoneList.add(new Zones(capacityOfZone,typeOfZone,ZoneName));
			spareCapacityOfZoo++;
			return true;
		}
	return false;
	}
	/**
	 * get list of all zones available in zoo
	 * @return list of zones
	 */
	public List<Zones> getZoneList(){
		return zoneList;
	}
	/**
	 * adds animal 
	 * @param name should be unique
	 * @param age
	 * @param weight
	 * @param lengthInMeters
	 * @param lengthOfFeathers
	 * @param canFly
	 * @param type
	 * @param category
	 * @return
	 */
	public boolean addAnimal(String name,int age,float weight ,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.typeOfZone.equals(category)) {
				animalAdded=zone.addAnimalToZone(name, age, weight, type, category);
				if(animalAdded) {
					break;
				}
			}
		}
		return animalAdded;
	}
	public boolean addAnimal(String name,int age,float weight,float lengthInMeters ,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.typeOfZone.equals(category)) {
				animalAdded=zone.addAnimalToZone(name, age, weight, lengthInMeters, type, category);
				if(animalAdded) {
					break;
				}
			}
		}
		return animalAdded;
	}
	public boolean addAnimal(String name,int age,float weight,float lengthInMeters ,float lengthOfFeathers,boolean canFly,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.typeOfZone.equals(category)) {
				animalAdded=zone.addAnimalToZone(name, age, weight, lengthInMeters,lengthOfFeathers,canFly, type, category);
				if(animalAdded) {
					break;
				}
			}
		}
		return animalAdded;
	}
	public boolean deathOfAnimal(String name,String type,String category){
		boolean death=false;
		for(Zones zone:zoneList){
			if(zone.getTypeOfZone().equals(category)){
				death=zone.deathOfAnimal(name,type,category);
			}
		}
		return death;
	}
	/**
	 * get name of all animals in zoo including cages,zones
	 * @return
	 */
	public List<String> allAnimalsInZoo(){
		List<String> animalsInZone=new ArrayList<String>();
		for(Zones zone:zoneList) {
			for(Cage cage:zone.cageList) {
				for(Animal animal:cage.animalList) {
					animalsInZone.add(animal.getName());
				}
			}
		}
		return animalsInZone;
	}
	/**
	 * search animal by their name in zoo
	 * @param animalName
	 * @return
	 */
	public List<String> findAnimalByName(String animalName){
		List<String> animalDetails=new ArrayList<String>();
		for(Zones zone:zoneList) {
		animalDetails=zone.findAnimals(animalName);
		}
		return animalDetails;
	}
	/**
	 * total capacity of zoo 
	 * @return
	 */
	public int totalCapacityOfZoo() {
		return capacityOfZoo;
	}
	/**
	 * 
	 * @param zoneName
	 * @return
	 */
	public int totalCapacityOfSpecificZone(String zoneName) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(zoneName)) {
				return zone.totalCapacityOfZone();
			}
		}
		return 0;
	}
	public int totalCapacityOfSpecificCage(String zoneName,int cageNumber) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(zoneName)) {
				return zone.cageList.get(cageNumber-1).totalCapacityOfCage();
			}
		}
		return 0;
	}
	public int spareCapacityOfZoo() {
		int sum=0;
		for(Zones zone:zoneList) {
			sum+=spareCapacityOfSpecificZone(zone.ZoneName);
		}
		return sum;
	}
	public int spareCapacityOfSpecificZone(String ZoneName) {
		int sum=0;
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(ZoneName)) {
				for(int i=0;i<zone.cageList.size();i++) {
					sum+=zone.cageList.get(i).spareCapacityOfCage();
				}
				return sum;
			}
		}
		return 0;
	}
	public int spareCapacityOfSpecificCage(String ZoneName,int cageNumber) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(ZoneName)) {
				return zone.cageList.get(cageNumber-1).spareCapacityOfCage();
				
			}
		}
		return 0;
	}
	public void move(String ZoneName,int fromCageNumber,int toCageNumber,String animalName) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(ZoneName)) {
				if(zone.cageList.get(toCageNumber-1).cageType.equals(zone.cageList.get(fromCageNumber-1).cageType)) {
				for(Animal animal:zone.cageList.get(fromCageNumber-1).animalList) {
					if(animal.getName().equals(animalName)) {
						zone.cageList.get(toCageNumber-1).animalList.add(animal);
						zone.cageList.get(fromCageNumber-1).animalList.remove(animal);
					}
				}
				}
			}
		}
	}
	
}