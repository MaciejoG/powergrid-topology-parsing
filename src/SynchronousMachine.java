

public class SynchronousMachine extends EquipmentContainer {
	float ratedS;
	float P;
	float Q;
	String genUnit;
	String regControl;
	String baseVoltageID;
	float baseVoltage;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;
	Boolean isBus;


	SynchronousMachine(String rdfID, String name, float ratedS, float P, float Q, String genUnit,String regControl, String equipmentContainer, String baseVoltageID, float baseVoltage,String terminal1, String CN1, String terminal2, String CN2,Boolean isBus ) {
		super(rdfID, name, equipmentContainer);
		this.ratedS = ratedS;
		this.P = P; //SSH file
		this.Q = Q; //SSH file
		this.genUnit = genUnit;
		this.regControl = regControl;
		this.baseVoltage = baseVoltage; //Not in file
		this.baseVoltageID = baseVoltageID; //Not in file
		this.terminal1 = terminal1;
		this.terminal2 = terminal2;
		this.CN1 = CN1;
		this.CN2 = CN2;
		this.isBus = isBus;
	}

	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', " + this.ratedS + ", " + this.P + ", " + this.Q+ ", '" + this.genUnit+ "', '" + this.regControl+ "', '" + this.equipmentContainer + "', '" + this.baseVoltageID+ "')";
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

