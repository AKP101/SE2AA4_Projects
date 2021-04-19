//Anika Peer -peera1
//03/29/2021

package src;

public class LOsT implements Measures{

	private String name;
	private int n_blw;
	private int n_mrg;
	private int n_mts;
	private int n_exc;
	// https://rollbar.com/guides/java-throwing-exceptions/
	public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc){
		if ((nblw < 0)||(nmrg < 0)||(nmts < 0)||(nexc < 0)) {
			throw new IllegalArgumentException("Naturals must be non-negative.");
		}
		if ((nblw == 0) && (nmrg == 0) && (nmts == 0) && (nexc == 0)){
			throw new IllegalArgumentException("At least one integer must be greater than 0.");			
		}
		this.name = topic;
		this.n_blw = nblw;
		this.n_mrg = nmrg;
		this.n_mts = nmts;
		this.n_exc = nexc;
	}
	public String getName(){
		return this.name;
	}
	public boolean equals(LOsT o){
		return this.name == o.getName();
	}
	public double[] measures(){
		double[] returnVal = new double[] {this.n_blw, this.n_mrg, this.n_mts, this.n_exc};
		// https://beginnersbook.com/2018/09/java-convert-int-to-double/
		if (!Norm.getNLOs()){
			return returnVal; 
		}
		return Services.normal(returnVal);
	}
	public double[] measures(IndicatorT ind){
		throw new  UnsupportedOperationException ("Unsupported Operation, will not use type IndicatorT");
	} 
	public double[] measures(AttributeT att){
		throw new  UnsupportedOperationException ("Unsupported Operation, will not use type AttributeT");
	}
}
