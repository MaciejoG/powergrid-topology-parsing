/*import java.util.ArrayList;


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
						} // and of if ac line in the system is the same as in the branch
					} // and of for every ac line in the system
					for (int powtranNum=0; powtranNum<PowerTransformers.length; powtranNum++) {
						if ( BranchEquipment.get(i).get(j).equals(PowerTransformers[powtranNum].rdfID) ) {
							diagonalElement = diagonalElement.plus( PowerTransformers[powtranNum].getZpu() ); // sum the admittance
							diagonalElement = diagonalElement.plus( PowerTransformers[powtranNum].getYpu() ); // sum the admittance
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
	}*/