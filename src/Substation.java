

public class Substation extends PowerSystemElement {

	String region;

	public Substation(String rdfID, String name, String region) {
		super(rdfID, name);
		this.region = region;
	}

	public String insertTableSQL(){
		return "VALUES ('" + this.rdfID + "', '" + this.name + "', '" + this.region + "')";
	}		
	
	
	
	@Override 
    /** Overrides the superclass' toString() method **/
	public String toString() { 
        return String.format("rdfID: " + this.rdfID + "\nname: " + this.name + "\nregion:" + this.region + "\n"); 
    }

}
