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

}