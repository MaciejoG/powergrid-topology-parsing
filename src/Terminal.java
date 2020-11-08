

public class Terminal extends PowerSystemElement {

	String ConductingEquipment;
	String ConnectivityNode;
	
	public Terminal(String rdfID, String name, String ConductingEquipment, String ConnectivityNode) {
		super(rdfID, name);
		this.ConductingEquipment = ConductingEquipment;
		this.ConnectivityNode = ConnectivityNode;
	}

	
	
}
