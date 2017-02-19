import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import CitySim9004.Road;
import CitySim9004.Building;


public class RoadTest{

	//Assures that an instance of a Road can be made
	@Test 
	public void testRoadContructor(){
		Road fifth = new Road();
		assertNotNull(fifth);
	}

	//Assures that an instance of a Road can be given a Name and retrieved
	@Test
	public void testRoadHasName(){
		Road fifth = new Road();
		fifth.setName("Fifth");
		assertEquals(fifth.getName(), "Fifth");
	}
	//MOCKITO
	//Asserts that from Building can be added and retrieved
	@Test
	public void testRoadGetFrom(){
		Road fifth = new Road();
		Building mockBuilding = mock(Building.class);
		fifth.setFrom(mockBuilding);
		assertNotNull(fifth.getFrom());
	}

	//MOCKITO
	//Asserts that to Building can be added and retrieved
	@Test
	public void testRoadGetTo(){
		Road fifth = new Road();
		Building mockBuilding = mock(Building.class);
		fifth.setTo(mockBuilding);
		assertNotNull(fifth.getTo());
	}

	//MOCKITO
	//Asserts that To and From cannot be set to the same (unless they are null)
	@Test
	public void testUnequalToAndFrom(){
		Road fifth = new Road();
		Building mockBuilding1 = mock(Building.class);
		Building mockBuilding2 = mock(Building.class);
		//tests that they can be set to different buildings
		fifth.setFrom(mockBuilding1);
		fifth.setTo(mockBuilding2);	
		assertNotEquals(fifth.getFrom(),  fifth.getTo());

		//test that To cannot be set to the same Building as From
		fifth.setTo(fifth.getFrom());
		assertNotEquals(fifth.getFrom(),  fifth.getTo());

		//test that From cannot be set to the same Building as from
		fifth.setFrom(fifth.getTo());
		assertNotEquals(fifth.getFrom(),  fifth.getTo());

		//test that to and from can both be put to null
		fifth.setTo(null);
		fifth.setFrom(null);
		assertNull(fifth.getTo());
		assertNull(fifth.getFrom());

	}

}