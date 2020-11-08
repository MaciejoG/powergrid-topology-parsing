

public class PowerTransformerEnd extends PowerSystemElement {

	float r;
	float x;
	float b;
	float g;
	float ratedS;
	float ratedU;
	int endNumber;
	String baseVoltageID;
	float baseVoltage;
	String PowerTransformerID;;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;
	Boolean isBus;

	public PowerTransformerEnd(String rdfID, String name, float r, float x, float b, float g, float ratedS, float ratedU, int endNumber, String baseVoltageID, String PowerTransformerID, float baseVoltage,String terminal1, String CN1, String terminal2, String CN2,Boolean isBus) {
		super(rdfID, name);
		this.r = r;
		this.x = x;
		this.b = b;
		this.g = g;
		this.ratedS = ratedS;
		this.ratedU = ratedU;
		this.endNumber = endNumber;
		this.baseVoltageID = baseVoltageID;
		this.baseVoltage = baseVoltage;
		this.PowerTransformerID = PowerTransformerID;
		this.terminal1 = terminal1;
		this.terminal2 = terminal2;
		this.CN1 = CN1;
		this.CN2 = CN2;
		this.isBus = isBus;
	}

	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', " + this.r + ", " + this.x + ", '" + this.baseVoltageID + "', '" + this.PowerTransformerID + "')";
	}

	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + 
				"\nname: " + this.name + 
				"\ntransformer: " + this.PowerTransformerID  + 
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
