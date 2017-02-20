package CitySim9004;

import java.util.*;

public class Car{
	private String name;
	private int sennottCount = 0;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public int getSennottCount(){
		return sennottCount;
	}

	public void incrementSennottCount(int increment){
		sennottCount += increment;
		if(sennottCount < 0){
			sennottCount = 0;
		}
	}

	public String printSennottVisits(){
		String returnString =(name + " met with Professor Laboon " + sennottCount + " time(s).");
		if(sennottCount == 0){
			returnString = returnString + ("\nThat student missed out!");
		}else if(sennottCount >= 3){
			returnString = returnString +("\nWow, that driver needed lots of CS help!");
		}
		return returnString;
	}
}