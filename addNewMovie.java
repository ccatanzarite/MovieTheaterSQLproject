package dataBase_application;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.PanelUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.peer.PanelPeer;
import java.awt.event.ActionEvent;
public class addNewMovie extends deleteMovie{
	private static final String USERNAME = "root";
	private static final String PASSWORD ="matt6ink";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/database";
	private static String newMovieIdForDatabase=null;
	private static String newtimeSlotForDatabase=null;
	private static String newMovieNameForDatabase=null;
	private static double realnewPrice=0;
	private static String newTheaterIDForDatabase=null;
	 
	 public static void createAndShowGUIaddNewMovie() {
		 	
	        //Create and set up the window.
	        JFrame frame = new JFrame("Add a New Movie");
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
	        
	        JPanel newMovieIdpanel=new JPanel();
	        JLabel newMovieIdLabel= new JLabel("New MovieID");
	        newMovieIdpanel.add(newMovieIdLabel);
	        JTextField newMovieID = new JTextField(20);
	        newMovieIdpanel.add(newMovieID);
	        mainPanel.add(newMovieIdpanel);
	        newMovieID.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	newMovieIdForDatabase=newMovieID.getText();
	            	System.out.println(newMovieIdForDatabase);
	            }
	        });
	        //new time slot
	        JPanel newtimeSlotpanel=new JPanel();
	        JLabel newtimeSlotLabel= new JLabel("New Time Slot");
	        newtimeSlotpanel.add(newtimeSlotLabel);
	        JTextField newtimeSlot = new JTextField(20);
	        newtimeSlotpanel.add(newtimeSlot);
	        mainPanel.add(newtimeSlotpanel);
	        newtimeSlot.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	newtimeSlotForDatabase=newtimeSlot.getText();
	            	System.out.println(newtimeSlotForDatabase);
	            }
	        });
	      //new movieName
	        JPanel newMovienamepanel=new JPanel();
	        JLabel newMovienameLabel= new JLabel("New Movie Name");
	        newMovienamepanel.add(newMovienameLabel);
	        JTextField newMoviename = new JTextField(20);
	        newMovienamepanel.add(newMoviename);
	        mainPanel.add(newMovienamepanel);
	        newMoviename.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	newMovieNameForDatabase=newMoviename.getText();
	            	System.out.println(newMovieNameForDatabase);
	            }
	        });
	      //new price
	        JPanel newPricepanel=new JPanel();
	        JLabel newPriceLabel= new JLabel("New Price");
	        newPricepanel.add(newPriceLabel);
	        JTextField newPrice = new JTextField(20);
	        newPricepanel.add(newPrice);
	        mainPanel.add(newPricepanel);
	        newPrice.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	String newPriceForDatabase=newPrice.getText();
	            	realnewPrice = Double.parseDouble(newPriceForDatabase);
	            	System.out.println(realnewPrice);
	            }
	        });
	        //new theaterID
	        JPanel newtheaterIDpanel=new JPanel();
	        JLabel newtheaterIDLabel= new JLabel("New TheaterID");
	        newtheaterIDpanel.add(newtheaterIDLabel);
	        JTextField newtheaterID = new JTextField(20);
	        newtheaterIDpanel.add(newtheaterID);
	        mainPanel.add(newtheaterIDpanel);
	        newtheaterID.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	newTheaterIDForDatabase=newtheaterID.getText();
	            	System.out.println(newTheaterIDForDatabase);
	            	Connection conn1 = null;
	    	        CallableStatement myStmt=null;
	    	 
	    	        try {
	    	            // connection
	    	 
	    	            conn1 = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	    	            if (conn1 != null) {
	    	                System.out.println("Connected to the database!");
	    	             
	    	            }
	    	            myStmt=conn1.prepareCall("{call addNewMovie(?, ?, ?, ?, ?)}");
	    	            
	    	            myStmt.setString(1, newMovieIdForDatabase);
	    	            myStmt.setString(2, newtimeSlotForDatabase);
	    	            myStmt.setString(3, newMovieNameForDatabase);
	    	            myStmt.setDouble(4, realnewPrice);
	    	            myStmt.setString(5, newTheaterIDForDatabase);
	    	            myStmt.execute();
	    	 
	    	           
	    	        } catch (SQLException ex) {
	    	            System.out.println("An error occurred. Maybe user/password is invalid :(");
	    	            ex.printStackTrace();
	    	        }
	            }
	        });
	        
     
	 }
}
	 
	



