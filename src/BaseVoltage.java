

public class BaseVoltage extends PowerSystemElement {

	float nominalVoltage;

	public BaseVoltage(String rdfID,  float nominalVoltage, String name) {
		super(rdfID, name);
		this.nominalVoltage = nominalVoltage;
	}

	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.nominalVoltage + "')";
	}


	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "\nnominalVoltage:" + this.nominalVoltage); 
	}

}
