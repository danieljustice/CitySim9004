package CitySim9004;

public class Road{

	public enum RoadType{
		OneWay, TwoWay
	}
	private String name;
	private RoadType roadType = RoadType.OneWay;

	public String getName(){
		return name;
	}

	public void setName(String roadName){
		name = roadName;
	}

	public RoadType getRoadType(){
		return roadType;
	}
	public void setRoadType(RoadType roadType){
		this.roadType = roadType;
	}
}