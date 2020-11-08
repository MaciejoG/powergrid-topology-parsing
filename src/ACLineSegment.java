

public class ACLineSegment extends EquipmentContainer {

	float r;
	float x;
	float b;
	float g;
	float length;
	String baseVoltageID;
	float baseVoltage;
	String terminal1;
	String terminal2;
	String CN1;
	String CN2;
	Boolean isBus;

	public ACLineSegment(String rdfID, String name, String equipmentContainer, float r, float x, float b, float g, float length,String baseVoltageID,float baseVoltage,String terminal1, String CN1, String terminal2, String CN2,Boolean isBus) {
		super(rdfID, name, equipmentContainer);
		this.r = r;
		this.x = x;
		this.b = b;
		this.g = g;
		this.length = length;
		this.baseVoltageID = baseVoltageID;
		this.baseVoltage = baseVoltage;
		this.terminal1 = terminal1;
		this.terminal2 = terminal2;
		this.CN1 = CN1;
		this.CN2 = CN2;
		this.isBus = isBus;

	}



	public Complex getZpu(){
		Complex Z = new Complex(this.r, this.x);
		int S = 1000;
		float Zbase = this.baseVoltage * this.baseVoltage / S;
		Complex Zpu = (Z.scale(this.length)).scale(1/Zbase);
	
		return Zpu.reciprocal();
	}
	
	public Complex getYpu(){
		Complex Y = new Complex(this.g, this.b);
		int S = 1000;
		float Zbase = this.baseVoltage * this.baseVoltage / S;
		Complex Ypu = Y.scale(this.length*0.5*Zbase);
		
		
		return Ypu;
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
