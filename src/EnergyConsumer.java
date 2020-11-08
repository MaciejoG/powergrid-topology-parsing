

public class EnergyConsumer extends EquipmentContainer {

	float P;
	float Q;
	String baseVoltageID;
	float baseVoltage;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;
	Boolean isBus;
	


	EnergyConsumer(String rdfID, String name, float P, float Q, String equipmentContainer, String baseVoltageID, float baseVoltage,String terminal1, String CN1, String terminal2, String CN2,Boolean isBus) {
		super(rdfID, name, equipmentContainer);
		this.P = P; //SSH file
		this.Q = Q;//SSH file
		this.baseVoltageID = baseVoltageID; //no baseVoltage in file
		this.baseVoltage = baseVoltage; //no baseVoltage in file
		this.terminal1 = terminal1;
		this.terminal2 = terminal2;
		this.CN1 = CN1;
		this.CN2 = CN2;
		this.isBus = isBus;
	}

	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', " + this.P + ", " + this.Q+ ", '" + this.equipmentContainer + "', '" + this.baseVoltageID + "')";
	}	
	

	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + 
				"\nname: " + this.name + 
				"\nequipmentContainer: " + this.equipmentContainer  + 
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
