//Anika Peer -peera1
//03/29/2021

package src;
import java.util.*;

public class ProgramT extends HashSet<CourseT> implements Measures {// extends HashSet<CourseT>


	public double[] measures(){
		throw new UnsupportedOperationException ("Unsupported Operation, must have specific type.");
	}
	public double[] measures(IndicatorT ind){
		throw new UnsupportedOperationException ("Unsupported Operation, must have specific type.");
	}
	public double[] measures(AttributeT att){
		double[] temp = {0.0,0.0,0.0,0.0}; 
		for (CourseT c : this){
			temp = sumMeas(temp, c.measures(att));
		}
		return Services.normal(temp);
	}
	private double[] sumMeas(double[] a, double[] b){
		double[] newDoub = {a[0]+b[0], a[1]+b[1], a[2]+b[2], a[3]+b[3]};
		return newDoub;
	}
}