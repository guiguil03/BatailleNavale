package batailleNavale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoixGrilleOrdi extends JPanel implements ActionListener {
	Case[][]grilleCases;
	Case[][]grilleCasesO;//Ordi
	PorteAvions porteAvions= new PorteAvions();
	Torpilleur torpilleur= new Torpilleur();
	ContreTorpilleur cTorpilleurs= new ContreTorpilleur();
	private int nombreDePorteAvions=2;
    private int nombreDeTorpilleurs=2;
    private int nombreDeContreTorpilleur=3;
    public int length;

    public int getNombreDePorteAvions() {
    	return nombreDePorteAvions;
    }
    public int getNombreDeTorpilleurs() {
    	return nombreDeTorpilleurs;
    }
    public int getNombreDeContreTorpilleur() {
    	return nombreDeContreTorpilleur;
    }
	private JPanel panelGlobal;
	private JPanel panelContenu;
	private JPanel choixGrille;

	private JLabel titre;
	private JLabel lblId;
	private JLabel lblLibelle;
	private JLabel lblLargeur;
	private JLabel lblLongueur;
	private JLabel lblType;
	private JLabel affichage;
	private JLabel Joueur1;

	//Jtf
	private JTextField jtfJoueur1;
	private JTextField jtfJoueur2;
	private JTextField jtfLargeurGrille;
	private JTextField jtfLongueurGrille;

	private JButton automatique;
	private JButton manuel;
	private JButton btnValider;
	private JButton isGood;
	private JButton notGood;

	public ChoixGrilleOrdi() {
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));

		//button
		automatique = new JButton("Initialiser automatiquement");
		automatique.addActionListener(this);
		panelGlobal.add(automatique);

		manuel = new JButton("Initialiser par soi-même");
		manuel.addActionListener(this);
		panelGlobal.add(manuel);

		// Ajouter les champs de saisie pour les dimensions de la grille
		lblLargeur = new JLabel("Saisir nombre de lignes");
		panelGlobal.add(lblLargeur);
		jtfLargeurGrille = new JTextField("");
		panelGlobal.add(jtfLargeurGrille);
		lblLongueur = new JLabel("Saisir nombre de colonnes");
		panelGlobal.add(lblLongueur);
		jtfLongueurGrille = new JTextField("");
		panelGlobal.add(jtfLongueurGrille);

		//button
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);

		affichage = new JLabel("");
		panelGlobal.add(affichage);
	}
	public void initialisationGrille(Case [][] grilleCases, int tailleX, int tailleY) {
		Grille grille= new Grille(grilleCases);
			
			for (int i = 0; i < grille.getNombreDePorteAvions(); i++) {
			    PorteAvions porteAvions = new PorteAvions(); // Instanciez un nouveau porte-avions
			    porteAvions.genererPositionAleatoire(grilleCases, tailleX, tailleY); // Générez sa position aléatoire
			    grille.ajouterNavire(grilleCases, porteAvions); // Ajoutez-le à la grille
			}
			for (int i = 0; i < grille.getNombreDeTorpilleurs(); i++) {
				Torpilleur torpilleur= new Torpilleur();
				torpilleur.genererPositionAleatoire(grilleCases, tailleX, tailleY); // Générez sa position aléatoire
				grille.ajouterNavire(grilleCases, torpilleur); // Ajoutez-le à la grille
			}
			for (int i = 0; i < grille.getNombreDeContreTorpilleur(); i++) {
				ContreTorpilleur cTorpilleurs= new ContreTorpilleur();
				cTorpilleurs.genererPositionAleatoire(grilleCases, tailleX, tailleY); // Générez sa position aléatoire
				grille.ajouterNavire(grilleCases, cTorpilleurs); // Ajoutez-le à la grille
			}
			
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == automatique) {
			int tailleX = Integer.parseInt(jtfLargeurGrille.getText());
			int tailleY = Integer.parseInt(jtfLongueurGrille.getText());

			Case[][] grilleCases = new Case[tailleX][tailleY];
			Case[][] grilleCasesO = new Case[tailleX][tailleY];
			for (int i = 0; i < tailleX; i++) {
				for (int j = 0; j < tailleY; j++) {
					grilleCases[i][j] = new Case();
					grilleCasesO[i][j] = new Case();
				}
			}
			choixGrille = new JPanel();
	        choixGrille.setLayout(new BorderLayout());
	        Joueur1= new JLabel("Grille du joueur 1");
	        

	        // Créer les boutons
	        isGood = new JButton("Ok");
	        notGood = new JButton("Non, refaire");

	        

	        choixGrille.add(isGood, BorderLayout.WEST);
	        choixGrille.add(notGood, BorderLayout.EAST);
	        choixGrille.add(Joueur1,BorderLayout.AFTER_LAST_LINE);

			
			
			Grille grille= new Grille(grilleCases);
			Grille grille0= new Grille(grilleCasesO);
			initialisationGrille(grilleCases, tailleX,tailleY);
			initialisationGrille(grilleCasesO, tailleX,tailleY);
			// Créer une instance d'AffichageGrille avec la grille
			AffichageGrilleOrdiV2 affichageGrille = new AffichageGrilleOrdiV2(grilleCases,grilleCasesO);

			// Obtenez le JPanel global de AffichageGrille
			JPanel affichageGrillePanel = affichageGrille.getMonPanelGlobal(); 
			
			panelGlobal.removeAll(); 
			panelGlobal.setLayout(new BorderLayout()); 
			panelGlobal.add(affichageGrillePanel, BorderLayout.CENTER); 
			panelGlobal.add(choixGrille,BorderLayout.SOUTH);
			panelGlobal.setLayout(new GridBagLayout()); 
			panelGlobal.add(affichageGrillePanel, new GridBagConstraints()); 

			panelGlobal.revalidate(); 
			panelGlobal.repaint();
			isGood.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	        
	            	affichageGrille.modifierAffichageDoubleGrille();
	            	JPanel affichageGrillePanel1 = affichageGrille.getMonPanelGlobal(); 
	    			panelGlobal.removeAll();
	    			panelGlobal.setBackground(Color.blue);
	    			panelGlobal.setLayout(new BorderLayout()); 
	    			panelGlobal.add(affichageGrillePanel1, BorderLayout.CENTER); 
	    			panelGlobal.add(choixGrille,BorderLayout.SOUTH);
	    			panelGlobal.setLayout(new GridBagLayout()); 
	    			panelGlobal.add(affichageGrillePanel1, new GridBagConstraints()); 

	    			panelGlobal.revalidate(); 
	    			panelGlobal.repaint();
	            }
	            
	        });

	        notGood.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	grille.viderGrille(grilleCases,tailleX,tailleY);
	            	panelGlobal.removeAll();
	    			initialisationGrille(grilleCases, tailleX,tailleY);
	    			AffichageGrilleOrdiV2 affichageGrille = new AffichageGrilleOrdiV2(grilleCases, grilleCasesO);

	    			// Obtenez le JPanel global de AffichageGrille
	    			JPanel affichageGrillePanel = affichageGrille.getMonPanelGlobal();
	    			
	    			panelGlobal.setLayout(new BorderLayout()); 
	    			panelGlobal.add(affichageGrillePanel, BorderLayout.CENTER); // Ajouter le composant au centre
	    			panelGlobal.add(choixGrille,BorderLayout.SOUTH);
	    			panelGlobal.setLayout(new GridBagLayout()); // Utilisez GridBagLayout pour centrer le composant
	    			panelGlobal.add(affichageGrillePanel, new GridBagConstraints()); // Ajouter le composant au centre
	    			panelGlobal.revalidate(); 
	    			panelGlobal.repaint(); // Redessinez le panneau
	    			panelGlobal.setBackground(Color.red);
	            }
	        });
			
		}
	}

	public JPanel getMonPanelGlobal() {
		return panelGlobal;
	}
}
