package CitySim9004;

import java.util.*;

public class City{

	private List<Building> buildings = new ArrayList<Building>();


	public int numOfBuildings(){
		return buildings.size();	
	}

	public void addBuilding(Building building){
		buildings.add(building);
	}

	public Building chooseStartingBuilding(int seed){
		Building result = null;
		//return null if there are no buildings
		if(buildings.size() == 0){
			return null;
		}
		//logic to 	x
		result = buildings.get(Math.abs(seed)%buildings.size());
		int i = 1;
		while(!result.getIsInCity()){
			//if we loop through and dont find a good building, 
			//then there are no good buildings so return null
			if(i > buildings.size()){
				return null;
			}	
			result = buildings.get((Math.abs(seed) + i)%buildings.size());
			i++;
		}

		return result;
	}

	public Building chooseNextBuilding(Building currentBuilding, int seed){
		Building nextBuilding = null;
		if(currentBuilding != null && currentBuilding.numOfRoads()>0){
			nextBuilding = currentBuilding.chooseRoad(seed).getTo();
		}
		return nextBuilding;
	}

	public void driveCar(Car car, int seed){
		Random rand = new Random();
		rand.setSeed(seed);
		Building currentBuilding = chooseStartingBuilding(rand.nextInt());
		
		int seedInt = rand.nextInt();
		String[] output = new String[1];

		while(output.length != 2){
			if(currentBuilding.getName().equals("Sennott")){
				car.incrementSennottCount(1);
			}
			output = currentBuilding.chooseRoad(seedInt).toStrings();
			currentBuilding = chooseNextBuilding(currentBuilding, seedInt);

			for(int i = 0; i < output.length; i++){
				System.out.println(car.getName() + " " + output[i]);
			}
			seedInt = rand.nextInt();
		}
		System.out.println(car.printSennottVisits());
		System.out.println("-----");
	}
}	