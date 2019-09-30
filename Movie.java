package project3;

import java.util.ArrayList;

/**
 * This class stores information about a movie object
 * Stores title, release year, location, director, writer, and actors
 * @author jhc59
 *
 */

public class Movie implements Comparable<Movie>{
	
	private String title;
	private int year;
	private Location location;
	private ArrayList<Location> locationList = null;
	private String director;
	private String writer;
	private Actor actor1;
	private Actor actor2;
	private Actor actor3;
	
	public Movie (String title, int year) throws IllegalArgumentException{
		
		//check if the title is null
		if (title != null && !title.equals(""))
			this.title = title;
		else
			throw new IllegalArgumentException();
		
		//check if the release year is within the range
		if (year>=1900 && year<=2020)
			this.year = year;
		else
			throw new IllegalArgumentException();
	}
	
	public Movie (String title, int year, String director, String writer, 
			Actor actor1, Actor actor2, Actor actor3) throws IllegalArgumentException {
		
		//check if the title is null
		if (title == null || title.equals(""))
			throw new IllegalArgumentException();
		else
			this.title = title;
		
		//check if the release year is within the range
		if (year>=1900 && year<=2020) 
			this.year = year;
		else
			throw new IllegalArgumentException();
		
		//check if the name of the director is null, must not be null
		if (director == null || director.equals(""))
			this.director = "";
		else
			this.director = director;
		
		//check if the name of the writer is null, must not be null
		if (writer == null || writer.equals(""))
			this.writer = "";
		else
			this.writer = writer;
		
		//check if the name of the actor1, 2, 3 is null, actor1 must not be null
		if (actor1 == null)
			throw new IllegalArgumentException();
		else
			this.actor1 = actor1;
		
		if (actor2 == null)
			this.actor2 = null;
		else
			this.actor2 = actor2;
		if(actor3 == null) 	
			this.actor3 = null;
		else
			this.actor3 = actor3;
	}
	
	/**
	 * Adds location to the location list 
	 * @param loc that needs to be stored
	 * @throws IllegalArgumentException when location is null
	 */
	public void addLocation (Location loc) throws IllegalArgumentException {
		
		if (loc != null) {
			if(locationList==null) {
				locationList = new ArrayList<Location>();
			}
			locationList.add(loc);
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}
	
	
	/**
	 * Overrides equals method
	 * Check that movies are identical if they have the same title and release year
	 * 
	 * @param anObject is the movie that is being compared with other movie
	 * @return true if the movies are identical
	 * @return false if the movies are not identical
	 * 
	 */
	@Override
	public boolean equals (Object anObject) {
		if (this == anObject)
            return true;
		if (anObject==null)
			return false;
		if (!(anObject instanceof Movie)) 
			return false;
		Movie o = (Movie)anObject;
		if (!this.title.equalsIgnoreCase(o.title))
			return false;
		if(this.year != o.year)
			return false;
		return true;
	}
	
	/**
	 * Overrides compareTo method
	 * Check that movies are identical if they have the same title and release year
	 * 
	 * @param o is the movie that is being compared with other movie
	 * @return 0 if the movies are identical
	 * @return -1 if the movies are not identical
	 * 
	 */
	@Override
	public int compareTo(Movie o) {
		if (this.title.toLowerCase().compareTo(o.title.toLowerCase())!=0)
			return -1;
		else if (this.year - o.year!=0)
			return -1;
		else
			return 0;
	}
	
	public ArrayList<Location> getLocationList() {
		return locationList;
	}
	
	public Location getLocation() {
		return location;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getDirector() {
		return director;
	}

	public String getWriter() {
		return writer;
	}

	public Actor getActor1() {
		return actor1;
	}

	public Actor getActor2() {
		return actor2;
	}

	public Actor getActor3() {
		return actor3;
	}

	/**
	 * Overrides the toString() method
	 * 
	 * @return the variables that a movie object should be storing in a formatted version
	 */
	@Override
	public String toString() {
		String movieDetail = "";
		movieDetail =title +" ("+year+")\n"+ "----------------------------------\n"+"director        : "+ director+"\n"+
				"writer          : "+ writer+"\n"+"starring        : "+actor1;
		
		//check if there exists the names of the actor2 and 3, if do return
		if (actor2 !=null)
			movieDetail+=", "+actor2;
		if (actor3 !=null)
			movieDetail+=", "+actor3;
		movieDetail+="\n";
		if (locationList!=null) {
			movieDetail+="filmed on location at:\n";
			for(int i=0;i<locationList.size();i++) {
				movieDetail+="\t"+locationList.get(i).getLocation();
				if(locationList.get(i).getFunFact()!=null) 
					movieDetail+=locationList.get(i).getFunFact()+"\n";
				else
					movieDetail+="\n";
			}
		}
		return movieDetail; 
	}

}
