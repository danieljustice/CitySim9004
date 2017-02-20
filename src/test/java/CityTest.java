import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import CitySim9004.Building;
import CitySim9004.Road;
import CitySim9004.City;
import CitySim9004.Car;

public class CityTest{

	//Asserts that an instance of a City can be created
	@Test 
	public void testCityConstructor(){
		City pittsburgh = new City();
		assertNotNull(pittsburgh);
	}
	//Tests to make sure we know how many buildings this city has
	@Test
	public void testNumOfBuildings(){
		City pittsburgh = new City();

		assertEquals(pittsburgh.numOfBuildings(), 0);
	}
	//MOCKITO
	//test to make sure we are properly adding buildings
	@Test
	public void testAddBuilding(){
		City pittsburgh = new City();
		Building mockBuilding1 = mock(Building.class);
		Building mockBuilding2 = mock(Building.class);
		
		assertEquals(pittsburgh.numOfBuildings(), 0);
		pittsburgh.addBuilding(mockBuilding1);
		assertEquals(pittsburgh.numOfBuildings(), 1);
		pittsburgh.addBuilding(mockBuilding2);
		assertEquals(pittsburgh.numOfBuildings(), 2);
	}

	//SPLIT this into three test, check for null when list is empty, check for null when
	//no good options in list, check that it only chooses good options
	@Test
	public void testChooseStartingBuilding(){
		City pittsburgh = new City();
		Building mockBuilding1 = mock(Building.class);
		Building mockBuilding2 = mock(Building.class);

		//stub the getIsInCity() method
		when(mockBuilding1.getIsInCity()).thenReturn(true);
		when(mockBuilding2.getIsInCity()).thenReturn(false);

		//test that we get null back if there are no buildings
		assertNull(pittsburgh.chooseStartingBuilding(0));

		pittsburgh.addBuilding(mockBuilding2);
		//test that we get null back if we have no buildings that are in the city
		assertNull(pittsburgh.chooseStartingBuilding(0));

		pittsburgh.addBuilding(mockBuilding1);

		assertEquals(pittsburgh.chooseStartingBuilding(0), mockBuilding1);
		assertEquals(pittsburgh.chooseStartingBuilding(1), mockBuilding1);
	}

	//A city should be able to look at a building and choose one of the connected buildings via a road
	//If there are no roads then return null
	//This test builds a triangle of buildings where both building 1 and 2 point to the other two buildings
	//but building 3 points nowhere
	//all of the connections are then tested
	@Test
	public void testChooseNextBuilding(){
		City pittsburgh = new City();
		Building mockBuilding1 = mock(Building.class);
		Building mockBuilding2 = mock(Building.class);
		Building mockBuilding3 = mock(Building.class);

		Road mockRoad1 = mock(Road.class);
		Road mockRoad2 = mock(Road.class);
		Road mockRoad3 = mock(Road.class);
		Road mockRoad4 = mock(Road.class);
		
		//stubbing in Building.chooseRoad(int), simulates the road array list for each building 
		when(mockBuilding1.chooseRoad(0)).thenReturn(mockRoad1);
		when(mockBuilding1.chooseRoad(1)).thenReturn(mockRoad2);
		when(mockBuilding2.chooseRoad(0)).thenReturn(mockRoad3);
		when(mockBuilding2.chooseRoad(1)).thenReturn(mockRoad4);
		when(mockBuilding3.chooseRoad(anyInt())).thenReturn(null);
		//stubbing in Road.getTo() method
		when(mockRoad1.getTo()).thenReturn(mockBuilding2);
		when(mockRoad2.getTo()).thenReturn(mockBuilding3);
		when(mockRoad3.getTo()).thenReturn(mockBuilding1);
		when(mockRoad4.getTo()).thenReturn(mockBuilding3);
		//Will start at mockBuilding1, so it is the only one that needs to mock if it is in the city
		when(mockBuilding1.getIsInCity()).thenReturn(true);
		//Stubbing in Building.numOfRoads()
		when(mockBuilding1.numOfRoads()).thenReturn(2);
		when(mockBuilding2.numOfRoads()).thenReturn(2);
		when(mockBuilding3.numOfRoads()).thenReturn(0);
		//add all of the buildings to the city
		pittsburgh.addBuilding(mockBuilding1);
		pittsburgh.addBuilding(mockBuilding2);
		pittsburgh.addBuilding(mockBuilding3);
		

		//SET UP COMPLETE - now begin testing

		//Start at mockBuilding1
		Building currentMockBuilding = pittsburgh.chooseStartingBuilding(0);
		assertEquals(mockBuilding1, currentMockBuilding);
		//Traverse to mockBuilding2 via mockRoad1
		currentMockBuilding = pittsburgh.chooseNextBuilding(currentMockBuilding, 0);
		assertEquals(mockBuilding2, currentMockBuilding);
		//Traverse to mockBuilding1 via mockRoad3
		currentMockBuilding = pittsburgh.chooseNextBuilding(currentMockBuilding, 0);
		assertEquals(mockBuilding1, currentMockBuilding);
		//Traverse to mockBuilding3 via mockRoad2
		currentMockBuilding = pittsburgh.chooseNextBuilding(currentMockBuilding, 1);
		assertEquals(mockBuilding3, currentMockBuilding);
		//Cannot traverse anywhere so null should be returned
		currentMockBuilding = pittsburgh.chooseNextBuilding(currentMockBuilding, 1);
		assertNull(currentMockBuilding);
		//Traverse from arbitray building (mockBuilding2) to another (mockBuilding3)
		currentMockBuilding = pittsburgh.chooseNextBuilding(mockBuilding2, 1);
		assertEquals(currentMockBuilding, mockBuilding3);
	}

	//A car should start at a building in the city (Sennott or Union) and then 
	//move around until it goes outside the city (Philadelphia)
	//Given the same seed a car should make the same route, given a different 
	//seed a car should possibly take a different route
	@Test
	public void testDriveCar(){

		//SET UP
		City pittsburgh = new City();

		Building sennott = new Building();
		sennott.setName("Sennott");

		Building union = new Building();
		union.setName("Union");

		Building philly = new Building();
		philly.setName("Philadelphia");
		philly.setIsInCity(false);

		Road fourth = new Road();
		fourth.setName("Fourth Ave");
		fourth.setFrom(union);
		fourth.setTo(philly);
		Road phil1 = new Road();
		phil1.setName("Phil St");
		phil1.setFrom(union);
		phil1.setTo(sennott);
		Road phil2 = new Road();
		phil2.setName("Phil St");
		phil2.setFrom(sennott);
		phil2.setTo(union);
		Road fifth = new Road();
		fifth.setName("Fifth Ave");
		fifth.setFrom(sennott);
		fifth.setTo(philly);


		sennott.addRoad(phil2);
		sennott.addRoad(fifth);
		union.addRoad(fourth);
		union.addRoad(phil1);

		pittsburgh.addBuilding(sennott);
		pittsburgh.addBuilding(union);
		pittsburgh.addBuilding(philly);

		Car testCar1 = new Car();
		testCar1.setName("Driver 1");
		Car testCar2 = new Car();
		testCar2.setName("Driver 2");		
		//SET UP Complete
		//START TEST

		//printouts for testCar1 and testCar2 should be the same (except for teh car name)
		pittsburgh.driveCar(testCar1, 0);
		pittsburgh.driveCar(testCar1, 1);
		pittsburgh.driveCar(testCar1, 2);

		pittsburgh.driveCar(testCar2, 0);
		pittsburgh.driveCar(testCar2, 1);
		pittsburgh.driveCar(testCar2, 2);
	}

	// @Test
	// public void testPrintTraversal(){
	// 	City pittsburgh = new City();
	// 	Building mockBuilding1 = mock(Building.class);
	// 	Building mockBuilding2 = mock(Building.class);
	// 	Building mockBuilding3 = mock(Building.class);

	// 	Road mockRoad1 = mock(Road.class);
	// 	Road mockRoad2 = mock(Road.class);
	// 	Road mockRoad3 = mock(Road.class);
	// 	Road mockRoad4 = mock(Road.class);
		
	// 	//stubbing in Building.chooseRoad(int), simulates the road array list for each building 
	// 	when(mockBuilding1.chooseRoad(0)).thenReturn(mockRoad1);
	// 	when(mockBuilding1.chooseRoad(1)).thenReturn(mockRoad2);
	// 	when(mockBuilding2.chooseRoad(0)).thenReturn(mockRoad3);
	// 	when(mockBuilding2.chooseRoad(1)).thenReturn(mockRoad4);
	// 	when(mockBuilding3.chooseRoad(anyInt())).thenReturn(null);
	// 	//stubbing in Road.getTo() method
	// 	when(mockRoad1.getTo()).thenReturn(mockBuilding2);
	// 	when(mockRoad2.getTo()).thenReturn(mockBuilding3);
	// 	when(mockRoad3.getTo()).thenReturn(mockBuilding1);
	// 	when(mockRoad4.getTo()).thenReturn(mockBuilding3);
	// 	//Will start at mockBuilding1, so it is the only one that needs to mock if it is in the city
	// 	when(mockBuilding1.getIsInCity()).thenReturn(true);
	// 	//Stubbing in Building.numOfRoads()
	// 	when(mockBuilding1.numOfRoads()).thenReturn(2);
	// 	when(mockBuilding2.numOfRoads()).thenReturn(2);
	// 	when(mockBuilding3.numOfRoads()).thenReturn(0);
	// 	//add all of the buildings to the city
	// 	pittsburgh.addBuilding(mockBuilding1);
	// 	pittsburgh.addBuilding(mockBuilding2);
	// 	pittsburgh.addBuilding(mockBuilding3);
		
	// }
	// @Test
	// public void testDriveCar(){

	// }

}