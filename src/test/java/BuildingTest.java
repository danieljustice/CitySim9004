import org.junit.Test;
import static org.junit.Assert.*;

import CitySim9004.Building;

public class BuildingTest{

	@Test 
	public void testBuildingContructor(){
		Building sennott = new Building();
		assertNotNull(sennott);
	}
	@Test
	public void testBuildingHasName(){
		Building sennott = new Building();
		sennott.setName("Sennott");
		assertEquals(sennott.getName(), "Sennott");
	}


}