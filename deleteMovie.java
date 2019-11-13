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
public class deleteMovie extends updateTheaterCapacity {
	private static final String USERNAME = "root";
	private static final String PASSWORD ="matt6ink";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/database";
	private static String oldMovieNameForDatabase;
	
	 public static void main(String[] args) {
		 
	        // creates three different Connection objects
	        Connection conn1 = null;
	 
	        try {
	            // connection
	 
	            conn1 = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	            if (conn1 != null) {
	                System.out.println("Connected to the database!");
	            }
	 
	           
	        } catch (SQLException ex) {
	            System.out.println("An error occurred. Maybe user/password is invalid :(");
	            ex.printStackTrace();
	        }
	    }
	 static void createAndShowGUIDeleteMovie() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Delete An Old Movie");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        JLabel emptyLabel = new JLabel("");
	        emptyLabel.setPreferredSize(new Dimension(500, 500));
	        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	      //textfield area
	        JPanel mainPanel=new JPanel();
	        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	        frame.add(mainPanel);
	        //newMovieID
	        
	        JPanel deleteOldMoviepanel=new JPanel();
	        JLabel deleteOldMovieLabel= new JLabel("Name of Movie to Delete:");
	        deleteOldMoviepanel.add(deleteOldMovieLabel);
	        JTextField oldMovieName = new JTextField(20);
	        deleteOldMoviepanel.add(oldMovieName);
	        mainPanel.add(deleteOldMoviepanel);
	        oldMovieName.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	oldMovieNameForDatabase=oldMovieName.getText();
	            	System.out.println(oldMovieNameForDatabase);
	            	Connection conn1 = null;
	    	        CallableStatement myStmt=null;
	    	 
	    	        try {
	    	            // connection
	    	 
	    	            conn1 = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	    	            if (conn1 != null) {
	    	                System.out.println("Connected to the database!");
	    	             
	    	            }
	    	            myStmt=conn1.prepareCall("{call deleteMovie(?)}");
	    	            
	    	            myStmt.setString(1, oldMovieNameForDatabase);
	    	            myStmt.execute();
	    	 
	    	           
	    	        } catch (SQLException ex) {
	    	            System.out.println("An error occurred. Maybe user/password is invalid :(");
	    	            ex.printStackTrace();
	    	        }
	            }
	        });
	 }


}