import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * To support an individual cat
 * @author Chris Loftus and Faisal Rezwan
 * @version 3 (20th February 2023)
 */
public class Animal {

	private ArrayList<Owner> originalOwners;
	private String name;
	private String favFood;
	private int foodPerDay;

	/**
	 * Default constructor
	 */

	public Animal (){
		this("unknown", "unknown", 1);
	}
	public Animal(String name, String food, int mealsPerDay) {
		this.name = name;
		originalOwners = new ArrayList<Owner>();
		this.favFood = food;
		this.foodPerDay = mealsPerDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setFeedsPerDay(int feeds){
		foodPerDay = feeds;
	}

	public int getFeedsPerDay(){
		return foodPerDay;
	}
	
	/**
	 * Returns a copy of the original owners
	 * @return A copy of the original owners as an array
	 */
	public Owner[] getOriginalOwners(){
		Owner[] result = new Owner[originalOwners.size()];
		result = originalOwners.toArray(result);
		return result;
	}

	/**
	 * To add an original owner
	 * @param o An original owner
	 */
	public void addOriginalOwner(Owner o){
		originalOwners.add(o);
	}

	
	/**
	 * What's his favourite food?
	 * @param food The food it likes
	 */
	public void setFavouriteFood(String food){
		favFood = food;
	}
	
	/**
	 * The food the cat likes to eat
	 * @return The food 
	 */
	public String getFavouriteFood(){
		return favFood;
	}

	/**
	 * Reads in information about the cat from the file
	 */
	void load(Scanner infile){
		if (infile == null) return;
		name = infile.next();
		int numOwners = Integer.parseInt(infile.nextLine());
		originalOwners = new ArrayList<>();
		for (int oCount = 0; oCount < numOwners; oCount++) {
			String name = infile.next();
			String phone = infile.next();
			Owner owner = new Owner(name, phone);
			originalOwners.add(owner);
		}
		foodPerDay = infile.nextInt();
		favFood = infile.next();
	}


	void save(PrintWriter pw){
		if (pw == null) return;
		pw.println(name);
		pw.println(originalOwners.size());
		for (Owner o : originalOwners) {
			pw.println(o.getName());
			pw.println(o.getPhone());
		}
		pw.println(foodPerDay);
		pw.println(favFood);
	}



	/**
	 * A basic implementation to just return all the data in string form
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("\nOriginal Owner: ").append(originalOwners);
		sb.append("\nFavourite food: ").append(favFood);
		sb.append("\nFood per day: ").append(foodPerDay);
		return sb.toString();
	}

}


