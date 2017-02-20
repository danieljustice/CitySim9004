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
	@Test
	public void testCarHasName(){
		Car driver1 = new Car();
		driver1.setName("Driver1");
		assertEquals(driver1.getName(), "Driver1");
	}
	//A count of how many times a car visits sennott should be kept.
	//This count should be able to be incremented and decremented, but should never be less than 0
	@Test
	public void testSennottCount(){
		Car driver1 = new Car();
		//sennottCount should start at 0
		assertEquals(driver1.getSennottCount(), 0);	
		//after incrementing it by 1 it should be equal to 1
		driver1.incrementSennottCount(1);
		assertEquals(driver1.getSennottCount(), 1);	
		//after incrementing by 2 it should be equal to 3
		driver1.incrementSennottCount(2);
		assertEquals(driver1.getSennottCount(), 3);
		//after decrementing by 3 it should be equal to 0
		driver1.incrementSennottCount(-3);
		assertEquals(driver1.getSennottCount(), 0);
		//after decrementing by 3 it should be 0, cannot visit Sennott less than 0 times
		driver1.incrementSennottCount(-3);
		assertEquals(driver1.getSennottCount(), 0);
	}
	//There are three different options for what this can print out
	//Cases are at 0, between 1 and 2, and 3 and above
	//Tests three cases, number of visits are 0, 1 and 3
	@Test
	public void testPrintSennottVisits(){
		Car testCar = new Car();
		testCar.setName("Bob");
		String zeroVisits = "Bob met with Professor Laboon 0 time(s).\nThat student missed out!";
		String oneVisits = "Bob met with Professor Laboon 1 time(s).";
		String threeVisits = "Bob met with Professor Laboon 3 time(s).\nWow, that driver needed lots of CS help!";
		assertEquals(testCar.printSennottVisits(), zeroVisits);
		testCar.incrementSennottCount(1);
		assertEquals(testCar.printSennottVisits(), oneVisits);
		testCar.incrementSennottCount(2);
		assertEquals(testCar.printSennottVisits(), threeVisits);

	}
}