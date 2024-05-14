package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LancementPartie extends JPanel implements ActionListener{
	//Panel
	private JPanel panelGlobal;
	private JPanel panelContenu;

	//Label
    private JLabel titre;
	private JLabel lblJoueur1;
	private JLabel lblJoueur2 ;
	private JLabel lblLargeurGrille;
	private JLabel lblLongueurGrille; 
	private JLabel affichage;

    //Jtf
    private JTextField jtfJoueur1;
    private JTextField jtfJoueur2;
    private JTextField jtfLargeurGrille;
    private JTextField jtfLongueurGrille;
    
    //Button
    private JButton btnValider;
	public LancementPartie() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 10));
        
		//Label
		titre = new JLabel("Saisir les informations de la partie");
		
		panelGlobal.add(titre, BorderLayout.CENTER);
		
		lblJoueur1 = new JLabel("Joueur 1");
		panelGlobal.add(lblJoueur1, BorderLayout.CENTER);
		jtfJoueur1 = new JTextField("");
		panelGlobal.add(jtfJoueur1, BorderLayout.CENTER);
		
		lblJoueur2 = new JLabel("Joueur 2");
		panelGlobal.add(lblJoueur2, BorderLayout.CENTER);
		jtfJoueur2 = new JTextField("");
		panelGlobal.add(jtfJoueur2, BorderLayout.CENTER);
		
		
		
		//button
        btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage);
    }
	public void actionPerformed(ActionEvent evenement) {
	    if (evenement.getSource() == btnValider) {
	        JPanel choixGrillePanel = new ChoixGrille().getMonPanelGlobal();
	        panelGlobal.removeAll(); // Supprimez le contenu existant
	        panelGlobal.setLayout(new BorderLayout()); // Définissez le gestionnaire de disposition
	        panelGlobal.add(choixGrillePanel, BorderLayout.CENTER); // Ajoutez le panneau de ChoixGrille au centre

	        panelGlobal.revalidate(); // Rafraîchissez le panneau pour refléter les modifications
	        panelGlobal.repaint(); // Redessinez le panneau
	    }
	}

	
	public JPanel getMonPanelGlobal() {
	    return panelGlobal;
	}

	
}