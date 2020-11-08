

import java.awt.EventQueue;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = SQLGui.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(63, 61, 71, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(63, 104, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(146, 58, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(146, 101, 116, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="select * from powersystem.login where name=? and password=?";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1, textField.getText() );
					pst.setString(2, passwordField.getText() );
		
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()){
					 count=count+1;
					 
					}
					if(count==1){
						
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						frame.dispose();
						KTH kth= new KTH();
						kth.setVisible(true);
					}
					else if(count>1){
						
						JOptionPane.showMessageDialog(null, "Duplicate username and password is correct");
					}
					else{
						JOptionPane.showMessageDialog(null, "Username and password is not correct");
					}
					
				
				rs.close();
				pst.close();
			  }catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Login successful");
					
				}
			
					
				
			
			
			
			}
		});
		btnNewButton.setBounds(156, 154, 97, 25);
		frame.getContentPane().add(btnNewButton);
	}

}
