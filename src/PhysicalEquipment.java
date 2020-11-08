

public class PhysicalEquipment extends PowerSystemElement {

	String type;
	boolean isBus;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;

	public PhysicalEquipment(String rdfID, String name, String type, boolean isBus, String terminal1, String CN1, String terminal2, String CN2) {
		super(rdfID, name);
		this.type = type;
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
				"\ntype: " + this.type + 
				"\nterminal 1.: " + this.terminal1 +
				"\nCN 1.: " + this.CN1 +
				"\nterminal 2.: " + this.terminal2 +
				"\nCN 2.: " + this.CN2 +
				"\nisBus?: " + this.isBus + 
				"\n");
	} 

}
