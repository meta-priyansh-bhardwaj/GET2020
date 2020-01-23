import java.util.Scanner;

public class Zoo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ZooManager zonemanager=new ZooManager(15);
		do {
			System.out.println("1: View");
			System.out.println("2: Add Animal");
			System.out.println("3: Add Zone");
			System.out.println("4: Add Cage");
			System.out.println("5: Exit");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				if(zonemanager.zoneList.size()>0){
				for(Zones zone:zonemanager.zoneList) {
					System.out.println(zone.ZoneName+
					"\t"+zone.capacityOfZone
					+"\t"+zone.typeOfZone);
					System.out.println("------------");
					for(Cage cage:zone.cageList) {
						
						System.out.println("\t"+cage.cageType
						+"\t"+cage.totalCapacityOfCage);
						for(Animal animal:cage.animalList){
							System.out.println(animal.getInfo());
						}
					}
				}
				}
				else{
					System.out.println("No zones");
				}
				break;
			case 2:
				//if(zonemanager.zoneList.size()>0){
					
					System.out.println("Enter Animal Name");
					String name=sc.next();
					System.out.println("Enter Animal age");
					int age=sc.nextInt();
					System.out.println("Enter Animal Weight");
					float weight=sc.nextFloat();
					System.out.println("Enter Animal Length in Meters");
					float length=sc.nextFloat();
					System.out.println("Enter Animal Feathers Length");
					float featherLength=sc.nextFloat();
					System.out.println("Can Fly Or Not");
					boolean canFly=sc.nextBoolean();
					System.out.println("Enter Animal Type");
					String type=sc.next();
					System.out.println("Enter Animal Category");
					String category=sc.next();
					boolean animalAdded=false;
					if(category.equals("Mammal")){
					animalAdded=zonemanager.addAnimal(name, age, weight, type, category);
					}
					else if(category.equals("Reptile")){
					animalAdded=zonemanager.addAnimal(name, age, weight, length, type, category);
					}
					else if(category.equals("Bird")){
					animalAdded=zonemanager.addAnimal(name, age, weight, length, featherLength,
							canFly, type, category);
					}
					else{
						System.out.println("no");
					}
					if(animalAdded) {
						System.out.println("Animal Added");
					}
					else {
						System.out.println("No Space Available In Any Zone");
					}
				
				/*else{
						System.out.println("No Zones");
					}*/
				
				break;
			case 3:
				System.out.println("Enter Zone Name");
				String zoneName=sc.next();
				System.out.println("Enter Zone Capacity");
				int zoneCapacity=sc.nextInt();
				System.out.println("Enter Zone Type");
				String zoneType=sc.next();
				zonemanager.addNewZone(zoneCapacity, zoneType, zoneName);
				break;
			case 4:
				System.out.println("Enter Name Of Zone In Which You want To Add New Cage");
				String ZoneName=sc.next();
				for(Zones zone:zonemanager.zoneList) {
					if(ZoneName.equals(zone.ZoneName)) {
						if(zone.totalCapacityOfZone>0) {
							System.out.println("Enter Cage Capacity");
							int cageCapacity=sc.nextInt();
							System.out.println("Enetr CageType");
							String cageType=sc.next();
						
								System.out.println("added");
								zone.addCage(cageCapacity, cageType);
							}
						}
					else {
						System.out.println("No Space in zone");
						}
					}
				
				break;
			case 5:
				System.exit(0);
				break;
				
			}
			
		}while(true);
	}
}
