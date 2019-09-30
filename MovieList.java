package project3;

import java.util.Collections;
import java.util.Iterator;

/**
 * This class provides methods that finds the matching data and also provides a list to store the data 
 * searched by title and by actors
 * @author Ji Hwan Valentine Choi
 *
 */
public class MovieList extends LinkedList<Movie>{
	
	public MovieList() {
		super();
	}

	/**
	 * Search if there is matching movie data by title
	 * @param keyword that the user entered to compare
	 * @return a sorted list of movies that are matching
	 */
	public MovieList getMatchingTitles (String keyword) {
		
		MovieList movieList= new MovieList();
		
		//check if the user input is null or an empty string
		if (keyword == null|| keyword.equals(""))
			return null;
		
		Iterator<Movie> iter= this.iterator();
		
		while(iter.hasNext()) {
			Movie movieTmp = iter.next();
			
			String titleTmp = movieTmp.getTitle().toLowerCase();
			
			if(titleTmp.contains(keyword.toLowerCase()))
				movieList.add(movieTmp);
		}
		
		//find the matching data through the whole movie list
//		for (int i=0; i<this.size();i++) {
//			Movie movieTmp = this.get(i);
//			
//			String titleTmp = movieTmp.getTitle().toLowerCase();
//			
//			//if there is a matching data, store it in the list to return
//			if(titleTmp.contains(keyword.toLowerCase()))
//				movieList.add(movieTmp);
//		}
//		
//		Collections.sort(movieList);
		
		return movieList;
	}
	
	/**
	 * Search if there is matching movie data by title
	 * @param keyword that the user entered to compare
	 * @return a sorted list of movies that are matching
	 */
	public MovieList getMatchingActor (String keyword) {
		MovieList movieList = new MovieList();
		
		//check if the user input is null or an empty string
		if (keyword == null|| keyword.equals(""))
			return null;

		Iterator<Movie> iter= this.iterator();
		
		while(iter.hasNext()) {
			Movie movieTmp = iter.next();
			String actor1Tmp = movieTmp.getActor1().getName().toLowerCase();
			
			if(actor1Tmp.contains(keyword.toLowerCase()))
				movieList.add(movieTmp);
			
			else if (movieTmp.getActor2() != null && movieTmp.getActor2().getName().toLowerCase().contains(keyword.toLowerCase()))
				movieList.add(movieTmp);
			else if (movieTmp.getActor3() != null && movieTmp.getActor3().getName().toLowerCase().contains(keyword.toLowerCase()))
				movieList.add(movieTmp);
		}
		
		//if there is a matching data, store it in the list to return
//		for (int i = 0; i < this.size(); i++) {
//			
//			Movie movieTmp = this.get(i);
//			String actor1Tmp = movieTmp.
//			
//			if (actor1Tmp.contains(keyword.toLowerCase()))
//				movieList.add(movieTmp);
//
//			else if (movieTmp.getActor2() != null && movieTmp.getActor2().getName().toLowerCase().contains(keyword.toLowerCase()))
//				movieList.add(movieTmp);
//			
//			else if (movieTmp.getActor3() != null && movieTmp.getActor3().getName().toLowerCase().contains(keyword.toLowerCase()))
//					movieList.add(movieTmp);
//		}
//		
//		Collections.sort(movieList);
		
		return movieList;
	}
	
	/**
	 * toString method that stacks the matching movies' title and return
	 * @return list of titles that are stored in the matching movielist
	 */
	public String toString() {
		String movieNames="";
		
		for (int i = 0; i<this.size();i++) {
			if (i==this.size()-1) {
				movieNames+=this.get(i);
			}
			else
				movieNames+=this.get(i)+"; ";
		}
		return movieNames;
	}
	
}
