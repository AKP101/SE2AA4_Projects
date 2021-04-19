//Anika Peer -peera1
//03/29/2021

package src;

public class Services{

	public static double[] normal(double[] v){
		double sumVal = sum(v);
		double[] returnArr = new double[v.length];
		for (int j = 0; j < v.length; j++){
			returnArr[j] = v[j]/sumVal;
		}
		return returnArr;
	}
	private static double sum(double[] arr){
		double sum = 0;
		for (int i = 0; i < arr.length; i++){
			sum += arr[i];
		}	
		return sum;	
	}
}