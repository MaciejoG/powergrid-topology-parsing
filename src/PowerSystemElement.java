

public class PowerSystemElement {
	String rdfID;
	String name;

	// CONSTRUCTOR
	PowerSystemElement(String rdfID, String name)
	{
		this.rdfID = rdfID;
		this.name = name;
	} 

	@Override
	public String toString() { 
		return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "\n"); 
	} 

}
