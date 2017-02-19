import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import CitySim9004.Building;
import CitySim9004.Road;
import CitySim9004.City;

public class CityTest{

	//Asserts that an instance of a City can be created
	@Test 
	public void testCityContructor(){
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
}