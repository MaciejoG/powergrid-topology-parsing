


public class RegulatingControl extends PowerSystemElement{
	float targetValue;

	RegulatingControl(String rdfID, String name, float targetValue) {
		super(rdfID, name);
		this.targetValue = targetValue; //SSH file under TapChangerControl

	}

	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', " + this.targetValue + ")";
	}		


	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "/ntargetValue" + this.targetValue + "\n");

	} 

}
