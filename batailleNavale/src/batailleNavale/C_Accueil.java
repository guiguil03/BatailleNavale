package batailleNavale;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C_Accueil extends JFrame implements ActionListener{
    //Panel
    private JPanel panelButton;
    //Button
    private JButton btnConnexion;
    
    public C_Accueil() {
    	this.setTitle("Bataille Navale");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 700);
        this.setResizable(true);
        
       
        panelButton = new JPanel();
        
        //button
        btnConnexion = new JButton ("Jouer");
        btnConnexion.setBackground(Color.PINK);
        btnConnexion.addActionListener(this);
        panelButton.add(btnConnexion);
        this.getContentPane().add(panelButton, BorderLayout.SOUTH);
        
        ImageIcon imgTP = new ImageIcon("./src/batailleNavale/battleship.jpg");
        JLabel imageTP = new JLabel(imgTP, JLabel.CENTER);
        imageTP.setIcon(imgTP);
        this.getContentPane().add(imageTP);

        this.setAlwaysOnTop(true);
        this.getRootPane().setDefaultButton(btnConnexion);
        this.setVisible(true);
    }
    
    class ActionListe implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
            
    	}
    }
    public void actionPerformed ( ActionEvent evenement) {
        if(evenement.getSource() == btnConnexion) {
        	
        }
            
    }
	
}