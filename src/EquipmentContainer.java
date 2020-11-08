


public class EquipmentContainer extends PowerSystemElement{
	String equipmentContainer;
	
	EquipmentContainer(String rdfID, String name, String equipmentContainer) {
		super(rdfID, name);
		this.equipmentContainer = equipmentContainer;
	}

	@Override 
    /** Overrides the superclass' toString() method **/
	public String toString() { 
        return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "/nequipmentContainer" + this.equipmentContainer + "\n");
	}  
}
