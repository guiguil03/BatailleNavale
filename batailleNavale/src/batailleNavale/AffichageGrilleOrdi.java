package batailleNavale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AffichageGrilleOrdi extends JPanel {
    private JPanel monPanelGlobal;
    private Case[][] grille;
    private Case[][] grilleO;
    public AffichageGrilleOrdi(Case[][] grille, Case[][] grilleO) {
        this.grille = grille;
        this.grilleO = grilleO;
        initialiserAffichage(grille);
    }

    private void initialiserAffichage(Case[][] grille) {
        monPanelGlobal = new JPanel(new GridLayout(grille.length, grille[0].length));
        for (int i = 0; i < grilleO.length; i++) {
            for (int j = 0; j < grilleO[i].length; j++) {
                JButton buttonCase = new JButton(grille[i][j].getContenu());
                buttonCase.setOpaque(true);
                buttonCase.setBorderPainted(false);
                buttonCase.setBackground(grille[i][j].getContenu().equals("Occupée") ? Color.WHITE : Color.BLACK);
                
                // Définir une taille personnalisée pour chaque bouton
                buttonCase.setPreferredSize(new Dimension(500, 500)); // Ajustez la taille selon vos besoins
                
                final int row = i;
                final int col = j;
                buttonCase.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Gérer l'événement du clic ici
                        System.out.println("Case [" + row + "][" + col + "] cliquée.");
                    }
                });

                monPanelGlobal.add(buttonCase,BorderLayout.CENTER);

            }
        }
    }

    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }
    
    //une méthode qui va modifier monPanelGlobal
      //quand cette méthode est appelée  on aura deux button case cote à cote 
    //le premier buttoncase avec en se basant sur les valeurs de Grille et le deuxième en fonction de grilleO
    //rajoute le code en te basant sur le code d'initialiser affichage

 // Modifier la méthode creerBoutonCase pour accepter un paramètre supplémentaire
    private JButton creerBoutonCase(Case[][] grille, int i, int j, boolean cacherContenu, int taille) {
        JButton buttonCase = new JButton();
        
        // Appliquer la configuration commune du bouton
        buttonCase.setOpaque(true);
        buttonCase.setBorderPainted(false);
        buttonCase.setPreferredSize(new Dimension(500, 500)); // Ajustez cette taille selon vos besoins
        
        // Configurer le bouton en fonction de cacherContenu
        if (!cacherContenu) {
            // Afficher le contenu du bouton pour la grille du joueur
            buttonCase.setText(grille[i][j].getContenu());
            buttonCase.setBackground(grille[i][j].getContenu().equals("Occupée") ? Color.WHITE : Color.BLACK);
        } else {
            // Pour la grille de l'ordinateur, cacher le contenu et utiliser une couleur neutre
            // Ici, vous pourriez ajuster la couleur pour cacher ou indiquer l'état de la case de manière subtile
        	 buttonCase.setText(" ");
        	 buttonCase.setBorderPainted(true);
        	
        }
        
        // Ajouter un ActionListener pour gérer les clics
        final int row = i;
        final int col = j;
        buttonCase.addActionListener(e -> {
   
           if (cacherContenu) {
                // Révéler la couleur en fonction de la présence d'un navire
                String contenu = grilleO[row-taille][col-taille].getContenu();
                if (contenu.contains("C") || contenu.contains("P") || contenu.contains("T")) {
                    buttonCase.setBackground(Color.GREEN);
                } else {
                    buttonCase.setBackground(Color.YELLOW);
                }
                buttonCase.setText(contenu); // optionnel, pour voir le contenu après le clic
               
                
            }else {
            	// Partie de l'ordinateur
               //Random random = new Random();
               // int rowO = random.nextInt(taille);
               // int colO = random.nextInt(taille);
                String contenu = grille[row][col].getContenu();
                if (contenu.contains("C") || contenu.contains("P") || contenu.contains("T")) {
                    buttonCase.setBackground(Color.RED);
                } else {
                    buttonCase.setBackground(Color.GRAY);
                }
            	
            }
            System.out.println("Case [" + row  + "][" + col + "] cliquée.");
            System.out.println("OK.");
        });
        
        /* à corriger
        buttonCase.addActionListener(e -> {
            if (!cacherContenu) {
                // Jouer pour la grille de l'ordinateur (grilleO)
                String contenu = grilleO[row-taille][col-taille].getContenu();
                if (contenu.contains("C") || contenu.contains("P") || contenu.contains("T")) {
                    buttonCase.setBackground(Color.GREEN); // ou Color.RED selon la demande
                } else {
                    buttonCase.setBackground(Color.YELLOW);
                }
                buttonCase.setText(contenu); // Optionnel pour voir le contenu après le clic
            }

            // Partie de l'ordinateur
            Random random = new Random();
            int rowO = random.nextInt(taille);
            int colO = random.nextInt(taille);
            //JButton buttonJoueur = buttonCase[rowO][colO]; // Assumez boutonsJoueur stocke les références aux boutons de la grille du joueur
            String contenuJoueur = grille[rowO][colO].getContenu();

            SwingUtilities.invokeLater(() -> {
                if (contenuJoueur.contains("C") || contenuJoueur.contains("P") || contenuJoueur.contains("T")) {
                    buttonCase.setBackground(Color.RED);
                } else {
                    buttonCase.setBackground(Color.BLACK);
                }
                // Vous pouvez choisir de définir ou non le texte du bouton pour le rendre visible
                // buttonJoueur.setText(contenuJoueur);
            });
        });
		*/
      
        
        /*changer ce qui se passe lorsqu'on 
         * clique sur le bouton
         * on connaissant le row et le col du bouton cliqué 
         * je le compare à la valeur de grilleCaseO[row][col]
         * si la valeur de la case contient C ou P ou T la couleur de la case devient vert
         * sinon jaune
         */
        return buttonCase;
    }

    // Adapter la méthode modifierAffichageDoubleGrille pour utiliser le nouveau paramètre
    public void modifierAffichageDoubleGrille() {
        monPanelGlobal.removeAll();
        int taille = grille.length;
        monPanelGlobal.setLayout(new GridLayout(taille*2, taille * 2));
        
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                // Ajouter le bouton pour la grille du joueur sans cacher le contenu
                monPanelGlobal.add(creerBoutonCase(grille, i, j, false,taille));
            }}
        for (int i = taille; i < taille*2; i++) {
            for (int j = taille; j < taille*2; j++) {
                // Ajouter le bouton pour la grille de l'ordinateur en cachant le contenu
                monPanelGlobal.add(creerBoutonCase(grilleO, i, j, true, taille));
                
            }
        }
        monPanelGlobal.revalidate();
        monPanelGlobal.repaint();
       
    }
    
  

}
