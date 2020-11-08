
import java.sql.* ;  // for standard JDBC programs

import org.w3c.dom.Document;

public class SQLdatabase {

	public static void main(String[] args) {


		//XMLparser class1 = new XMLparser();
		Document docEQ = XMLparser.buildDocument("Assignment_EQ_reduced.xml");
		Document docSSH = XMLparser.buildDocument("Assignment_SSH_reduced.xml");


		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		String nodeToSearch = "cim:BaseVoltage"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		BaseVoltage BaseVoltages[]=new BaseVoltage[docEQ.getElementsByTagName(nodeToSearch).getLength()];		
		String[] attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		String[] elementsArray = new String[]{"cim:BaseVoltage.nominalVoltage","cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		String[] childNodesArray = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] BaseVoltage = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < BaseVoltage.length; i++) {
			BaseVoltages[i] = new BaseVoltage(BaseVoltage[i][0],Float.valueOf(BaseVoltage[i][1]),BaseVoltage[i][2]);
		}
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:Terminal"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		Terminal Terminals[]=new Terminal[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Terminal.ConductingEquipment","cim:Terminal.ConnectivityNode"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] Terminal = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < Terminal.length; i++) {		
			Terminals[i] = new Terminal(Terminal[i][0],Terminal[i][1],Terminal[i][2],Terminal[i][3]);
		} // end of outer for
		// COPY UNTIL HERE


		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:ConnectivityNode"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		ConnectivityNode ConnectivityNodes[]=new ConnectivityNode[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:ConnectivityNode.ConnectivityNodeContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] ConnectivityNode = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < ConnectivityNode.length; i++) {		
			ConnectivityNodes[i] = new ConnectivityNode(ConnectivityNode[i][0],ConnectivityNode[i][1],ConnectivityNode[i][2]);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:VoltageLevel"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		VoltageLevel VoltageLevels[]=new VoltageLevel[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:VoltageLevel.Substation","cim:VoltageLevel.BaseVoltage"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		float baseVoltageValue = 0;
		String[][] VoltageLevel = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < VoltageLevel.length; i++) {			
			for (int j = 0; j < BaseVoltage.length; j++) {
				if (VoltageLevel[i][3].equals(('#'+BaseVoltage[j][0]))) {
					baseVoltageValue = Float.valueOf(BaseVoltage[j][1]);
				} // end of if
			} // end of inner for			
			VoltageLevels[i] = new VoltageLevel(VoltageLevel[i][0],VoltageLevel[i][1],VoltageLevel[i][2],VoltageLevel[i][3],baseVoltageValue);
		} // end of outer for
		// System.out.println(VoltageLevels[1].rdfID);
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:Substation"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		Substation Substations[]=new Substation[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Substation.Region"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] Substation = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < Substation.length; i++) {		
			Substations[i] = new Substation(Substation[i][0],Substation[i][1],Substation[i][2]);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:BusbarSection"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		BusbarSection BusbarSections[]=new BusbarSection[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Equipment.EquipmentContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] BusbarSection = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		String[][] terminals = new String[][]{{"",""},{"",""}};
		boolean type = true;
		for (int i = 0; i < BusbarSection.length; i++) {
			terminals[0][0] = ""; // EMPTY THE TERMINALS BEFORE STARTING
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
			for (int k = 0, a = 0; k < Terminal.length; k++) { // TO GET TERMINALS
				if (Terminals[k].ConductingEquipment.equals('#'+BusbarSection[i][0])) {
					terminals[a][0] = Terminals[k].rdfID;
					terminals[a][1] = Terminals[k].ConnectivityNode;
					a++;			
				} // end of if
			} // end of inner for
			type = true;
			BusbarSections[i] = new BusbarSection(BusbarSection[i][0],BusbarSection[i][1],BusbarSection[i][2],terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:Breaker"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		Breaker Breakers[]=new Breaker[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Equipment.EquipmentContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[] attributesArraySSH = new String[]{"rdf:about"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		String[] elementsArraySSH = new String[]{"cim:Switch.open"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		String[] childNodesArraySSH = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] Breaker = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		String[][] BreakerSSH = XMLparser.extractInformation(docSSH, nodeToSearch, attributesArraySSH, elementsArraySSH, childNodesArraySSH);
		boolean breakerState = true;
		String baseVoltageID = null;
		for (int i = 0; i < BreakerSSH.length; i++) {	
			for (int m = 0; m < Breaker.length; m++) { // TO GET THE STATE OF BREAKER
				if (('#'+Breaker[i][0]).equals(BreakerSSH[m][0])) {
					breakerState = Boolean.valueOf(BreakerSSH[m][1]);
				} // end of if
			} // end of inner for
			for (int j = 0; j < VoltageLevel.length; j++) { // TO GET THE BASEVOLTAGE ID
				if (Breaker[i][2].equals('#'+VoltageLevel[j][0])) {
					baseVoltageID = VoltageLevel[j][3];
				} // end of if
			} // end of inner for	
			for (int n = 0; n < BaseVoltage.length; n++) { // TO GET THE BASEVOLTAGE VALUE
				if (baseVoltageID.equals(('#'+BaseVoltage[n][0]))) {
					baseVoltageValue = Float.valueOf(BaseVoltage[n][1]);
				} // end of if
			} // end of inner for	
			for (int k = 0, a = 0; k < Terminal.length; k++) { // TO GET TERMINALS
				if (Terminals[k].ConductingEquipment.equals('#'+Breaker[i][0])) {
					terminals[a][0] = Terminals[k].rdfID;
					terminals[a][1] = Terminals[k].ConnectivityNode;
					a++;			
				} // end of if
			} // end of inner for
			if (terminals[1][0].equals("")) { // TO GET THE TYPE
				type = true;
			} else {
				type = false;
			} // end of if...else
			Breakers[i] = new Breaker(Breaker[i][0],Breaker[i][1],Breaker[i][2],baseVoltageID,breakerState,baseVoltageValue,terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
			terminals[0][0] = ""; // EMPTY THE TERMINALS
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:PowerTransformerEnd"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		PowerTransformerEnd PowerTransformerEnds[]=new PowerTransformerEnd[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name","cim:PowerTransformerEnd.r","cim:PowerTransformerEnd.x","cim:PowerTransformerEnd.b","cim:PowerTransformerEnd.g","cim:PowerTransformerEnd.ratedS","cim:PowerTransformerEnd.ratedU","cim:TransformerEnd.endNumber"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:TransformerEnd.BaseVoltage","cim:PowerTransformerEnd.PowerTransformer","cim:TransformerEnd.Terminal"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] PowerTransformerEnd = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < PowerTransformerEnd.length; i++) {	
			terminals[0][0] = ""; // EMPTY THE TERMINALS BEFORE STARTING
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
			for (int j = 0; j < BaseVoltage.length; j++) {
				if (PowerTransformerEnd[i][9].equals(('#'+BaseVoltage[j][0]))) { // TO GET THE BASEVOLTAGE VALUE
					baseVoltageValue = Float.valueOf(BaseVoltage[j][1]);
				} // end of if
			} // end of inner for	
			for (int k = 0, a = 0; k < Terminal.length; k++) { // TO GET TERMINALS
				if (('#'+Terminals[k].rdfID).equals(PowerTransformerEnd[i][11])) {
					terminals[a][0] = Terminals[k].rdfID;
					terminals[a][1] = Terminals[k].ConnectivityNode;
					a++;			
				} // end of if
			} // end of inner for
			if (terminals[1][0].equals("")) { // TO GET THE TYPE
				type = true;
			} else {
				type = false;
			} // end of if...else
			PowerTransformerEnds[i] = new PowerTransformerEnd(PowerTransformerEnd[i][0],PowerTransformerEnd[i][1],Float.valueOf(PowerTransformerEnd[i][2]),Float.valueOf(PowerTransformerEnd[i][3]),Float.valueOf(PowerTransformerEnd[i][4]),Float.valueOf(PowerTransformerEnd[i][5]),Float.valueOf(PowerTransformerEnd[i][6]),Float.valueOf(PowerTransformerEnd[i][7]),Integer.valueOf(PowerTransformerEnd[i][8]),PowerTransformerEnd[i][9],PowerTransformerEnd[i][10],baseVoltageValue,terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
		} // end of outer for
		// System.out.println(VoltageLevels[1].rdfID);
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:PowerTransformer"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		PowerTransformer PowerTransformers[]=new PowerTransformer[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Equipment.EquipmentContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] PowerTransformer = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		float r=1;
		float x=1;
		float b=1;
		float g=1;
		float ratedS1 = 1;
		float ratedS2 = 1;
		float ratedU1 = 1;
		float ratedU2 = 1;
		for (int i = 0; i < PowerTransformer.length; i++) {	
			terminals[0][0] = ""; // EMPTY THE TERMINALS BEFORE STARTING
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
			for(int j=0; j<PowerTransformerEnds.length; j++){
				if (PowerTransformerEnds[j].PowerTransformerID.equals("#"+PowerTransformer[i][0]) && PowerTransformerEnds[j].endNumber==1){
					r = PowerTransformerEnds[j].r;
					x = PowerTransformerEnds[j].x;
					b = PowerTransformerEnds[j].b;
					g = PowerTransformerEnds[j].g;
					ratedS1 = PowerTransformerEnds[j].ratedS;
					ratedU1 = PowerTransformerEnds[j].ratedU;
					terminals[0][0] = PowerTransformerEnds[j].terminal1; // EMPTY THE TERMINALS BEFORE STARTING
					terminals[0][1] = PowerTransformerEnds[j].CN1;
					baseVoltageID = PowerTransformerEnds[j].baseVoltageID;
					baseVoltageValue = PowerTransformerEnds[j].baseVoltage; // BASE VOLTAGE FOR PRIMARY SIDE!!!
				} else if(PowerTransformerEnds[j].PowerTransformerID.equals("#"+PowerTransformer[i][0]) && PowerTransformerEnds[j].endNumber==2) {
					terminals[1][0] = PowerTransformerEnds[j].terminal1; // EMPTY THE TERMINALS BEFORE STARTING
					terminals[1][1] = PowerTransformerEnds[j].CN1;
					ratedS2 = PowerTransformerEnds[j].ratedS;
					ratedU2 = PowerTransformerEnds[j].ratedU;
				} // end of else...if
				type = false;
			} // end of inner for
			PowerTransformers[i] = new PowerTransformer(PowerTransformer[i][0],PowerTransformer[i][1],PowerTransformer[i][2],r,x,b,g,ratedS1,ratedS2,ratedU1,ratedU2,baseVoltageID,baseVoltageValue,terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:EnergyConsumer"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		EnergyConsumer EnergyConsumers[]=new EnergyConsumer[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Equipment.EquipmentContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		attributesArraySSH = new String[]{"rdf:about"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArraySSH = new String[]{"cim:EnergyConsumer.p","cim:EnergyConsumer.q"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArraySSH = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] EnergyConsumer = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		String[][] EnergyConsumerSSH = XMLparser.extractInformation(docSSH, nodeToSearch, attributesArraySSH, elementsArraySSH, childNodesArraySSH);
		float P = 0;
		float Q = 0;
		for (int i = 0; i < EnergyConsumerSSH.length; i++) {	
			terminals[0][0] = ""; // EMPTY THE TERMINALS BEFORE STARTING
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
			for (int m = 0; m < EnergyConsumer.length; m++) { // TO GET THE P AND Q
				if (('#'+EnergyConsumer[i][0]).equals(EnergyConsumerSSH[m][0])) {
					P = Float.valueOf(EnergyConsumerSSH[m][1]);
					Q = Float.valueOf(EnergyConsumerSSH[m][2]);
				} // end of if
			} // end of inner for
			for (int j = 0; j < VoltageLevel.length; j++) { // TO GET THE BASEVOLTAGE ID
				if (EnergyConsumer[i][2].equals('#'+VoltageLevel[j][0])) {
					baseVoltageID = VoltageLevel[j][3];
				} // end of if
			} // end of inner for	
			for (int n = 0; n < BaseVoltage.length; n++) { // TO GET THE BASEVOLTAGE VALUE
				if (baseVoltageID.equals(('#'+BaseVoltage[n][0]))) {
					baseVoltageValue = Float.valueOf(BaseVoltage[n][1]);
				} // end of if
			} // end of inner for	
			for (int k = 0, a = 0; k < Terminal.length; k++) { // TO GET TERMINALS
				if (Terminals[k].ConductingEquipment.equals('#'+EnergyConsumer[i][0])) {
					terminals[a][0] = Terminals[k].rdfID;
					terminals[a][1] = Terminals[k].ConnectivityNode;
					a++;			
				} // end of if
			} // end of inner for
			if (terminals[1][0].equals("")) { // TO GET THE TYPE
				type = true;
			} else {
				type = false;
			} // end of if...else
			EnergyConsumers[i] = new EnergyConsumer(EnergyConsumer[i][0],EnergyConsumer[i][1],P,Q,EnergyConsumer[i][2],baseVoltageID,baseVoltageValue,terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:LinearShuntCompensator"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		LinearShuntCompensator LinearShuntCompensators[]=new LinearShuntCompensator[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name","cim:LinearShuntCompensator.bPerSection","cim:LinearShuntCompensator.gPerSection"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Equipment.EquipmentContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] LinearShuntCompensator = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < LinearShuntCompensator.length; i++) {	
			terminals[0][0] = ""; // EMPTY THE TERMINALS BEFORE STARTING
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
			for (int j = 0; j < VoltageLevel.length; j++) { // TO GET THE BASEVOLTAGE ID
				if (LinearShuntCompensator[i][4].equals('#'+VoltageLevel[j][0])) {
					baseVoltageID = VoltageLevel[j][3];
				} // end of if
			} // end of inner for	
			for (int n = 0; n < BaseVoltage.length; n++) { // TO GET THE BASEVOLTAGE VALUE
				if (baseVoltageID.equals(('#'+BaseVoltage[n][0]))) {
					baseVoltageValue = Float.valueOf(BaseVoltage[n][1]);
				} // end of if
			} // end of inner for	
			for (int k = 0, a = 0; k < Terminal.length; k++) { // TO GET TERMINALS
				if (Terminals[k].ConductingEquipment.equals('#'+LinearShuntCompensator[i][0])) {
					terminals[a][0] = Terminals[k].rdfID;
					terminals[a][1] = Terminals[k].ConnectivityNode;
					a++;			
				} // end of if
			} // end of inner for
			if (terminals[1][0].equals("")) { // TO GET THE TYPE
				type = true;
			} else {
				type = false;
			} // end of if...else
			LinearShuntCompensators[i] = new LinearShuntCompensator(LinearShuntCompensator[i][0],LinearShuntCompensator[i][1],LinearShuntCompensator[i][4],Float.valueOf(LinearShuntCompensator[i][2]),Float.valueOf(LinearShuntCompensator[i][3]),baseVoltageID,baseVoltageValue,terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:ACLineSegment"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		ACLineSegment ACLineSegments[]=new ACLineSegment[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name","cim:ACLineSegment.r","cim:ACLineSegment.x","cim:ACLineSegment.bch","cim:Conductor.length","cim:ACLineSegment.gch"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Equipment.EquipmentContainer","cim:ConductingEquipment.BaseVoltage"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] ACLineSegment = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < ACLineSegment.length; i++) {	
			terminals[0][0] = ""; // EMPTY THE TERMINALS BEFORE STARTING
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
			for (int n = 0; n < BaseVoltage.length; n++) { // TO GET THE BASEVOLTAGE VALUE
				if (ACLineSegment[i][8].equals(('#'+BaseVoltage[n][0]))) {
					baseVoltageValue = Float.valueOf(BaseVoltage[n][1]);
				} // end of if
			} // end of inner for	
			for (int k = 0, a = 0; k < Terminal.length; k++) { // TO GET TERMINALS
				if (Terminals[k].ConductingEquipment.equals('#'+ACLineSegment[i][0])) {
					terminals[a][0] = Terminals[k].rdfID;
					terminals[a][1] = Terminals[k].ConnectivityNode;
					a++;			
				} // end of if
			} // end of inner for
			if (terminals[1][0].equals("")) { // TO GET THE TYPE
				type = true;
			} else {
				type = false;
			} // end of if...else
			ACLineSegments[i] = new ACLineSegment(ACLineSegment[i][0],ACLineSegment[i][1],ACLineSegment[i][7],Float.valueOf(ACLineSegment[i][2]),Float.valueOf(ACLineSegment[i][3]),Float.valueOf(ACLineSegment[i][4]),Float.valueOf(ACLineSegment[i][6]),Float.valueOf(ACLineSegment[i][5]),ACLineSegment[i][8],baseVoltageValue,terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:RatioTapChanger"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		RatioTapChanger RatioTapChangers[]=new RatioTapChanger[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		attributesArraySSH = new String[]{"rdf:about"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArraySSH = new String[]{"cim:TapChanger.step"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArraySSH = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] RatioTapChanger = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		String[][] RatioTapChangerSSH = XMLparser.extractInformation(docSSH, nodeToSearch, attributesArraySSH, elementsArraySSH, childNodesArraySSH);
		float step = 1;
		for (int i = 0; i < RatioTapChanger.length; i++) {	
			for (int m = 0; m < RatioTapChangerSSH.length; m++) { // TO GET THE STATE
				if (('#'+RatioTapChanger[i][0]).equals(RatioTapChangerSSH[m][0])) {
					step = Float.valueOf(RatioTapChangerSSH[m][1]);
				} // end of if
			} // end of inner for
			RatioTapChangers[i] = new RatioTapChanger(RatioTapChanger[i][0],RatioTapChanger[i][1],step);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:SynchronousMachine"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		SynchronousMachine SynchronousMachines[]=new SynchronousMachine[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name","cim:RotatingMachine.ratedS"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:RotatingMachine.GeneratingUnit","cim:RegulatingCondEq.RegulatingControl","cim:Equipment.EquipmentContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		attributesArraySSH = new String[]{"rdf:about"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArraySSH = new String[]{"cim:RotatingMachine.p","cim:RotatingMachine.q"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArraySSH = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] SynchronousMachine = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		String[][] SynchronousMachineSSH = XMLparser.extractInformation(docSSH, nodeToSearch, attributesArraySSH, elementsArraySSH, childNodesArraySSH);
		for (int i = 0; i < SynchronousMachine.length; i++) {	
			terminals[0][0] = ""; // EMPTY THE TERMINALS BEFORE STARTING
			terminals[0][1] = "";
			terminals[1][0] = "";
			terminals[1][1] = "";
			for (int m = 0; m < SynchronousMachineSSH.length; m++) { // TO GET THE P AND Q FROM SSH
				if (('#'+SynchronousMachine[i][0]).equals(SynchronousMachineSSH[m][0])) {
					P = Float.valueOf(SynchronousMachineSSH[m][1]);
					Q = Float.valueOf(SynchronousMachineSSH[m][2]);
				} // end of if
			} // end of inner for
			for (int j = 0; j < VoltageLevel.length; j++) { // TO GET THE BASEVOLTAGE ID
				if (SynchronousMachine[i][5].equals('#'+VoltageLevel[j][0])) {
					baseVoltageID = VoltageLevel[j][3];
				} // end of if
			} // end of inner for	
			for (int n = 0; n < BaseVoltage.length; n++) { // TO GET THE BASEVOLTAGE VALUE
				if (baseVoltageID.equals(('#'+BaseVoltage[n][0]))) {
					baseVoltageValue = Float.valueOf(BaseVoltage[n][1]);
				} // end of if
			} // end of inner for	
			for (int k = 0, a = 0; k < Terminal.length; k++) { // TO GET TERMINALS
				if (Terminals[k].ConductingEquipment.equals('#'+SynchronousMachine[i][0])) {
					terminals[a][0] = Terminals[k].rdfID;
					terminals[a][1] = Terminals[k].ConnectivityNode;
					a++;			
				} // end of if
			} // end of inner for
			if (terminals[1][0].equals("")) { // TO GET THE TYPE
				type = true;
			} else {
				type = false;
			} // end of if...else
			SynchronousMachines[i] = new SynchronousMachine(SynchronousMachine[i][0],SynchronousMachine[i][1],Float.valueOf(SynchronousMachine[i][2]),P,Q,SynchronousMachine[i][3],SynchronousMachine[i][4],SynchronousMachine[i][5],baseVoltageID,baseVoltageValue,terminals[0][0],terminals[0][1],terminals[1][0],terminals[1][1],type);
		} // end of outer for
		// COPY UNTIL HERE
		/*System.out.println(SynchronousMachines[0].rdfID);
				System.out.println(SynchronousMachines[0].baseVoltageID);
				System.out.println(SynchronousMachines[0].baseVoltage);*/



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:GeneratingUnit"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		GeneratingUnit GeneratingUnits[]=new GeneratingUnit[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name","cim:GeneratingUnit.maxOperatingP","cim:GeneratingUnit.minOperatingP"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{"cim:Equipment.EquipmentContainer"}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] GeneratingUnit = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		for (int i = 0; i < GeneratingUnit.length; i++) {		
			GeneratingUnits[i] = new GeneratingUnit(GeneratingUnit[i][0],GeneratingUnit[i][1],Float.valueOf(GeneratingUnit[i][2]),Float.valueOf(GeneratingUnit[i][3]),GeneratingUnit[i][4]);
		} // end of outer for
		// COPY UNTIL HERE



		// THIS SECTION NEEDS TO BE COPIED AND PASTED (+ MODIFIED ACCORDINGLY) FOR EVERY NODE WE WANT TO SCAN
		nodeToSearch = "cim:RegulatingControl"; // <- SPECIFY NODE TO BE FOUND
		// Initializing new objects array
		RegulatingControl RegulatingControls[]=new RegulatingControl[docEQ.getElementsByTagName(nodeToSearch).getLength()];
		attributesArray = new String[]{"rdf:ID"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArray = new String[]{"cim:IdentifiedObject.name"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArray = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		attributesArraySSH = new String[]{"rdf:about"}; // <- PROVIDE ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)
		elementsArraySSH = new String[]{"cim:RegulatingControl.targetValue"}; // <- PROVIDE ELEMENTS YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)	 
		childNodesArraySSH = new String[]{}; // <- PROVIDE CHILD ATTRIBUTES YOU WANT TO FIND (SEQUENCE AS IN THE XML DOCUMMENT)		
		String[][] RegulatingControl = XMLparser.extractInformation(docEQ, nodeToSearch, attributesArray, elementsArray, childNodesArray);
		String[][] RegulatingControlSSH = XMLparser.extractInformation(docSSH, nodeToSearch, attributesArraySSH, elementsArraySSH, childNodesArraySSH);
		float targetValue = 1;
		for (int i = 0; i < RegulatingControl.length; i++) {	
			for (int m = 0; m < RegulatingControlSSH.length; m++) { // TO GET THE STATE
				if (('#'+RegulatingControl[i][0]).equals(RegulatingControlSSH[m][0])) {
					targetValue = Float.valueOf(RegulatingControlSSH[m][1]);
				} // end of if
			} // end of inner for
			RegulatingControls[i] = new RegulatingControl(RegulatingControl[i][0],RegulatingControl[i][1],targetValue);
		} // end of outer for
		// COPY UNTIL HERE



		////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////			
		////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////			
		////////////////////////////////////////////////////////////////////////////////////			


		Connection conn = null;
		Statement stmt = null;
		String database = "PowerSystem";
		String username = "root";
		String password = "root";


		try{

			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver"); // dynamically load the driver's class file into memory, which automatically registers it

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + database,username,password);
			System.out.println("Connected database successfully...");

			System.out.println("Creating statement...");
			stmt = conn.createStatement(); // Creates a Statement object
			System.out.println("Statement created...");

			//STEP 4: CREATING TABLES AND INSERTING RECORDS
			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			String tableName = "PowerTransformerEnd";
			String[] columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
					"Transformer_r FLOAT(10)",
					"Transformer_x FLOAT(10)",
					"baseVoltage_rdf_ID VARCHAR(255)",
			"Transformer_rdf_ID VARCHAR(255)"};
			String primaryKey = "rdf_ID";
			String sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			String sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<PowerTransformerEnd.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + PowerTransformerEnds[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			}

			//// /////////////////////////////BaseVoltage


			//STEP 4: CREATING TABLES AND INSERTING RECORDS
			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "BaseVoltage";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
			"nominal_Voltage FLOAT(10)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<BaseVoltage.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + BaseVoltages[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			}




			////////////////////EnergyConsumer

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "EnergyConsumer";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
					"P FLOAT(10)",
					"Q FLOAT(10)",
					"Equipment_rdf_ID VARCHAR(255)",
			"baseVoltage_rdf_ID VARCHAR(255)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<EnergyConsumer.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + EnergyConsumers[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			}


			/////////////////////GeneratingUnit

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "GeneratingUnit";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
					"maxOperatingP FLOAT(10)",
					"minOperatingP FLOAT(10)",
			"equipmentContainer_rdf_ID VARCHAR(255)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<GeneratingUnit.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + GeneratingUnits[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			}
			////////////////PowerTransformer			    

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "PowerTransformer";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
			"equipmentContainer_rdf_ID VARCHAR(255)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<PowerTransformer.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + PowerTransformers[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			}

			////////////////////////RatioTapChanger

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "RatioTapChanger";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
			"stepVoltage FLOAT(10)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<RatioTapChanger.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + RatioTapChangers[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			} 


			//////////////////////	RegulatingControl		    
			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "RegulatingControl";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
			"targetValue FLOAT(10)"}; 
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<RegulatingControl.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + RegulatingControls[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			} 

			///////////////////////Substation

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "Substation";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
			"Region VARCHAR(255)"}; 
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<Substation.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + Substations[i].insertTableSQL();				   
				stmt.executeUpdate(sql_records);	
			} 

			///////////////////////////////////////	VoltageLevel

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "VoltageLevel";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
					"substation_rdf_ID VARCHAR(255)",
			"baseVoltage_rdf_ID VARCHAR (255)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<VoltageLevel.length; i++){
				System.out.println("INSERT INTO " + tableName + " " + VoltageLevels[i].insertTableSQL());
				String sql_records = "INSERT INTO " + tableName + " " + VoltageLevels[i].insertTableSQL();			    	

				stmt.executeUpdate(sql_records);	
			} 			    
			////////////////////SynchronousMachine

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "SynchronousMachine";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
					"ratedS FLOAT(10)",
					"P FLOAT (10)",
					"Q FLOAT (10)",
					"generatingUnit VARCHAR (255)",
					"regulatingControl VARCHAR (255)",
					"equipmentContainer VARCHAR(255)",
			"baseVoltage_rdf_ID VARCHAR (255)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<SynchronousMachine.length; i++){
				String sql_records = "INSERT INTO " + tableName + " " + SynchronousMachines[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			} 


			//////////////////////Breaker			 

			System.out.println("Creating tableS in given database...");	
			// CREATING TABLE
			tableName = "Breaker";
			columnsArray = new String[]{
					"rdf_ID VARCHAR(255)",
					"name VARCHAR(255)",
					"State VARCHAR(255)",
					"Equipment_rdf_ID VARCHAR(255)",
			"baseVoltage_rdf_ID VARCHAR(255)"};
			primaryKey = "rdf_ID";
			sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			sql_table = formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<4; i++){
				String sql_records = "INSERT INTO " + tableName + " " + Breakers[i].insertTableSQL();
				stmt.executeUpdate(sql_records);	
			}	

			////////////////////////////////////////////////////////////////////////////////////		    
			////////////////////////////////////////////////////////////////////////////////////			    
			////////////////////////////////////////////////////////////////////////////////////			    
			////////////////////////////////////////////////////////////////////////////////////



		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close(); // closing the object because it is a good practice
				//pstmt.close(); // closing the prepared object
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try


	}//end main

	// METHODS

	public static void createDatabase(String username, String password, String database) {
		/// establish connection to a given database

		Connection conn = null;
		Statement stmt = null;

		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver"); // dynamically load the driver's class file into memory, which automatically registers it

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/",username,password);
			System.out.println("Connected database successfully...");

			System.out.println("Creating statement...");
			stmt = conn.createStatement(); // Creates a Statement object
			System.out.println("Statement created...");

			//STEP 4: Execute a query

			// Create a database
			System.out.println("Creating database...");

			String sql_database = "CREATE DATABASE IF NOT EXISTS " + database;
			stmt.executeUpdate(sql_database);
			System.out.println("Database created successfully or already existed...");


		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close(); // closing the object because it is a good practice
				//pstmt.close(); // closing the prepared object
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try   
		}//end main try
		System.out.println("Goodbye!");
	}

	public static void createTable(String username, String password, String database, String tableName, String[] columnsArray, String primaryKey)  {
		// Create a table

		Connection conn = null;
		Statement stmt = null;

		try{

			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver"); // dynamically load the driver's class file into memory, which automatically registers it

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + database,username,password);
			System.out.println("Connected database successfully...");

			System.out.println("Creating statement...");
			stmt = conn.createStatement(); // Creates a Statement object
			System.out.println("Statement created...");

			//STEP 4: Execute query
			System.out.println("Creating table in given database...");

			String sql_table = "CREATE TABLE IF NOT EXISTS " + tableName + "(";
			for (int i = 0; i < columnsArray.length; i++){
				sql_table = sql_table + columnsArray[i] + ", ";
			}
			sql_table = sql_table + "PRIMARY KEY ( " + primaryKey + " ))";

			//System.out.println(sql_table);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close(); // closing the object because it is a good practice
				//pstmt.close(); // closing the prepared object
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try

	}

	public static String formTableStatement(String tableName, String[] columnsArray, String primaryKey){		  
		String sql_table = "CREATE TABLE IF NOT EXISTS " + tableName + "(";
		for (int i = 0; i < columnsArray.length; i++){
			sql_table = sql_table + columnsArray[i] + ", ";
		}
		return sql_table = sql_table + "PRIMARY KEY ( " + primaryKey + " ))";
	}





}//end SQLdatabase
