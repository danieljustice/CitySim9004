import org.junit.Test;
import static org.junit.Assert.*;

import CitySim9004.Road;

public class RoadTest{

	@Test 
	public void testRoadContructor(){
		Road fifth = new Road();
		assertNotNull(fifth);
	}
	@Test
	public void testBuildingHasName(){
		Road fifth = new Road();
		fifth.setName("Fifth");
		assertEquals(fifth.getName(), "Fifth");
	}
	@Test
	public void testIsOneWayRoad(){
		Road fifth = new Road();
		assertEquals(fifth.getRoadType(), Road.RoadType.OneWay);

		fifth.setRoadType(Road.RoadType.TwoWay);
		assertEquals(fifth.getRoadType(), Road.RoadType.TwoWay);
	
		fifth.setRoadType(Road.RoadType.OneWay);
		assertEquals(fifth.getRoadType(), Road.RoadType.OneWay);
	}

}