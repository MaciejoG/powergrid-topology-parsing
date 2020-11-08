


public class RatioTapChanger extends PowerSystemElement{
	float step;

	RatioTapChanger(String rdfID, String name, float step) {
		super(rdfID, name);
		this.step = step; //stepVoltageIncrement
	}




	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', " + this.step + ")";
	}	



	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "/nstep" + this.step + "\n");

	}	
}
