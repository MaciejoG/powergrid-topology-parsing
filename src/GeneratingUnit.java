


public class GeneratingUnit extends EquipmentContainer {
	 float maxP;
	 float minP;
	
	
	GeneratingUnit(String rdfID, String name, float maxP, float minP, String equipmentContainer) {
		super(rdfID, name, equipmentContainer);
		this.maxP = maxP;
		this.minP = minP;
	
	}
	

	


	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', " + this.maxP + ", " + this.minP + ", '" + this.equipmentContainer + "')";
	}  
	
	
	@Override 
    /** Overrides the superclass' toString() method **/
	public String toString() { 
        return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "/nequipmentContainer" + this.equipmentContainer + "/nmaxP" + this.maxP + "/nminP" + this.minP +"\n");
	}      
      

}
