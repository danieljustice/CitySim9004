package CitySim9004;

import java.util.*;


public class Building{

	private String name;

	private List<Road> roads = new ArrayList<Road>();

	public String getName(){
		return name;
	}

	public void setName(String buildingName){
		name = buildingName;
	}

	public int numOfRoads(){
		return roads.size();
	}

	public void addRoad(Road road){
		roads.add(road);
	}

	public Road chooseRoad(int seedNum){
		if(roads.size() == 0){
			return null;
		}else{
			int index = Math.abs(seedNum)%roads.size();
			return roads.get(index);
		}
	}
}