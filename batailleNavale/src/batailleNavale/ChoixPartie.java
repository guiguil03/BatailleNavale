package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;


import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChoixPartie extends JPanel implements ActionListener{
	//PanelJp
	private JPanel panelGlobal;
	private JPanel panelContenu;

	//Label
    private JLabel titre;
	private JLabel lblId;
	private JLabel lblLibelle;
	private JLabel lblLargeur;
	private JLabel lblLongueur;
	private JLabel lblType; 
	private JLabel affichage;

    //Jtf
    private JTextField jtfId;
    private JTextField jtfLibelle;
    private JTextField jtfLargeur;
    private JTextField jtfLongueur;
    private JTextField jtfType;
    
    //Button
    private JButton btnJoueur;
    private JButton btnOrdinateur;
	public ChoixPartie() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
		
		//button
		btnJoueur = new JButton ("Jouer contre un joueur");
		btnJoueur.addActionListener(this);
		panelGlobal.add(btnJoueur,BorderLayout.SOUTH);
		
		btnOrdinateur = new JButton ("Jouer contre un ordinateur");
		btnOrdinateur.addActionListener(this);
		panelGlobal.add(btnOrdinateur,BorderLayout.CENTER);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage,BorderLayout.CENTER);
    }
	public void actionPerformed ( ActionEvent evenement) {
		if (evenement.getSource() == btnJoueur) {
	        panelGlobal.removeAll(); // Supprime tous les composants du panelGlobal
	        panelGlobal.setLayout(new BorderLayout()); // Définit le gestionnaire de disposition
	        panelGlobal.revalidate(); // Rafraîchit le conteneur
	        panelGlobal.repaint();
	        JPanel lancementPanel = new LancementPartie().getMonPanelGlobal();
	        lancementPanel.setPreferredSize(new Dimension(6000, 4000)); // Définir la taille préférée
	        panelGlobal.add(lancementPanel, BorderLayout.CENTER); // Ajoute la nouvelle page*/
	    }
		//code Myrah
		else if (evenement.getSource() == btnOrdinateur) {
			panelGlobal.removeAll(); // Supprime tous les composants du panelGlobal
	        panelGlobal.setLayout(new BorderLayout()); // Définit le gestionnaire de disposition
	        panelGlobal.revalidate(); // Rafraîchit le conteneur
	        panelGlobal.repaint();
	        JPanel lancementPanel = new LancementPartieOrdi().getMonPanelGlobal();
	        lancementPanel.setPreferredSize(new Dimension(6000, 4000)); // Définir la taille préférée
	        panelGlobal.add(lancementPanel, BorderLayout.CENTER); // Ajoute la nouvelle page*/
			
		}
		//
    }
	
	public JPanel getMonPanelGlobal() {
	    return panelGlobal;
	}

	
}