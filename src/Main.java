import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.w3c.dom.Document;


public class Main extends JFrame {

	private static final long serialVersionUID = 1L;



	public static void main(String[] args) {
		//XMLparser class1 = new XMLparser();
		Document docEQ = XMLparser.buildDocument("Assignment_EQ.xml");
		Document docSSH = XMLparser.buildDocument("Assignment_SSH.xml");


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



		ArrayList<PhysicalEquipment> PhysicalEquipmentList = new ArrayList<PhysicalEquipment>();
		ArrayList<PhysicalEquipment> lgsList = new ArrayList<PhysicalEquipment>();

		for(int i=0; i<(Breakers.length); i++){
			PhysicalEquipment newBreaker = new PhysicalEquipment (Breakers[i].rdfID,Breakers[i].name,"Breaker",Breakers[i].isBus,Breakers[i].terminal1,Breakers[i].CN1,Breakers[i].terminal2,Breakers[i].CN2); //Create a new object.
			PhysicalEquipmentList.add(newBreaker); // Adding it to the list.;
		}
		for(int i=0; i<(EnergyConsumers.length); i++){
			PhysicalEquipment newEnergyConsumer = new PhysicalEquipment (EnergyConsumers[i].rdfID,EnergyConsumers[i].name,"EnergyConsumer",EnergyConsumers[i].isBus,EnergyConsumers[i].terminal1,EnergyConsumers[i].CN1,EnergyConsumers[i].terminal2,EnergyConsumers[i].CN2); //Create a new object.
			PhysicalEquipmentList.add(newEnergyConsumer); // Adding it to the list.;
			lgsList.add(newEnergyConsumer); // Adding it to the list.;
		}
		for(int i=0; i<(SynchronousMachines.length); i++){
			PhysicalEquipment newSynchronousMachine = new PhysicalEquipment (SynchronousMachines[i].rdfID,SynchronousMachines[i].name,"SynchronousMachine",SynchronousMachines[i].isBus,SynchronousMachines[i].terminal1,SynchronousMachines[i].CN1,SynchronousMachines[i].terminal2,SynchronousMachines[i].CN2); //Create a new object.
			PhysicalEquipmentList.add(newSynchronousMachine); // Adding it to the list.;
			lgsList.add(newSynchronousMachine); // Adding it to the list.;
		}
		for(int i=0; i<(PowerTransformers.length); i++){
			PhysicalEquipment newPowerTransformer = new PhysicalEquipment (PowerTransformers[i].rdfID,PowerTransformers[i].name,"PowerTransformer",PowerTransformers[i].isBus,PowerTransformers[i].terminal1,PowerTransformers[i].CN1,PowerTransformers[i].terminal2,PowerTransformers[i].CN2); //Create a new object.
			PhysicalEquipmentList.add(newPowerTransformer); // Adding it to the list.;
		}
		for(int i=0; i<(ACLineSegments.length); i++){
			PhysicalEquipment newACLineSegment = new PhysicalEquipment (ACLineSegments[i].rdfID,ACLineSegments[i].name,"ACLineSegment",ACLineSegments[i].isBus,ACLineSegments[i].terminal1,ACLineSegments[i].CN1,ACLineSegments[i].terminal2,ACLineSegments[i].CN2); //Create a new object.
			PhysicalEquipmentList.add(newACLineSegment); // Adding it to the list.;
		}
		for(int i=0; i<(LinearShuntCompensators.length); i++){
			PhysicalEquipment newLinearShuntCompensator = new PhysicalEquipment (LinearShuntCompensators[i].rdfID,LinearShuntCompensators[i].name,"LinearShuntCompensator",LinearShuntCompensators[i].isBus,LinearShuntCompensators[i].terminal1,LinearShuntCompensators[i].CN1,LinearShuntCompensators[i].terminal2,LinearShuntCompensators[i].CN2); //Create a new object.
			PhysicalEquipmentList.add(newLinearShuntCompensator); // Adding it to the list.;
			lgsList.add(newLinearShuntCompensator); // Adding it to the list.;
		}

		System.out.println("PhysicalEqipmentList has " + PhysicalEquipmentList.size() + " elements.");
		System.out.println("PhysicalEqipmentList has " + lgsList.size() + " elements.");


		ArrayList<String> BusbarCNs = new ArrayList<String>();
		for (int i=0; i<BusbarSections.length; i++) {
			for (int p=0; p<lgsList.size(); p++) {
				if (lgsList.get(p).CN1.equals(BusbarSections[i].CN1)) {
					BusbarCNs.add(BusbarSections[i].CN1);
					break;
				}
			}			
		}

		System.out.println("Found " + BusbarCNs.size() + " Buses.");

		// Below I'm creating a nested ArrayList for storing equipment that belongs to a certain bus (i.e. is not part of a branch)
		ArrayList<ArrayList<String>> BusEquipment = new ArrayList<ArrayList<String>>();
		for (int i=0; i<BusbarSections.length; i++) {
			BusEquipment.add(new ArrayList<String>());
			BusEquipment.get(i).add(String.valueOf(i));
			BusEquipment.get(i).add(BusbarSections[i].rdfID);
			BusEquipment.get(i).add(BusbarSections[i].CN1);
			for (int j=0; j<PhysicalEquipmentList.size(); j++) {
				if (Boolean.valueOf(PhysicalEquipmentList.get(j).isBus)){
					if (BusbarSections[i].CN1.equals(PhysicalEquipmentList.get(j).CN1)) {
						BusEquipment.get(i).add(PhysicalEquipmentList.get(j).rdfID);
						PhysicalEquipmentList.remove(j);
						System.out.println("Added an element to BusEquipment and removed this element from PhysicalEquipmentList");
					} // end of CN comparison
				} // end of checking if isBus
			} // end of iterating through PhyscialEq.
		} // end of outer for
		System.out.println("Created " + BusEquipment.size() + " tables containing bus equipment for every bus.");

		/*for(int i = 0; i<PhysicalEquipmentList.size(); i++){
			System.out.println(PhysicalEquipmentList.get(i).type);	
		}*/

		System.out.println("PhysicalEqipmentList has now " + PhysicalEquipmentList.size() + " elements.");






		// Below I'm creating a nested ArrayList for storing equipment that belongs to a certain branch (i.e. is part of a branch and not a bus)
		ArrayList<ArrayList<String>> BranchEquipment = new ArrayList<ArrayList<String>>();
		// Below I'm creating an ArrayList for storing CNs that belong to a given bus
		ArrayList<String> sameCN = new ArrayList<String>();

		String nextCN = null;
		String previousCN = null;
		int branchNum = 0;
		int iteration=0;
		String fromBus=null;
		String toBus=null;
		for (int i=0; i<BusbarCNs.size(); i++) { // for every Busbar

			System.out.println("\nI'm in Busbar " + i);

			fromBus = String.valueOf(i);
			nextCN = BusbarCNs.get(i);

			for (int m=0; m<PhysicalEquipmentList.size(); m++) { // for every PhysEq.
				if (PhysicalEquipmentList.get(m).CN1.equals(BusbarCNs.get(i)) || PhysicalEquipmentList.get(m).CN2.equals(BusbarCNs.get(i))) { // if either CN1 or CN2 of PhysEq. is equal to the busbar CN
					sameCN.add(PhysicalEquipmentList.get(m).rdfID);
				} // end of if
			} // end of inner for

			System.out.println("\nFound " + sameCN.size() + " PhysEq elements directly connected to Busbar " + i);

			for (int j=0; j<sameCN.size(); j++) {
				BranchEquipment.add(new ArrayList<String>()); // for every new branch, create a sub-array in the BranchEq. arrayList

				System.out.println("\nCreated Branch number " + branchNum);

				System.out.println("Starting iterating through the PhysicalEquipmentList");

				while ( (!BusbarCNs.contains(nextCN) || nextCN.equals(BusbarCNs.get(i))) && iteration<20) {
					previousCN = nextCN;

					for (int k=0; k<PhysicalEquipmentList.size(); k++) {
						if ( ( PhysicalEquipmentList.get(k).CN1.equals(previousCN) || PhysicalEquipmentList.get(k).CN2.equals(previousCN) ) && ( !sameCN.contains(PhysicalEquipmentList.get(k).rdfID) || PhysicalEquipmentList.get(k).rdfID.equals(sameCN.get(j)) ) ) {
							BranchEquipment.get(branchNum).add(PhysicalEquipmentList.get(k).rdfID);

							if (!PhysicalEquipmentList.get(k).CN1.equals(previousCN)) {
								nextCN = PhysicalEquipmentList.get(k).CN1;
							} else {
								nextCN = PhysicalEquipmentList.get(k).CN2;
							}
							PhysicalEquipmentList.remove(k);

							System.out.println("Added one element to branch " + branchNum + " and removed this element from PhysicalEquipmentList");

						} // end of conditional if
					} // end of inner-inner for (iterating through all PhysEq elements)
					iteration++;
				} // end of while

				for (int p=0; p<BusbarCNs.size(); p++) { // iterating through Busbars to find which bus is the toBus

					if (BusbarCNs.get(p).equals(nextCN)) {
						toBus = String.valueOf(p);
					}
				}

				BranchEquipment.get(branchNum).add(fromBus);
				BranchEquipment.get(branchNum).add(toBus);
				System.out.println("Branch from bus " + fromBus + " to bus " + toBus + " completed.");

				System.out.println("\nPhysicalEqipmentList has now " + PhysicalEquipmentList.size() + " elements.");

				nextCN = BusbarCNs.get(i);
				System.out.println("If more branches, I'll start again from " + nextCN);
				
				for (int o=0; o<BranchEquipment.get(j).size(); o++ ) {
					for (int breakerNum=0; breakerNum<Breakers.length; breakerNum++) {
						if ( BranchEquipment.get(j).get(o).equals(Breakers[breakerNum].rdfID) ) {
							if (Breakers[breakerNum].state) { // if breaker is open
								BranchEquipment.remove(j);
								System.out.println("Found an open breaker! Deleting the branch...");
							}
							System.out.println("Found a breaker that is closed.");
						} // and of if ac line in the system is the same as in the branch
					} // and of for every ac line in the system
				}
				
				branchNum++;
			} // end of inner for (iterating through all sameCN elements)

			sameCN.clear();
			System.out.println("Emptied the sameCN ArraList");


		} // end of outer for

		System.out.println("\nBusEquipment array is as follows:");
		for (int i=0; i<BusEquipment.size(); i++) {
			System.out.println("\n" + BusEquipment.get(i) + "\n");
		}
		System.out.println("\nBranchEquipment array is as follows:");
		for (int i=0; i<BranchEquipment.size(); i++) {
			System.out.println("\n" + BranchEquipment.get(i) + "\n");
		}






		String[][] Ybus = new String[BusbarCNs.size()][BusbarCNs.size()];

		for (int i=0; i<5; i++) { // rows
			for (int j=0; j<5; j++) { // columns
				if (i==j) {
					Ybus[i][j] = Diagonal(i,BranchEquipment,ACLineSegments,PowerTransformers);
				} else {
					Ybus[i][j] = nonDiagonal(i,j,BranchEquipment,ACLineSegments,PowerTransformers);
				}
			}
		}



		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = new String[BusbarCNs.size()]; // initializing an array for the buses
		for (int i=0; i<BusbarCNs.size(); i++) {
			columnNames[i] = "Bus " + (i+1);
		}
		//Object columnNames[] = { "Bus 1", "Bus 2", "Bus 3", "Bus 4", "Bus 5" };
		JTable table = new JTable(Ybus, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(1800, 200);
		frame.setTitle("Y-matrix");
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
			String tableName = "Ybus";
			String[] columnsArray = new String[]{
					"Number VARCHAR(255)",
					"Bus_1 VARCHAR(255)",
					"Bus_2 VARCHAR(255)",
					"Bus_3 VARCHAR(255)",
					"Bus_4 VARCHAR(255)",
					"Bus_5 VARCHAR(255)"};
			String primaryKey = "Number";
			String sql_drop = "DROP TABLE IF EXISTS " + tableName + ";";
			System.out.println(sql_drop);
			stmt.executeUpdate(sql_drop);
			String sql_table = SQLdatabase.formTableStatement(tableName,columnsArray,primaryKey);
			stmt.executeUpdate(sql_table);
			System.out.println("Created table in given database...");		    
			// INSERTING RECORDS
			System.out.println("Inserting records into tables...");
			for (int i=0; i<5; i++){
				System.out.println("INSERT INTO " + tableName + " " + "VALUES ('" + i + "', '" + Ybus[i][0] + "', '" + Ybus[i][1] + "', '" + Ybus[i][2] + "', '" + Ybus[i][3] + "', '" + Ybus[i][4] + "')");
				String sql_records = "INSERT INTO " + tableName + " " + "VALUES ('" + i + "', '" + Ybus[i][0] + "', '" + Ybus[i][1] + "', '" + Ybus[i][2] + "', '" + Ybus[i][3] + "', '" + Ybus[i][4] + "')";
				stmt.executeUpdate(sql_records);	
			}


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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		System.out.println("\nEverything executed correctly :)");

	} // end of main(String[] args)

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// METHODS

	//DIAGONAL
	public static String Diagonal(int row, ArrayList<ArrayList<String>> BranchEquipment, ACLineSegment ACLineSegments[], PowerTransformer PowerTransformers[]){

		Complex diagonalElement = new Complex(0, 0);

		for (int i=0; i<BranchEquipment.size(); i++) {
			int fromBus = Integer.valueOf(BranchEquipment.get(i).get( BranchEquipment.get(i).size()-2 ) );
			int toBus = Integer.valueOf(BranchEquipment.get(i).get( BranchEquipment.get(i).size()-1 ) );
			if ( fromBus == row || toBus == row ) { // if we have a branch for that diagonal element
				for (int j=0; j<( BranchEquipment.get(i).size()-2 ); j++) {
					for (int lineNum=0; lineNum<ACLineSegments.length; lineNum++) {
						if ( BranchEquipment.get(i).get(j).equals(ACLineSegments[lineNum].rdfID) ) {
							diagonalElement = diagonalElement.plus( ACLineSegments[lineNum].getZpu() ); // sum the admittance
							diagonalElement = diagonalElement.plus( ACLineSegments[lineNum].getYpu() ); // sum the admittance
							System.out.println("From bus " + fromBus + " to bus " + toBus + " found an ac line!");
						} // and of if ac line in the system is the same as in the branch
					} // and of for every ac line in the system
					for (int powtranNum=0; powtranNum<PowerTransformers.length; powtranNum++) {
						if ( BranchEquipment.get(i).get(j).equals(PowerTransformers[powtranNum].rdfID) ) {
							diagonalElement = diagonalElement.plus( PowerTransformers[powtranNum].getZpu() ); // sum the admittance
							diagonalElement = diagonalElement.plus( PowerTransformers[powtranNum].getYpu() ); // sum the admittance
							System.out.println("From bus " + fromBus + " to bus " + toBus + " found a transformer!");
						} // and of if transformer in the system is the same as in the branch
					} // and of for every transformer in the system
				} // end of for every element of this branch (that satisfies condition)
			} // end of if branch satisfies conditions
		} // end of for every branch
		return diagonalElement.toString();
	}

	//NONDIAGONAL
	public static String nonDiagonal(int row, int column, ArrayList<ArrayList<String>> BranchEquipment, ACLineSegment ACLineSegments[], PowerTransformer PowerTransformers[]){

		Complex nondiagonalElement = new Complex(0, 0);
		for (int i=0; i<BranchEquipment.size(); i++) {
			int fromBus = Integer.valueOf(BranchEquipment.get(i).get( BranchEquipment.get(i).size()-2 ) );
			int toBus = Integer.valueOf(BranchEquipment.get(i).get( BranchEquipment.get(i).size()-1 ) );
			if ( (fromBus == row && toBus == column) || (fromBus == column && toBus == row) ) {
				for (int j=0; j<( BranchEquipment.get(i).size()-2 ); j++) {
					for (int lineNum=0; lineNum<ACLineSegments.length; lineNum++) {
						if ( BranchEquipment.get(i).get(j).equals(ACLineSegments[lineNum].rdfID) ) {
							nondiagonalElement = nondiagonalElement.minus( ACLineSegments[lineNum].getZpu() ); // sum the admittance
						} // and of if ac line in the system is the same as in the branch
					} // and of for every ac line in the system
					for (int powtranNum=0; powtranNum<PowerTransformers.length; powtranNum++) {
						if ( BranchEquipment.get(i).get(j).equals(PowerTransformers[powtranNum].rdfID) ) {
							nondiagonalElement = nondiagonalElement.minus( PowerTransformers[powtranNum].getZpu() ); // sum the admittance
						} // and of if transformer in the system is the same as in the branch
					} // and of for every transformer in the system
				} // end of for every element of this branch (that satisfies condition)
			} // end of if branch satisfies conditions (so the branch between the two selected buses does exist)
		} // end of for every branch
		return nondiagonalElement.toString();
	}









} // end of public class Main
