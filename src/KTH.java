
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

public class KTH extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KTH frame = new KTH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public KTH() {
		connection= SQLGui.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 539);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Import EQ file");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
					
					
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Upload successful");
					
				}
			}
		});
		btnNewButton.setBounds(171, 72, 123, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Import SSH file");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(171, 117, 123, 25);
		contentPane.add(btnNewButton_1);
		
		JButton ButtonLoadY = new JButton("Calculate Y-bus");
		ButtonLoadY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query= "select * from powersystem.ybus";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		ButtonLoadY.setBackground(Color.CYAN);
		ButtonLoadY.setBounds(171, 164, 123, 25);
		contentPane.add(ButtonLoadY);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/KTH.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-66, 56, 199, 145);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 287, 319, 178);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Y-bus matrix");
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setBounds(168, 258, 78, 16);
		contentPane.add(lblNewLabel_1);
	}
}
