package batailleNavale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AffichageGrille extends JPanel {
    private JPanel monPanelGlobal;
    private Case[][] grille;

    public AffichageGrille(Case[][] grille) {
        this.grille = grille;
        initialiserAffichage(grille);
    }

    private void initialiserAffichage(Case[][] grille) {
        monPanelGlobal = new JPanel(new GridLayout(grille.length, grille[0].length));
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
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
}
