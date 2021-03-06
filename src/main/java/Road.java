package CitySim9004;

public class Road{

	private String name;
	private Building from = null;
	private Building to = null;

	public String getName(){
		return name;
	}

	public void setName(String roadName){
		name = roadName;
	}

	public void setFrom(Building building){
		if(building == null){
			from = null;
		}else{
			if(!building.equals(to)){
				from = building;
			}else{
				System.out.println("To: " + to.getName() + " Building: " + building.getName());
				System.out.println("A road cannot go to and from the same building.");
			}
		}
	}

	public Building getFrom(){
		return from;
	}

	public void setTo(Building building){
		if(building == null){
			to = null;
		}else{
			if(!building.equals(from)){
				to = building;
			}else{
				System.out.println("Road: " + name + " From: " + from.getName() + " Building: " + building.getName());
				System.err.println("A road cannot go to and from the same building.");
			}
		}
	}

	public Building getTo(){
		return to;
	}

	public String[] toStrings(){
		String[] result;
		if(to.getIsInCity() == true){
			result = new String[1];
			result[0] = ("heading from " + from.getName() + " to " + to.getName() + " via " + name + ".");
		}else{
			result = new String[2];
			result[0] = ("heading from " + from.getName() + " to Outside City via " + name + ".");
			result[1] = ("has gone to " + to.getName() + "!");
		}
		return result;
	}
}
