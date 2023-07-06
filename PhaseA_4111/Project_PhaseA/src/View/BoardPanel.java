package View;
import Model.Board.Board;
import Control.Controller;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BoardPanel extends JPanel {
    private boolean iconSelected;
    private JButton selectedButton;


    public BoardPanel()  {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        this.setBounds(0,0,800,900);

        this.setLayout(new GridLayout(8, 10));

        // this.setResizable(false);

        CardListener cl = new CardListener();


        for (int i = 0; i < 80; i++) {
            JButton b = new JButton();
            if (i == 0) { // init joker
                b.setIcon(getImageCard());
                b.setName(cardname);
                // b.setBorder(BorderFactory.createLineBorder(Color.YELLOW,5));
            } else { // init background
                b.setIcon(getImageBack());
            }
            b.setBorder(BorderFactory.createLineBorder(Color.black));
            b.addMouseListener(cl);
            this.add(b);
        }

        iconSelected = false;

    }

    private ImageIcon getImageBack() { // image for background
        try {
            return new ImageIcon(ImageIO.read(getClass().getResource("/images/RedPieces/dragonR.png"))); // image
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ImageIcon getImageCard() { // image for card
        try {
            // System.out.println(getClass().getResource("./images/bluePieces/beastRiderB.png"));
           return new ImageIcon(ImageIO.read(getClass().getResource("/images/bluePieces/beastRiderB.png")).getScaledInstance(100, 80, Image.SCALE_SMOOTH)); // image
        } catch (IOException ex) {
            Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private class CardListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton but = ((JButton) e.getSource());
            if (iconSelected && !but.equals(selectedButton)) { // move(swap) buttons
                but.setIcon(selectedButton.getIcon());
                but.setName(cardname);
                // but.setBorder(BorderFactory.createLineBorder(Color.YELLOW,5));
                selectedButton.setIcon(getImageBack());
                selectedButton.setBorder(BorderFactory.createLineBorder(Color.black));
                selectedButton.setName(null);
                selectedButton = but;
                iconSelected = false;
            } else if (!iconSelected && but.getName() != null) { // if not selected icon is joker then select
                iconSelected = true; // we can do without it, we can check for null selected button
                selectedButton = but;
                but.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
            } else { // if already selected or not selected at all
                if (iconSelected) {
                    System.out.println("Already Selected");
                } else {
                    System.out.println("Not selected");
                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    public static String cardname = "My Card";

}
