/** 
* @file CourseT.java
* @author Anika Peer
* @brief contains a class for working with objects of type CourseT
* a template module which inherits Measures.
* @date 03/28/2021
*/

package src;
import java.util.*;

/** 
* @brief A class for objects of type CourseT.
* @details CourseT is made up of a name, Indicators and the associated
* LOs.
*/

public class CourseT implements Measures{
	// I made use of the below link in order to figure out using Hashmaps.
	// https://www.w3schools.com/java/java_hashmap.asp
	private String name;
	private HashMap<IndicatorT, Set<LOsT>> m = new HashMap<IndicatorT, Set<LOsT>>();
	
	/**
	* @brief Constructor method for CourseT
	* @details CourseT is made up of a name, indicators and the associated
	* LOs. We are directly given the values for course name. However, in
	* order to work with the sequence of indicators and their respective
	* learning objectives, we iterate through the indicators and we
	* proceed to add them to the hashmap while concurrently creating
	* empty sets for LOsT values that will be populated later on.
	* @param courseName is a String representing the name of the
	* CourseT object.
	* @param indicators is a seqeunce of indicators representing the
	* indicators associated with a CourseT object. 
	*/
	public CourseT(String courseName, IndicatorT[] indicators){
		HashMap<IndicatorT, Set<LOsT>> newVal = new HashMap<IndicatorT, Set<LOsT>>();
		// https://www.callicoder.com/java-hashset/#:~:text=HashSet%20is%20an%20unordered%20collection,final%20outcome%20is%20not%2Ddeterministic.
		for (IndicatorT i : indicators){
			newVal.put(i, new HashSet<LOsT>());

		}
		this.name = courseName;
		this.m = newVal;
	}
	/**
	* @brief Getter method for CourseT, to get name.
	* @details When we want to return the name of the CourseT object
	* we simple return this.name.
	* @return A string representing the name of the CourseT object.
	*/
	public String getName(){
		return this.name;
	}

	/**
	* @brief Getter method for CourseT, to get indicators in Hashmap.
	* @details We know that is it currently stands, the indicators in this.m
	* are placed in a hashmap. They are keys, so in order to return them, we
	* will iterate through all the indicators and add them to an array so 
	* that they can be returned as a sequence.
	* @return An array representing a sequence of values of type IndicatorT.	
	*/
	public IndicatorT[] getIndicators(){
		//https://stackoverflow.com/questions/10462819/get-keys-from-hashmap-in-java
		//https://examples.javacodegeeks.com/core-java/util/hashmap/get-size-of-hashmap-example/
		IndicatorT[] getInd = new IndicatorT[this.m.size()];
		int j = 0;
		for (IndicatorT i : this.m.keySet()){
			getInd[j] = i;
			j++;
		}
		return getInd;
	}

	/**
	* @brief Getter method for CourseT to get LOs associated with a value 
	* of type IndicatorT. 
	* @details We know that is it currently stands, the indicators in this.m
	* are placed in a hashmap. They are keys, and LOs are the associated 
	* values at those keys. This means that using get will allow us to get
	* the set of LOsT values that are present at the specific IndicatorT. 
	* However, we also make sure to keep in mind to return a value that is 
	* a sequence rather than a set, hence the set_to_seq. 
	* @param indicator is a value of type IndicatorT for which we will 
	* find the respective set of LOs.
	* @return An array representing a sequence of values of type LOsT that
	* have been associated with the specified IndicatorT values. 
	*/
	public LOsT[] getLOs(IndicatorT indicator){
		//https://www.tutorialspoint.com/java/util/hashmap_get.htm
		if (this.m.containsKey(indicator)){
			return set_to_seq((this.m.get(indicator)));			
		}
		return new LOsT[0];
	}

	/**
	* @brief Adds learning outcomes to an indicator in CourseT.
	* @details First we will check for whether or not the indicator even 
	* exists for the object of type CourseT. From here it is prudent to
	* check that the LO does not already exist for this indicator. If it
	* does not we will add it to the set of LOs associated with this 
	* indicator
	* @param indicator is a value of type IndicatorT for which we will 
	* add an outcomes to its respective set of LOs.
	* @param outcome is a value of type LOsT that will potentially be 
	* added to the set of LOs
	*/
	public void addLO(IndicatorT indicator, LOsT outcome){
	//https://stackoverflow.com/questions/4157972/
	//https://www.geeksforgeeks.org/hashmap-containskey-method-in-java/#:~:text=HashMap.,is%20mapped%20in%20the%20map.
	//https://stackoverflow.com/questions/5110376/hashset-contains-problem-with-custom-objects
		if (this.m.containsKey(indicator)){
			Set<LOsT> temp = new HashSet<LOsT>();
			temp = this.m.get(indicator);
			for (LOsT i : temp){
				if (i.equals(outcome)){
					return;	
				}
			}
			temp.add(outcome);
			this.m.put(indicator,temp);
		}
	}


	/**
	* @brief Deletes a learning outcome from an indicator in CourseT.
	* @details First we will check for whether or not the indicator even
	* exists for the object of type CourseT. From here it is prudent to
	* check that the LO already exists for this indicator. If it does not
	* we will do nothing to the set of LOs associated with this indicator.
	* @param indicator is a value of type IndicatorT for which we will 
	* remove an outcomes from its respective set of LOs.
	* @param outcome is a value of type LOsT that will potentially be 
	* removed from the set of LOs
	*/
	public void delLO(IndicatorT indicator, LOsT outcome){
	//https://stackoverflow.com/questions/5110376/hashset-contains-problem-with-custom-objects
		if (this.m.containsKey(indicator)){
			Set<LOsT> temp = new HashSet<LOsT>();
			temp = this.m.get(indicator);
			for (LOsT i : temp){
				if (i.equals(outcome)){
					temp.remove(outcome);
					this.m.put(indicator,temp);	
					return;
				}
			}
		}
	}


	/**
	* @brief Makes sure that outcomes exist for an indcatorT value
	* @details Makes use of Arrays as list instead of iterating through the
	* sequence in order to check if outcomes exist for the indicator.
	* we will do nothing to the set of LOs associated with this indicator.
	* @param indicator is a value of type IndicatorT for which we will 
	* be checking if outcomes belongs to it.
	* @param outcome is a value of type LOsT[] (sequence of LOsT)
	* @return Boolean value representing whether or not outcomes exist 
	* for an indcatorT value
	*/
	public boolean member(IndicatorT indicator, LOsT[] outcomes){
	//https://stackoverflow.com/questions/5110376/hashset-contains-problem-with-custom-objects
	//https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
	//Farzan Yazdanjou provided assistance with this method in terms of linking resources. 
		Set<LOsT> temp = new HashSet<>(Arrays.asList(outcomes));
		Set<LOsT> temp2 = this.m.get(indicator);
        if (temp2.equals(temp)){
            return true;
        }
        return false;
	}

	/**
	* @brief Raises an exception. 
	* @details Raises an exception because measures in CourseT requires a value
	* of either IndicatorT or AttributeT.
	* of type IndicatorT or AttributeT to work. 
	*/
	public double[] measures(){
		throw new UnsupportedOperationException ("Unsupported Operation, must have IndicatorT or AttributeT");
	}

	/**
	* @brief Will return value based on the value of IndicatorT, it implements
	* aspects of the measures interface.
	* @details we have an empty return if our getLOs is empty
	* for getLOs, and will return the normal of the calculated with
	* several other values otherwise. 
	* @param ind is a value of type IndicatorT which is required for measures.
	* @return double value that is all 0's if we have an empty return
	* for getLOs, and will return the normal of the calculated values.
	*/
	public double[] measures(IndicatorT ind){
		double[] measureInd = new double[]{0.0,0.0,0.0,0.0};
		if (this.getLOs(ind).length == 0){ 
			return new double[] {0.0,0.0,0.0,0.0};
		}

		for (LOsT o : this.getLOs(ind)){
			measureInd = sumMeas(measureInd,o.measures());
		}
		if(Norm.getNInd()){
			return Services.normal(measureInd);
		}
		return measureInd;

	} 

	/**
	* @brief Will return a value based on the value of AttributeT, implements
	* aspects of the measures interface.
	* @details we have an empty return if our getLOs is empty
	* for getLOs, and will return the normal of the calculated with 
	* several other values otherwise. 
	* @param att is a value of type AttributeT which is required for measures. 
	* @return double value that is all 0's if we have an empty return
	* for getLOs, and will return the normal of the calculated values.
	*/
	public double[] measures(AttributeT att){
		double[] measureInd = new double[]{0,0,0,0};
		if (att.getIndicators().length == 0){
			return new double[] {0,0,0,0};
		}

		for (IndicatorT i : att.getIndicators()){
			measureInd = sumMeas(measureInd,this.measures(i));
		}
		if(Norm.getNAtt()){
			return Services.normal(measureInd);
		}
		return measureInd;	
	}

	/**
	* @brief Takes in a set of LOsT and returns a sequence of LOsT
	* @details iterates through values in a set and returns them as a sequence
	* @param s is a set of LOsT
	* @return a sequence of LOsT
	*/
	private LOsT[] set_to_seq(Set<LOsT> s){
		LOsT[] seq = new LOsT[s.size()];
		int i = 0;
		for (LOsT x : s){
			seq[i] = x;
			i ++;
		}
		return seq;
	}

	/**
	* @brief Calculates and returns the sum of two arrays of doubles.
	* @details a is a sequence of double values 
	* @param a is a sequence of four doubles
	* @param b is a sequence of four doubles
	* @return a sequence of doubles that contains the sum of the sequences of
	* doubles at the respective indices. 
	*/
	private double[] sumMeas(double[] a, double[] b){
		double[] newDoub = {a[0]+b[0], a[1]+b[1], a[2]+b[2], a[3]+b[3]};
		return newDoub;
	}

}

