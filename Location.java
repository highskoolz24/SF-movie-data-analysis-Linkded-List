package project3;

/**
 *This class stores information about a location object 
 *stores location and fun fact
 * @author Ji Hwan Valentine Choi
 *
 */

public class Location {
	
	private String location;
	private String funFact;
	
	public Location(String location, String funFact) throws IllegalArgumentException{
		
		//check if the location is null
		if (location == null || location.equals("")) 
			throw new IllegalArgumentException();
		else
			this.location=location;
		
		//check if the fun fact is null
		if (funFact==null || funFact.equals(""))
			this.funFact=null;
		else
			this.funFact=funFact;
	}
	public String getLocation() {
		return location;
	}
	
	public String getFunFact() {
		if (funFact==null)
			return "";
		if (funFact.length()==0 || funFact.equals(""))
			return "";
		return " (" + funFact + ")";
	}
}
