package CitySim9004;

import java.util.*;

public class CitySim9004{

	public static void main(String[] args) {


		checkArgs(args);
		Random rand = new Random();
		rand.setSeed(Integer.parseInt(args[0]));
		int seed = rand.nextInt();
		City pittsburgh = buildPittsburgh();

		Car car1 = new Car();
		car1.setName("Driver 1");
		Car car2 = new Car();
		car2.setName("Driver 2");
		Car car3 = new Car();
		car3.setName("Driver 3");
		Car car4 = new Car();
		car4.setName("Driver 4");
		Car car5 = new Car();
		car5.setName("Driver 5");

		pittsburgh.driveCar(car1, seed);
		seed = rand.nextInt();
		pittsburgh.driveCar(car2, seed);
		seed = rand.nextInt();
		pittsburgh.driveCar(car3, seed);
		seed = rand.nextInt();
		pittsburgh.driveCar(car4, seed);
		seed = rand.nextInt();
		pittsburgh.driveCar(car5, seed);
	}


	public static boolean checkArgs(String[] args){
		if(checkArgsLength(args) && checkArgsType(args)){
			return true;
		}
		System.out.println("Invalid arguments.  Please have 1 and only 1 argument that is an Integer.");
		System.exit(0);
		return false;

	}

	public static boolean checkArgsLength(String[] args){
		if(args.length == 1){
			return true;
		}else{
			System.out.println("Invalid Length.");
			return false;
		}
	}
	public static boolean checkArgsType(String[] args){
		try{
			Integer.parseInt(args[0]);
		}catch(Exception e){
			System.out.println("Not an Integer.");
			return false;
		}
		return true;
	}
	public static City buildPittsburgh(){
		//Build all the Buildings
		Building presby = new Building();
		presby.setName("Presby");
		Building union = new Building();
		union.setName("Union");
		Building hillman = new Building();
		hillman.setName("Hillman");
		Building sennott = new Building();
		sennott.setName("Sennott");
		Building philadelphia = new Building();
		philadelphia.setName("Philadelphia");
		philadelphia.setIsInCity(false);
		Building cleveland = new Building();
		cleveland.setName("Cleveland");
		cleveland.setIsInCity(false);

		//build all the roads 
		Road fourth1 = new Road();
		fourth1.setName("Fourth Ave");
		fourth1.setFrom(presby);
		fourth1.setTo(union);
		Road fourth2 = new Road();
		fourth2.setName("Fourth Ave");
		fourth2.setFrom(union);
		fourth2.setTo(philadelphia);
		Road fifth1 = new Road();
		fifth1.setName("Fifth Ave");
		fifth1.setFrom(hillman);
		fifth1.setTo(sennott);
		Road fifth2 = new Road();
		fifth2.setName("Fifth Ave");
		fifth2.setFrom(sennott);
		fifth2.setTo(cleveland);
		Road phil1 = new Road();
		phil1.setName("Phill St");
		phil1.setFrom(hillman);
		phil1.setTo(union);
		Road phil2 = new Road();
		phil2.setName("Phill St");
		phil2.setFrom(union);
		phil2.setTo(hillman);
		Road bill1 = new Road();
		bill1.setName("Bill St");
		bill1.setFrom(sennott);
		bill1.setTo(presby);
		Road bill2 = new Road();
		bill2.setName("Bill St");
		bill2.setFrom(presby);
		bill2.setTo(sennott);


		//add the roads the the proper buildings
		presby.addRoad(fourth1);
		presby.addRoad(bill2);
		union.addRoad(fourth2);
		union.addRoad(phil2);
		hillman.addRoad(phil1);
		hillman.addRoad(fifth1);
		sennott.addRoad(fifth2);
		sennott.addRoad(bill1);

		//create pittsburgh city and add cities to it
		City pittsburgh = new City();
		pittsburgh.addBuilding(presby);
		pittsburgh.addBuilding(union);
		pittsburgh.addBuilding(philadelphia);
		pittsburgh.addBuilding(hillman);
		pittsburgh.addBuilding(sennott);
		pittsburgh.addBuilding(cleveland);

		return pittsburgh;
	}
	
}
