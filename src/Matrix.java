
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class Matrix extends JFrame {

	public static void main(String[] args) {
	
	
		JFrame frame = new JFrame();
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    Object rowData[][] = { { "Y11", "Y12", "Y13" },
	    					   { "Y21", "Y22", "Y23" } ,
	    					   { "Y31", "Y32", "Y33" } ,
	        };
	    Object columnNames[] = { "Bus 1", "Bus 2", "Bus 3" };
	    JTable table = new JTable(rowData, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setSize(300, 120);
	    frame.setTitle("Y-matrix");
	    frame.setVisible(true);
        
	}

}
