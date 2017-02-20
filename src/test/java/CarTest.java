import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import CitySim9004.Building;
import CitySim9004.Road;
import CitySim9004.City;
import CitySim9004.Car;
public class CarTest{



	//Asserts that an instance of a Car can be created
	@Test 
	public void testCarConstructor(){
		Car driver1 = new Car();
		assertNotNull(driver1);
	}
	//A Car needs to be identified with a string name
	//The name that the car is set to should be the same name that is retrieved
	public void testCarHasName(){
		Car driver1 = new Car();
		driver1.setName("Driver1");
		assertEquals(driver1.getName(), "Driver1");
	}
	//MOCKITO
	//A Car needs to know which city it is in so it can go from building to building
	//This tests that a City can be assigned to a car and retrieved.
	//The City set should be the same City retrieved
	public void testCarHasCity(){
		Car driver1 = new Car();
		City mockCity = mock(City.class);

		driver1.setCity(mockCity);
		assertEquals(driver1.getCity(), mockCity);
	}


	
}