import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import CitySim9004.Building;
import CitySim9004.Road;


public class BuildingTest{

	//Asserts that an instance of a Building can be created
	@Test 
	public void testBuildingContructor(){
		Building sennott = new Building();
		assertNotNull(sennott);
	}
	//Asserts that a name can be assigned to a Building and retrieved
	@Test
	public void testBuildingHasName(){
		Building sennott = new Building();
		sennott.setName("Sennott");
		assertEquals(sennott.getName(), "Sennott");
	}
	//Tests to make sure we know how many roads are leaving this building
	@Test
	public void testNumOfRoads(){
		Building sennott = new Building();

		assertEquals(sennott.numOfRoads(), 0);
	}
	//MOCKITO
	//test to make sure we are properly adding roads
	@Test
	public void testRoadsAdd(){
		Building sennott = new Building();
		Road mockRoad1 = mock(Road.class);
		Road mockRoad2 = mock(Road.class);

		sennott.addRoad(mockRoad1);
		sennott.addRoad(mockRoad2);
		assertEquals(sennott.numOfRoads(), 2);
	}
	//Tests if a road can be chosen given any integer as a seed
	@Test
	public void testChooseRoad(){
		Building sennott = new Building();
		Road mockRoad1 = mock(Road.class);
		Road mockRoad2 = mock(Road.class);

		sennott.addRoad(mockRoad1);
		sennott.addRoad(mockRoad2);

		//assert that the first road added is returned
		assertSame(sennott.chooseRoad(0), mockRoad1);
		assertNotSame(sennott.chooseRoad(0), mockRoad2);
		//assert that the first road added is returned when inputting the size or a multiple of the size
		assertSame(sennott.chooseRoad(sennott.numOfRoads()), mockRoad1);
		assertNotSame(sennott.chooseRoad(sennott.numOfRoads()), mockRoad2);
		//assert that the second road can be reached from a negative number
		assertSame(sennott.chooseRoad(-sennott.numOfRoads() + 1), mockRoad2);
		assertNotSame(sennott.chooseRoad(-sennott.numOfRoads() + 1), mockRoad1);

		//assert that null is returned if there are no roads
		Building starbucks = new Building();
		assertNull(starbucks.chooseRoad(0));	
	}
}