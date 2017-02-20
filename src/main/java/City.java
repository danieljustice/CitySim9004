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
		result = buildings.get(seed%buildings.size());
		int i = 1;
		while(!result.getIsInCity()){
			//if we loop through and dont find a good building, 
			//then there are no good buildings so return null
			if(i > buildings.size()){
				return null;
			}	
			result = buildings.get((seed + i)%buildings.size());
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


}