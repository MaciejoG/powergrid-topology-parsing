


public class PowerTransformer extends EquipmentContainer {

	float r;
	float x;
	float b;
	float g;
	float ratedS1;
	float ratedS2;
	float ratedU1;
	float ratedU2;
	String baseVoltageID;
	float baseVoltage;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;
	Boolean isBus;
	

	PowerTransformer(String rdfID, String name, String equipmentContainer, float r, float x, float b, float g, float ratedS1, float ratedS2, float ratedU1, float ratedU2, String baseVoltageID, float baseVoltage,String terminal1, String CN1, String terminal2, String CN2,Boolean isBus  ) {
		super(rdfID, name, equipmentContainer);
		this.r = r;
		this.x = x;
		this.b = b;
		this.g = g;
		this.ratedS1 = ratedS1;
		this.ratedS2 = ratedS2;
		this.ratedU1 = ratedU1;
		this.ratedU2 = ratedU2;
		this.baseVoltageID = baseVoltageID;
		this.baseVoltage = baseVoltage; // FOR PRIMARY SIDE
		this.terminal1 = terminal1;
		this.terminal2 = terminal2;
		this.CN1 = CN1;
		this.CN2 = CN2;
		this.isBus = isBus;
	}


	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', '" + this.equipmentContainer + "')";
	}	
	
	
	public Complex getZpu(){
		Complex Z = new Complex(this.r, this.x);
		int S = 1000;
		float ZbasePrimary = this.ratedU1 * this.ratedU1 / this.ratedS1;
		float Zbase = this.baseVoltage * this.baseVoltage / S; // FOR PRIMARY SIDE!!
		Complex Zpu = Z.scale(1/Zbase);
		//Complex Zpu = Z.scale(ZbasePrimary/Zbase);
	
		return Zpu.reciprocal();
	}
	
	public Complex getYpu(){
		Complex Y = new Complex(this.g, this.b);
		int S = 1000;
		float ZbasePrimary = this.ratedU1 * this.ratedU1 / this.ratedS1;
		float Zbase = this.baseVoltage * this.baseVoltage / S; // FOR PRIMARY SIDE!!
		Complex Ypu = Y.scale(0.5*Zbase);
		//Complex Zpu = Z.scale(ZbasePrimary/Zbase);
	
		return Ypu;
	}
	

	@Override 
	/** Overrides the superclass' toString() method **/
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + 
				"\nname: " + this.name + 
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


