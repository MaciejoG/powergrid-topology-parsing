

public class LinearShuntCompensator extends EquipmentContainer {
	
	float b;
	float g;
	String baseVoltageID;
	float baseVoltage;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;
	Boolean isBus;

	public LinearShuntCompensator(String rdfID, String name,String equipmentContainer,float b,float g,String baseVoltageID,float baseVoltage,String terminal1, String CN1, String terminal2, String CN2,Boolean isBus) {
		super(rdfID, name, equipmentContainer);
		this.b = b;
		this.g = g;
		this.baseVoltageID = baseVoltageID;
		this.terminal1 = terminal1;
		this.terminal2 = terminal2;
		this.CN1 = CN1;
		this.CN2 = CN2;
		this.isBus = isBus;
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
