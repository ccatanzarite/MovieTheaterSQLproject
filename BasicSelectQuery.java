package dataBase_application;

import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.PanelUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.peer.PanelPeer;
import java.awt.event.ActionEvent;
public class BasicSelectQuery{
	private static final String USERNAME = "root";
	private static final String PASSWORD ="matt6ink";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/database";
	private static String columnForDatabase=null;
	private static String tableForDatabase=null;
	 
	 public static void createAndShowGUIbasicSelectQuery() {
		 	
	        //Create and set up the window.
	        JFrame frame = new JFrame("Run Basic Query");
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
	        
	        JPanel columnToBeSelectedpanel=new JPanel();
	        JLabel columnToBeSelectedLabel= new JLabel("Column to Be selected");
	        columnToBeSelectedpanel.add(columnToBeSelectedLabel);
	        JTextField columnToBeSelected = new JTextField(20);
	        columnToBeSelectedpanel.add(columnToBeSelected);
	        mainPanel.add(columnToBeSelectedpanel);
	        columnToBeSelected.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	columnForDatabase=columnToBeSelected.getText();
	            	System.out.println(columnForDatabase);
	            }
	        });
	        JPanel tableToBeSelectedpanel=new JPanel();
	        JLabel tableToBeSelectedLabel= new JLabel("Table to Select From");
	        tableToBeSelectedpanel.add(tableToBeSelectedLabel);
	        JTextField tableToBeSelected = new JTextField(20);
	        tableToBeSelectedpanel.add(tableToBeSelected);
	        mainPanel.add(tableToBeSelectedpanel);
	        tableToBeSelected.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	tableForDatabase=tableToBeSelected.getText();
	            	System.out.println(tableForDatabase);
	            	
	            	Connection conn1 = null;
	    	        CallableStatement myStmt=null;
	    	 
	    	        try {
	    	            // connection
	    	 
	    	            conn1 = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	    	            if (conn1 != null) {
	    	                System.out.println("Connected to the database!");
	    	             
	    	            }
	    	            myStmt=conn1.prepareCall("{call basicSelectQuery(?, ?)}");
	    	            
	    	            myStmt.setString(1, columnForDatabase);
	    	            myStmt.setString(2, tableForDatabase);
	    	        
	    	            myStmt.execute();
	    	 
	    	           
	    	        } catch (SQLException ex) {
	    	            System.out.println("An error occurred. Maybe user/password is invalid :(");
	    	            ex.printStackTrace();
	    	        }
	            }
	        });
	        
}}