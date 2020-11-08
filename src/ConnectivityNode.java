

public class ConnectivityNode extends PowerSystemElement {
	
	String ConnectivityNodeContainer;

	public ConnectivityNode(String rdfID, String name, String ConnectivityNodeContainer) {
		super(rdfID, name);
		this.ConnectivityNodeContainer = ConnectivityNodeContainer;
	}

}
