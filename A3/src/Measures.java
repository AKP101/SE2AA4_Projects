//Anika Peer -peera1
//03/29/2021

package src;

public interface Measures{
	// https://www.w3schools.com/java/java_interface.asp
	// https://avenue.cllmcmaster.ca/d2l/le/375601/discussions/threads/1559121/View?searchText=exceptions
	// https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html
	// https://beginnersbook.com/2014/01/abstract-method-with-examples-in-java/
	// https://www.tutorialspoint.com/can-we-define-multiple-methods-in-a-class-with-the-same-name-in-java
	public double[] measures() throws UnsupportedOperationException;

	public double[] measures(IndicatorT ind) throws UnsupportedOperationException;

	public double[] measures(AttributeT att) throws UnsupportedOperationException;

}











