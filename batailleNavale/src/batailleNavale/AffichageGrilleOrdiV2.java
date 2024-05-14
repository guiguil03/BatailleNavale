package batailleNavale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AffichageGrilleOrdiV2 extends JPanel {
    private JPanel monPanelGlobal;
    private JButton[][] boutonsJoueur;
    private Case[][] grille;
    private Case[][] grilleO;
    private int lastHitRow = -1;
    private int lastHitCol = -1;
    private int[] directions = {0, 1, 2, 3}; // 0=gauche, 1=haut, 2=droite, 3=bas
    private int currentDirection = 0;

    // Reste de la classe inchangée ...
    public AffichageGrilleOrdiV2(Case[][] grille, Case[][] grilleO) {
        this.grille = grille;
        this.grilleO = grilleO;
        initialiserAffichage(grille);
    }

    private void initialiserAffichage(Case[][] grille) {
        monPanelGlobal = new JPanel(new GridLayout(grille.length, grille[0].length));
        boutonsJoueur = new JButton[grille.length][grille[0].length];
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
        	 boutonsJoueur[i][j] = buttonCase; 
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
                buttonCase.setText(contenu);
                //v2 pour qu'on rejoue si on a bon
                
                if (!contenu.contains("C") && !contenu.contains("P") && !contenu.contains("T")) {
                // optionnel, pour voir le contenu après le clic
                Timer timer = new Timer(500, event -> ordiJoue());
                timer.setRepeats(false);
                timer.start();
                }
                
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
                if (contenu.contains("C") || contenu.contains("P") || contenu.contains("T")) {
                	Timer timer = new Timer(500, event -> ordiJoue());
                    timer.setRepeats(false);
                    timer.start();
                }
            	
            }
            System.out.println("Case [" + row  + "][" + col + "] cliquée.");
            System.out.println("OK.");
        });
        
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
            //ce sera des boutons du joueur
                }}
                
                
                
        for (int i = taille; i < taille*2; i++) {
            for (int j = taille; j < taille*2; j++) {
                // Ajouter le bouton pour la grille de l'ordinateur en cachant le contenu
                monPanelGlobal.add(creerBoutonCase(grilleO, i, j, true, taille));
             //ce sera des boutons de l'ordi   
            }
        }
        monPanelGlobal.revalidate();
        monPanelGlobal.repaint();
       
    }

    public void ordiJoue() {
        Random random = new Random();
        int row, col;
        JButton buttonToClick;

        if (lastHitRow != -1 && lastHitCol != -1) {
            // Si un navire a été touché précédemment, tenter de suivre la direction
            while (directions[currentDirection] != -1) {
                switch (directions[currentDirection]) {
                    case 0: // gauche
                        row = lastHitRow;
                        col = lastHitCol - 1;
                        break;
                    case 1: // haut
                        row = lastHitRow - 1;
                        col = lastHitCol;
                        break;
                    case 2: // droite
                        row = lastHitRow;
                        col = lastHitCol + 1;
                        break;
                    case 3: // bas
                        row = lastHitRow + 1;
                        col = lastHitCol;
                        break;
                    default:
                        continue;
                }
                
                // Vérifier les limites
                if (row >= 0 && row < grille.length && col >= 0 && col < grille[0].length) {
                    buttonToClick = boutonsJoueur[row][col];
                    if (buttonToClick.getBackground() != Color.RED && buttonToClick.getBackground() != Color.GRAY) {
                        // Simuler un clic
                        final JButton finalButtonToClick = buttonToClick;
                        SwingUtilities.invokeLater(() -> {
                            finalButtonToClick.doClick();
                        });
                        return;
                    }
                }
                // Passer à la direction suivante si celle-ci ne fonctionne pas
                directions[currentDirection] = -1; // Marquer cette direction comme explorée
                currentDirection = (currentDirection + 1) % 4; // Essayer la direction suivante
            }
        }

        // Si aucune direction n'est valide ou si aucun navire n'a été touché précédemment, choisir une case au hasard
        do {
            row = random.nextInt(grille.length);
            col = random.nextInt(grille[0].length);
            buttonToClick = boutonsJoueur[row][col];
        } while (buttonToClick.getBackground() == Color.RED || buttonToClick.getBackground() == Color.GRAY);

        lastHitRow = row;
        lastHitCol = col;
        final JButton finalButtonToClick = buttonToClick;
        SwingUtilities.invokeLater(() -> {
            finalButtonToClick.doClick();
        });
    }
}
