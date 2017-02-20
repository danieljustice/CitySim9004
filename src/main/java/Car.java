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
}