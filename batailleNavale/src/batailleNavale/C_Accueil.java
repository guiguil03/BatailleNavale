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
    private JPanel panelConnexion;
    private JPanel panelButton;
    //Label
    private JLabel lblLogin;
    private JLabel lblPassword;
    //Jtf
    private JTextField jtfLogin;
    private JPasswordField jtfPassword;
    //Button
    private JButton btnConnexion;
    //Barre de menu
    private JMenuBar menu;
    //Item des diff?rents menus

    //Pour la partie Responsable
    private JMenuItem ajouterMateriel;
    private JMenuItem supprimerMateriel;
    private JMenuItem afficherMateriel;
    private JMenuItem rechercherMateriel;
    private JMenuItem btnDeconnexion;
    
    private JMenuItem ajouterVehicule;

    //Pour la partie Visiteur
    private JMenuItem listeReservation;
    private JMenuItem emprunterMateriel;
    private JMenuItem userGestion;
    
    private Pattern p;
    private Matcher m;
    
    public C_Accueil() {
    	this.setTitle("GSB Mat");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 700);
        this.setResizable(true);
        
        //Panel
        panelConnexion = new JPanel();
        panelButton = new JPanel();
        //Label et Jtf
        lblLogin = new JLabel("Votre Login : ");
        lblPassword = new JLabel("Votre Mot de passe : ");
        
        jtfLogin = new JTextField("");
        jtfPassword = new JPasswordField ("");        
        //button
        btnConnexion = new JButton ("Valider");
        btnConnexion.addActionListener(this);
        panelButton.add(btnConnexion);
        this.getContentPane().add(panelConnexion, BorderLayout.NORTH);
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
    public void affichageMenuResponsable() {
	    // Cr?ation de la barre de menu
	    JMenuBar menu = new JMenuBar();

	    // Cr?ation des diff?rents menus
	    JMenu menuRes = new JMenu("Menu Mat�riel");
	    JMenu menuVeh = new JMenu("Menu V�hicule");
	    JMenu menuUser = new JMenu("Menu User");
	
	
	    // Cr?ation d'?l?ment des menus
	    this.ajouterMateriel = new JMenuItem("Ajouter Materiel");
	    this.afficherMateriel = new JMenuItem("Afficher Materiel");
	    this.rechercherMateriel = new JMenuItem("Rechercher Materiel");
	    this.supprimerMateriel = new JMenuItem("Supprimer Materiel");
	    
	    this.ajouterVehicule = new JMenuItem("Ajouter v�hicule");
	    
        this.btnDeconnexion = new JMenuItem("Deconnexion");
        this.userGestion = new JMenuItem("Gestion User");
	
	    // Ajout de l'?l?ment au menu 
	    menuRes.add(ajouterMateriel);
	    menuRes.add(afficherMateriel);
	    menuRes.add(rechercherMateriel);
	    menuRes.add(supprimerMateriel);
	    
	    menuVeh.add(ajouterVehicule);
	    
        menuRes.add(btnDeconnexion);
        menuUser.add(userGestion);
	    
	    //on ecoute les items du menu
	    this.ajouterMateriel.addActionListener(new ActionListe ());
	    this.supprimerMateriel.addActionListener(new ActionListe ());
	    this.afficherMateriel.addActionListener(new ActionListe ());
	    this.rechercherMateriel.addActionListener(new ActionListe ());
	    
	    this.ajouterVehicule.addActionListener(new ActionListe ());

	    // Ajout du menu dans la barre de menu
	    menu.add(menuRes);
	    menu.add(menuVeh);
	    menu.add(menuUser);
	    // Permet de d?finir le menu utilis? dans la JFrame
	    this.setJMenuBar(menu);
    }
    public void affichageMenuDirecteur() {
        // Cr?ation de la barre de menu
        JMenuBar menu = new JMenuBar();

        // Cr?ation des diff?rents menus
        JMenu menuRes = new JMenu("Menu Directeur");
        JMenu menuUser = new JMenu("Menu User");


        // Cr?ation d'?l?ment des menus
        this.ajouterMateriel = new JMenuItem("***");
        this.afficherMateriel = new JMenuItem("***");
        this.rechercherMateriel = new JMenuItem("***");
        this.supprimerMateriel = new JMenuItem("***");
        this.btnDeconnexion = new JMenuItem("D�connexion");


        this.userGestion = new JMenuItem("Gestion User");

        // Ajout de l'?l?ment au menu 
        menuRes.add(ajouterMateriel);
        menuRes.add(afficherMateriel);
        menuRes.add(rechercherMateriel);
        menuRes.add(supprimerMateriel);
        menuRes.add(btnDeconnexion);
        menuUser.add(userGestion);

        // Ajout du menu dans la barre de menu
        menu.add(menuRes);
        menu.add(menuUser);
        // Permet de d?finir le menu utilis? dans la JFrame
        this.setJMenuBar(menu);
    }	
    public void affichageMenuVisiteur() {
        // Cr?ation de la barre de menu
        JMenuBar menu = new JMenuBar();

        // Cr?ation des diff?rents menus
        JMenu menuRes = new JMenu("Menu Visiteur");
        JMenu menuUser = new JMenu("Menu User");


        // Cr?ation d'?l?ment des menus
        this.listeReservation = new JMenuItem("Voir les r�servations");
        this.rechercherMateriel = new JMenuItem("Rechercher du Materiel");
        this.emprunterMateriel = new JMenuItem("Emprunter Materiel");
        
        this.userGestion = new JMenuItem("Gestion User");

        // Ajout de l'�l?ment au menu
        menuRes.add(listeReservation);
        menuRes.add(rechercherMateriel);
        menuRes.add(emprunterMateriel);
        menuUser.add(userGestion);

        //on ecoute les items du menu


        // Ajout du menu dans la barre de menu
        menu.add(menuRes);
        menu.add(menuUser);
        // Permet de d?finir le menu utilis? dans la JFrame
        this.setJMenuBar(menu);
    }
}