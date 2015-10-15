package com.bloc.collections;

import java.util.*;

/*
 * FavoritePastries
 * 
 * This class maintains a record of Pastry objects and their
 * relation to a 1 to 5 rating scale.
 *
 * For example:
 * 5 Star Pastries: Cronut, Cherry Pie
 * 4 Star Pastries: Strudel, Apple Pie
 * 3 Star Pastries: Bear Claw
 * 2 Star Pastries: Pop-Tart
 * 1 Star Pastries: Pot Pie
 *
 * A pastry may not have duplicate entries
 */
public class FavoritePastries {

	/************************************************
 	 *	ASSIGNMENT:
	 *	Use a HashMap to store the relationship
	 *	between rating and pastry: HashMap<Integer, List<Pastry>>
	/************************************************/

	public Map<Integer, List<Pastry>> favoritePastries;

	public FavoritePastries() {
		/************************************************
 	 	 *	WORK HERE
		/************************************************/
		favoritePastries = new HashMap<>();
	}

	/* 
	 * addPastry
	 *
	 * Add a Pastry to the FavoritePastries class.
	 *
	 * This method stores this Pastry and its
	 * associated rating in some sort of data structure.
	 *
	 * If this Pastry already exists in FavoritePastries,
	 * its old rating should be updated.
	 *
	 * @param pastry The Pastry to store
	 * @param rating The rating to associate with it
	 * @return nothing
	 */
	public void addPastry(Pastry pastry, int rating) {
		/************************************************
 	 	 *	WORK HERE
		/************************************************/

		// remove pastry if it's in a list with a different rating
		for (Map.Entry<Integer, List<Pastry>> entry : favoritePastries.entrySet()){
			if (entry.getValue().contains(pastry) && (!entry.getKey().equals(rating))){
				entry.getValue().remove(pastry);
			}
		}

		if (favoritePastries.containsKey(rating)){

			List<Pastry> pastryList = favoritePastries.get(rating);
			if (!pastryList.contains(pastry)){
				pastryList.add(pastry);
				favoritePastries.put(rating, pastryList);
			}

		} else {

			List<Pastry> newPastryList = new ArrayList();
			newPastryList.add(pastry);
			favoritePastries.put(rating, newPastryList);
		}
	}

	/* 
	 * removePastry
	 *
	 * Remove a Pastry from FavoritePastries
	 *
	 * This method removes any reference to this exact
	 * Pastry object and its associated rating
	 *
	 * @param pastry The Pastry to remove
	 * @return true if the Pastry was found and removed,
	 *		   false otherwise
	 */
	public boolean removePastry(Pastry pastry) {
		/************************************************
 	 	 *	WORK HERE, you must modify the return value
		/************************************************/
		
		Iterator it = favoritePastries.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			List<Pastry> pastryList = (List<Pastry>)pair.getValue();
			if (pastryList.contains(pastry)){
				pastryList.remove(pastry);
				if (pastryList.isEmpty()){
					favoritePastries.remove(pastryList);
				}
				return true;
			}
		}
		return false;
	}

	/* 
	 * getRatingForPastry
	 *
	 * Return the associated rating for a given Pastry
	 *
	 * This method will find the associated rating for
	 * this Pastry inside of FavoritePastries and return
	 * it to its caller.
	 *
	 * @param  pastry The Pastry for which a rating must
	 * 		   be recovered
	 * @return the rating associated with this Pastry or
	 *		   -1 if not found among FavoritePastries
	 */
	public int getRatingForPastry(Pastry pastry) {
		/************************************************
 	 	 *	WORK HERE, you must modify the return value
		/************************************************/
		
		for (Map.Entry<Integer, List<Pastry>> entry : favoritePastries.entrySet()){
			if (entry.getValue().contains(pastry)){
				return entry.getKey();
			}
		}

		return -1;
	}

	/* 
	 * getPastriesForRating
	 *
	 * Return a Set of all the Pastries with a given
	 * rating.
	 *
	 * This method returns a Set<Pastry> object containing
	 * references to all of the Pastries associated with
	 * a particular rating.
	 *
	 * @param  rating The rating of the Pastry objects the
	 *		   caller wishes to recover
	 * @return A Set of all the Pastry objects with a rating
	 * 		   of `rating`. Returns an empty set if none are
	 *         found
	 */
	public Collection<Pastry> getPastriesForRating(int rating) {
		/************************************************
 	 	 *	WORK HERE, you must modify the return value
		/************************************************/
		for (Integer key : favoritePastries.keySet()) {
			if (key.equals(rating)){
				return favoritePastries.get(key);
			}
		}

		return Collections.emptySet();
	}

}