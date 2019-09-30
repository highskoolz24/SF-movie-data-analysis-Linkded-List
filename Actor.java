package project3;

/**
 * This class stores information about a actor object
 * Stores the name of the actor
 * @author Ji Hwan Valentine Choi
 *
 */

public class Actor {
	
	private String name;
	
	public Actor(String name) throws IllegalArgumentException {
		//check if the parameter is null
		if (name==null || name.equals(""))
			throw new IllegalArgumentException();
		else
			this.name=name;
	}
	

	public String getName() {
		return name;
	}


	public String toString () {
		return name;
		
	}
}
