package dataBase_application;

import javax.swing.JFrame;

import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainScreen extends addNewMovie {
	/**
     *My Main Screen Class
     */
    private static void createAndShowGUIMainScreen() {
        //Create and set up the frame
        JFrame frame = new JFrame("Database Application");
        
        //run queries button
        JButton queries = new JButton();
        queries.setSize(500,500);
        queries.setVisible(true);
        queries.setText("Queries");
        frame.setLayout(new FlowLayout());
        frame.add(queries);
        queries.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Call my other frames
            	createAndShowGUIbasicSelectQuery();
            }
        });
        
        
        //add records button
        JButton addNewMovie = new JButton();
        addNewMovie.setSize(500,500);
        addNewMovie.setVisible(true);
        addNewMovie.setText("Add New Movie");
        frame.setLayout(new FlowLayout());
        frame.add(addNewMovie);
        addNewMovie.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            	createAndShowGUIaddNewMovie();
            }
        });
        
        //delete Records button
        JButton deleteMovie = new JButton();
        deleteMovie.setSize(500,500);
        deleteMovie.setVisible(true);
        deleteMovie.setText("Delete Old Movie");
        frame.setLayout(new FlowLayout());
        frame.add(deleteMovie);
        deleteMovie.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               
            	createAndShowGUIDeleteMovie();
            }
        });
        
        //update Records button
        JButton updateTheaterCapacity = new JButton();
        updateTheaterCapacity.setSize(500,500);
        updateTheaterCapacity.setVisible(true);
        updateTheaterCapacity.setText("Update Theater Capacity");
        frame.setLayout(new FlowLayout());
        frame.add(updateTheaterCapacity);
        updateTheaterCapacity.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            	createAndShowGUIupdateTheaterCapacity();
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(200, 250));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
    }
 
    public static void main(String[] args) {
        //main method
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUIMainScreen();
            }
        });
    }
	
}
	
		

