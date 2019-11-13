package dataBase_application;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class updateTheaterCapacity extends BasicSelectQuery{
	private static final String USERNAME = "root";
	private static final String PASSWORD ="matt6ink";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/database";
	private static String theaterIdForDatabase=null;
	private static int realnewSeatingCap=0;
	 

	 static void createAndShowGUIupdateTheaterCapacity() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Update Theater Capacity");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        JLabel emptyLabel = new JLabel("");
	        emptyLabel.setPreferredSize(new Dimension(500, 500));
	        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	        //main panel
	        JPanel mainPanel=new JPanel();
	        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	        frame.add(mainPanel);
	        //theaterId
	        JPanel theaterIdpanel=new JPanel();
	        JLabel theaterIdLabel= new JLabel("TheaterID:");
	        theaterIdpanel.add(theaterIdLabel);
	        JTextField theaterId = new JTextField(20);
	        theaterIdpanel.add(theaterId);
	        mainPanel.add(theaterIdpanel);
	        theaterId.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	theaterIdForDatabase=theaterId.getText();
	            	System.out.println(theaterIdForDatabase);
	            }
	        });
	        //newSeatingCap
	        JPanel newSeatingCappanel=new JPanel();
	        JLabel newSeatingCapLabel= new JLabel("New Seating Capacity:");
	        newSeatingCappanel.add(newSeatingCapLabel);
	        JTextField newSeatingCap = new JTextField(20);
	        newSeatingCappanel.add(newSeatingCap);
	        mainPanel.add(newSeatingCappanel);
	        newSeatingCap.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	String newSeatingCapForDatabase=newSeatingCap.getText();
	            	realnewSeatingCap=Integer.parseInt(newSeatingCapForDatabase);
	            	System.out.println(realnewSeatingCap);
	            	Connection conn1 = null;
	    	        CallableStatement myStmt=null;
	    	 
	    	        try {
	    	            // connection
	    	 
	    	            conn1 = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	    	            if (conn1 != null) {
	    	                System.out.println("Connected to the database!");
	    	             
	    	            }
	    	            myStmt=conn1.prepareCall("{call updateTheaterCapacity(?, ?)}");
	    	            
	    	            myStmt.setString(1, theaterIdForDatabase);
	    	            myStmt.setInt(2, realnewSeatingCap);
	    	        
	    	            myStmt.execute();
	    	 
	    	           
	    	        } catch (SQLException ex) {
	    	            System.out.println("An error occurred. Maybe user/password is invalid :(");
	    	            ex.printStackTrace();
	    	        }
	            }
	        });
	 }
	        
	 
	 
	             
}
	        
	        
	 

