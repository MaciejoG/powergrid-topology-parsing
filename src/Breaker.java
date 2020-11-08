


public class Breaker extends EquipmentContainer {

	boolean state;
	String baseVoltageID;
	float baseVoltage;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;
	Boolean isBus;


	Breaker(String rdfID, String name, String equipmentContainer, String baseVoltageID, boolean state,float baseVoltage, String terminal1, String CN1, String terminal2, String CN2,Boolean isBus) {
		super(rdfID, name, equipmentContainer);
		this.baseVoltageID = baseVoltageID;
		this.state = state; //SSH and EQ file
		this.terminal1 = terminal1;
		this.terminal2 = terminal2;
		this.CN1 = CN1;
		this.CN2 = CN2;
		this.isBus = isBus;
		
	}



	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', " + this.state + ", '" + this.equipmentContainer + "','" + this.baseVoltageID + "')";
	}	



	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + 
				"\nname: " + this.name + 
				"\nequipmentContainer: " + this.equipmentContainer  + 
				"\nstate: " + this.state  +
				"\nbaseVoltageID: " + this.baseVoltageID + 
				"\nbaseVoltage: " + this.baseVoltage + 
				"\nterminal 1.: " + this.terminal1 +
				"\nCN 1.: " + this.CN1 +
				"\nterminal 2.: " + this.terminal2 +
				"\nCN 2.: " + this.CN2 +
				"\nisBus?: " + this.isBus + 
				"\n");
	}
	
}
