

public class VoltageLevel extends PowerSystemElement{

	String substation;
	String baseVoltageID;
	float baseVoltage;

	//Constructor of VoltageLevel
	public VoltageLevel(String rdfID, String name, String substation, String baseVoltageID, float baseVoltage){
		super(rdfID,name);
		this.substation = substation;
		this.baseVoltageID = baseVoltageID;
		this.baseVoltage = baseVoltage;
	}
	

	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "','" + this.name + "', '" + this.substation + "', '" + this.baseVoltageID + "')";
	}	
	

	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "\nsubstation:" + this.substation + "\nbaseVoltageID" + this.baseVoltageID + "\nbaseVoltage" + this.baseVoltage);
	}
		
}

    
