//Anika Peer -peera1
//03/29/2021

package src;

import java.util.*;

// https://avenue.cllmcmaster.ca/d2l/le/375601/discussions/threads/1561686/View?searchText=attribute+T
public class AttributeT{
	private String name;
	private Set<IndicatorT> s = new HashSet<IndicatorT>();

	public AttributeT(String attribName, IndicatorT[] indicators){
		// https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html
		this.name = attribName;
		Collections.addAll(this.s, indicators);
	}
	public String getName(){
		return this.name;
	}
	public IndicatorT[] getIndicators(){
		// https://www.javacodeexamples.com/get-elements-by-index-from-hashset-in-java-example/2772
		int index = 0;
		IndicatorT[] newIndicators = new IndicatorT[this.s.size()];
		for (IndicatorT i : this.s){
			newIndicators[index] = i;
			index = index+1;
		}
		return newIndicators;
	}

}