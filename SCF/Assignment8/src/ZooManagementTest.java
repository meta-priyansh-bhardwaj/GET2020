import static org.junit.Assert.*;

import org.junit.Test;

public class ZooManagementTest {
	ZooManager zoomanager=new ZooManager(10);
	@Test
	public void zooManagementTest() {
		
		assertEquals(true,zoomanager.addNewZone(3, "Mammal", "zone1"));
		assertEquals(true,zoomanager.addNewZone(4, "Reptile", "zone2"));
		
		//cage list is empty thus no animal can be added to cage 
		assertEquals(false,zoomanager.zoneList.get(0).addAnimalToZone("sher", 12, 12,"Lion","Mammal"));
		
		//zone type is reptile and cage type is snake ,compatible with each other
		assertEquals(true,zoomanager.zoneList.get(1).addCage(1, "Snake"));
		
		//zone type is mammal and cage type is snake ,not compatible with each other
		assertNotEquals(true,zoomanager.zoneList.get(0).addCage(1, "Snake"));
		
		//zone type is mammal and cage type is Lion ,compatible with each other
		assertEquals(true,zoomanager.zoneList.get(0).addCage(1, "Lion"));
		
		//zone type is mammal and cage type is Lion ,compatible with each other
		assertEquals(true,zoomanager.zoneList.get(0).addCage(1, "Lion"));
		
		//zone type is mammal and cage type is BlackBear ,compatible with each other
		assertEquals(true,zoomanager.zoneList.get(0).addCage(1, "BlackBear"));
	
		//zone type is mammal and cage type is BlackBear ,compatible with each other but zone is full
		assertNotEquals(true,zoomanager.zoneList.get(0).addCage(1, "BlackBear"));
		
		//zone type is mammal, cage type is Lion and animal type is lion ,animal get added
		assertEquals(true,zoomanager.zoneList.get(0).addAnimalToZone("Sher", 12, 23, "Lion", "Mammal"));
		
		//zone type is mammal and animal type is lion ,animal get added
		assertEquals(true,zoomanager.zoneList.get(0).addAnimalToZone("Sher1", 12, 23, "Lion", "Mammal"));
		
		//zone type is mammal, cage type is Lion and animal type is lion ,but there is no cage of lion type available
		assertNotEquals(true,zoomanager.zoneList.get(0).addAnimalToZone("Singh", 12, 23, "Lion", "Mammal"));
		
		//zone type is mammal, cage type is BlackBear and animal type is BlackBear ,but there is no cage of lion type available
		assertEquals(true,zoomanager.zoneList.get(0).addAnimalToZone("Singh1", 12, 23, "BlackBear", "Mammal"));
		
		//zone type is mammal, cage type is BlackBear and animal type is BlackBear,both are compatible but no cage available
		assertNotEquals(true,zoomanager.zoneList.get(0).addAnimalToZone("bear", 12, 23, "BlackBear", "Mammal"));
		
		//zone type is reptile and animal type is snake ,but there is no cage of snake type available,not created yet
		assertEquals(false,zoomanager.zoneList.get(1).addAnimalToZone("snaky", 12, 23,20, "Sanke", "Reptile"));
		
		//zone type is Reptile and cage type is Snake ,compatible with each other
		assertEquals(true,zoomanager.zoneList.get(1).addCage(1, "Snake"));
		
		//zone type is reptile ,cage type is Snake and animal type is snake ,compatible with each other and space available
		assertEquals(true,zoomanager.zoneList.get(1).addAnimalToZone("snaky", 12, 12, 20, "Snake", "Reptile"));
		
		//occupied capacity of first cage of lion type in mammal zone
		assertEquals(1,zoomanager.zoneList.get(0).cageList.get(0).occupiedCapacityOfCage());
		
		//death of animal 
		assertEquals(true,zoomanager.zoneList.get(0).cageList.get(0).deathOfAnimal("Sher","Lion","Mammal"));
		
		//occupied capacity of first cage of lion type in mammal zone after death of animal
		assertEquals(0,zoomanager.zoneList.get(0).cageList.get(0).occupiedCapacityOfCage());
	}
	

}
