package View;
import Control.Controller;
import Model.Pieces.BeastRider;
import Model.Pieces.Flag;
import Model.Pieces.Piece;
import Model.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import  View.Info2;
public class BoardPanel extends JPanel{
    CardLayout cardLayout;
    boolean check=false;
    private boolean iconSelected;
    private JButton selectedButton;

    private JButton ClickButton;
    private JButton[][] b = new JButton[8][10];

    private final Controller control;
    private final View view;
    private boolean check2=false;


    /**
     * is the panel with the board
     * @param control
     * @param view
     */
    public BoardPanel(Controller control,View view) {


        setLayout( new BorderLayout() );

        this.cardLayout=new CardLayout();
        this.control=control;
        this.view=view;


        this.setLayout(cardLayout);
        this.setBackground(Color.black);
        this.setBounds(0, 0, 800, 900);

        boardRefresh();
        createBoard();

    }

    private ImageIcon getImageBackBlue() { // image for blue background
        try {

            return new ImageIcon(ImageIO.read(getClass().getResource("/images/bluePieces/blueHidden.png")).getScaledInstance(90, 110, Image.SCALE_SMOOTH)); // image
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    private ImageIcon getImageBackRed() { // image for red background
        try {
            return new ImageIcon(ImageIO.read(getClass().getResource("/images/RedPieces/redHidden.png")).getScaledInstance(90, 110, Image.SCALE_SMOOTH)); // image
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private  ImageIcon getImageCard(int i,int x) { // image for card


        try {

            ImageIcon img =new ImageIcon(ImageIO.read(getClass().getResource(this.control.getArray().getPieces()[i][x].getImg())).getScaledInstance(90, 110, Image.SCALE_SMOOTH));
            return  img; // image
        } catch (IOException ex) {
            Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }


    private class CardListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            JButton but = ((JButton) e.getSource());
            if(!check) {
                JButton but1 = (JButton)e.getSource();
                ClickButton = but1;

                check=true;
            }

            if (iconSelected && !but.equals(selectedButton)) {

                if ((control.getPlayer().getPlayer()[1].isTurn()&& but.getName()==redCard||but.getName()==whiteCard) ||(control.getPlayer().getPlayer()[0].isTurn()&& but.getName()==blueCard||but.getName()==whiteCard)){
                    but.setIcon(selectedButton.getIcon());
                   // but.setName(selectedButton.getName());
                   ClickButton.setName(but.getName());

                    selectedButton.setIcon(null);
                    selectedButton.removeAll();
                    selectedButton.setBackground(Color.WHITE);

                    selectedButton.setBorder(BorderFactory.createLineBorder(Color.black));

                  // selectedButton.setName(ClickButton.getName());

                    selectedButton = but;
                    iconSelected = false;

                    removeAll();
                    view.refresh();

                    if (control.getPlayer().getPlayer()[1].isTurn()) {
                        control.getPlayer().getPlayer()[1].setTurn(false);
                        control.getPlayer().getPlayer()[0].setTurn(true);
                    } else {
                        control.getPlayer().getPlayer()[0].setTurn(false);
                        control.getPlayer().getPlayer()[1].setTurn(true);
                    }
                }


            }

           else if (!iconSelected && but.getName() != null) { // if not selected icon is joker then select


                iconSelected = true;
                selectedButton = but;
                but.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));

                //in this for i check everything in the board to put the green border that its means where the card should go

                for(int i=0; i<8; i++){
                    for(int j=0; j<10; j++) {
                        if (b[i][j] != null) {
                            int x = (((int) selectedButton.getLocation().getY()) / 112);
                            int y = (((int) selectedButton.getLocation().getX()) / 80);

                            if(control.getArray().getPieces()[x][y].getNum()==1){ //green boarder for slayer
                                for(int i1=0; i1<8; i1++){
                                    for(int j1=0; j1<10; j1++) {

                                        if(b[x][j1].getName()==whiteCard&&b[i1][y].getName()==whiteCard){

                                            b[x][j1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                            b[i1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        }

                                    }

                                    }
                            }


                            if (((x - 1) < 0 || (x - 1) > 7) && ((y + 1) < 0 || (y + 1) > 9)) {
                                if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x + 1][y].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                }

                            } else if (((x - 1) < 0 || (x - 1) > 7) && ((y - 1) < 0 || (y - 1) > 9)) {
                                if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x + 1][y].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                }
                            } else if (((x + 1) < 0 || (x + 1) > 7) && ((y + 1) < 0 || (y + 1) > 9)) {
                                if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x - 1][y].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                }


                            } else if (((x + 1) < 0 || (x + 1) > 7) && ((y - 1) < 0 || (y - 1) > 9)) {
                                if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x - 1][y].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                }


                            } else if ((x - 1) < 0 || (x - 1) > 7) {
                                if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x + 1][y].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                }


                            } else if ((x + 1) < 0 || (x + 1) > 7) {
                                if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x - 1][y].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                }


                            } else if ((y + 1) < 0 || (y + 1) > 9) {
                                if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x - 1][y].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x + 1][y].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y - 1].getName()) {
                                    b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                }


                            } else if ((y - 1) < 0 || (y - 1) > 9) {
                                if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x - 1][y].getName()) {
                                    b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                } else if (b[x][y].getName() != b[x + 1][y].getName()) {
                                    b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                } else if (b[x][y].getName() != b[x][y + 1].getName()) {
                                    b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                }


                            } else {

                                if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x + 1][y].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y + 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y - 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x + 1][y].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y + 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x + 1][y].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y - 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }

                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y + 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y - 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x + 1][y].getName() == yellow) {
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y + 1].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else if (b[x][y - 1].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    } else {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x + 1][y].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else if (b[x + 1][y].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else if (b[x][y + 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x - 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else if (b[x][y - 1].getName() == yellow) {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y + 1].getName()) {
                                    if (b[x + 1][y].getName() == yellow) {
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else if (b[x][y + 1].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x + 1][y].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x + 1][y].getName() == yellow) {
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else if (b[x][y - 1].getName() == yellow) {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x][y + 1].getName() && b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x][y + 1].getName() == yellow) {
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else if (b[x][y - 1].getName() == yellow) {
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                                    } else {
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x - 1][y].getName()) {
                                    if (b[x - 1][y].getName() == yellow) {
                                        //  b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                                    } else {
                                        b[x - 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x + 1][y].getName()) {
                                    if (b[x + 1][y].getName() == yellow) {
                                        // b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                                    } else {
                                        b[x + 1][y].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x][y + 1].getName()) {
                                    if (b[x][y + 1].getName() == yellow) {
                                        // b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.RED, 3));

                                    } else {
                                        b[x][y + 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                } else if (b[x][y].getName() != b[x][y - 1].getName()) {
                                    if (b[x][y - 1].getName() == yellow) {
                                        //  b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                                    } else {
                                        b[x][y - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                                    }
                                }

                            }


                        }

                    }
                }

            } else { // if already selected or not selected at all
                if (iconSelected) {
                    System.out.println("Already Selected");
                } else {
                    System.out.println("Not selected");
                }
            }

            check2=true;
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
    public static String blueCard = "blue";
    public static String redCard = "red";
    public static String whiteCard = "white";
    public static String yellow = "yellow";


    /**
     * we create the first board of cards
     */
public void createBoard(){


    CardListener cl = new CardListener();

   this.setLayout(new GridLayout(8, 10));


            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 10; c++) {

                    if (control.getPlayer().getPlayer()[0].isTurn()) {
                        b[r][c] = new JButton();
                        b[r][c].setIcon(getImageCard(r, c));
                        b[r][c].setName(blueCard);


                    } else if (control.getArray().getPieces()[r][c].getColor() == Model.Pieces.Color.BLUE) {

                        b[r][c] = new JButton();
                        b[r][c].setIcon(getImageBackBlue());
                        b[r][c].setName(blueCard);


                    }
                    b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                    b[r][c].addMouseListener(cl);
                     this.add(b[r][c]);

                }
            }
            for (int r = 3; r < 5; r++) {
                for (int c = 0; c < 10; c++) {
                    if ((r == 3 || r == 4) && (c == 2 || c == 3 || c == 6 || c == 7)) {

                        b[r][c] = new JButton();
                        b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                        b[r][c].setBackground(Color.YELLOW);
                        b[r][c].setName(yellow);


                    } else if ((r==3&&c==4&&control.getPlayer().getPlayer()[0].isTurn())) {
                        b[r][c] = new JButton();
                        b[r][c].setName(whiteCard);
                        b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                        b[r][c].setBackground(Color.WHITE);
                        b[r][c].setText("test me blue");
                        b[r][c].addMouseListener(cl);
                    }  else if ((r==4&&c==5)&&control.getPlayer().getPlayer()[1].isTurn()) {
                        b[r][c] = new JButton();
                        b[r][c].setName(whiteCard);
                        b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                        b[r][c].setBackground(Color.WHITE);
                        b[r][c].setText("test me red");
                        b[r][c].addMouseListener(cl);
                    }else {

                        b[r][c] = new JButton();
                        b[r][c].setName(whiteCard);

                        b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                        b[r][c].setBackground(Color.WHITE);
                        b[r][c].addMouseListener(cl);

                    }
                     this.add(b[r][c]);

                }
            }

            for (int r = 5; r < 8; r++) {
                for (int c = 0; c < 10; c++) {

                    if (control.getPlayer().getPlayer()[1].isTurn()) {

                        b[r][c] = new JButton();
                        b[r][c].setIcon(getImageCard(r, c));
                        b[r][c].setName(redCard);


                    } else if (control.getArray().getPieces()[r][c].getColor() == Model.Pieces.Color.RED) {
                        b[r][c] = new JButton();
                        b[r][c].setIcon(getImageBackRed());
                        b[r][c].setName(redCard);


                    }
                    b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                    if(b[r][c].getName()==redCard||b[r][c].getName()==blueCard)
                    {if(control.getPlayer().getPlayer()[1].isTurn()){

                        if ((this.control.getArray().getPieces()[r][c].getNum() == 0 || this.control.getArray().getPieces()[r][c].getNum() == 11) && this.control.getArray().getPieces()[r][c].getColor() == Model.Pieces.Color.RED) {
                            b[r][c].setBorder(BorderFactory.createLineBorder(Color.red, 3));
                        }
                    }else {

                        if((this.control.getArray().getPieces()[r][c].getNum()==0||this.control.getArray().getPieces()[r][c].getNum()==11)&&this.control.getArray().getPieces()[r][c].getColor()== Model.Pieces.Color.BLUE){
                            b[r][c].setBorder(BorderFactory.createLineBorder(Color.red,3));
                        }
                    }
                    }
                    b[r][c].addMouseListener(cl);
                   this.add(b[r][c]);

                }

            }


            iconSelected = false;

}

    /**
     * boardRefresh is called for refresh because we change the card position and we have to read again the board with the new loacations
     * to do not get null of any image of card
     */
public void boardRefresh(){


    CardListener cl = new CardListener();



    this.setLayout(new GridLayout(8, 10));

    for (int r = 0; r < 8; r++) {
        for (int c = 0; c < 10; c++) {

            if (b[r][c] != null) {

                if(selectedButton==b[r][c]) {


                    if( ClickButton.getName()!=whiteCard) {//if we attack to a card
                        this.control.getArray().newLocation1(((int) selectedButton.getLocation().getY()) / 112, selectedButton.getLocation().x / 80, ((int) ClickButton.getLocation().getY()) / 112, ClickButton.getLocation().x / 80);
                    }else if(ClickButton.getName()==whiteCard){//if we just move
                        this.control.getArray().newLocation(((int) selectedButton.getLocation().getY()) / 112, selectedButton.getLocation().x / 80, ((int) ClickButton.getLocation().getY()) / 112, ClickButton.getLocation().x / 80);

                    }


                     if(this.control.getArray().newLocationResult()&& ClickButton.getName()!=whiteCard){//set the color of the card
                        if(selectedButton.getName()==redCard){
                            b[r][c].setName(blueCard);
                        }else if(selectedButton.getName()==blueCard){
                            b[r][c].setName(redCard);

                        }

                    }else if(!this.control.getArray().newLocationResult()&& ClickButton.getName()!=whiteCard){
                        if(selectedButton.getName()==redCard){
                            b[r][c].setName(redCard);
                        }else if(selectedButton.getName()==blueCard){
                            b[r][c].setName(blueCard);
                        }
                    }

                        else{
                            if (this.control.getPlayer().getPlayer()[1].isTurn()) {
                                b[r][c].setName(blueCard);
                            } else if(this.control.getPlayer().getPlayer()[0].isTurn()){
                                b[r][c].setName(redCard);
                            }
                        }

                    b[r][c].addMouseListener(cl);


                }
                if (b[r][c].getIcon() != null && this.control.getPlayer().getPlayer()[0].isTurn()&& b[r][c].getName()=="blue") {
                    b[r][c] = new JButton();

                    if ( b[r][c]==selectedButton) {
                        b[r][c].setName(blueCard);
                        b[r][c].addMouseListener(cl);

                    } else if (getImageCard(r, c) != null) {

                        b[r][c].setIcon(getImageCard(r, c));
                        b[r][c].setName(blueCard);
                        b[r][c].addMouseListener(cl);

                    }

                }
              else if (b[r][c].getIcon() != null && !this.control.getPlayer().getPlayer()[0].isTurn()&& b[r][c].getName()=="blue") {
                    b[r][c] = new JButton();
                    b[r][c].setIcon(getImageBackBlue());
                    b[r][c].setName(blueCard);
                    b[r][c].addMouseListener(cl);

                }

              if (b[r][c].getIcon() != null && this.control.getPlayer().getPlayer()[1].isTurn()&& b[r][c].getName()=="red") {
                    b[r][c] = new JButton();

                    if (b[r][c]==selectedButton) {
                        b[r][c].setName(redCard);
                        b[r][c].addMouseListener(cl);
                    } else if (getImageCard(r, c) != null) {

                        b[r][c].setIcon(getImageCard(r, c));
                        b[r][c].setName(redCard);

                        b[r][c].addMouseListener(cl);
                    }
                }
               else if (b[r][c].getIcon() != null && !this.control.getPlayer().getPlayer()[1].isTurn()&&b[r][c].getName()=="red") {
                    b[r][c] = new JButton();
                    b[r][c].setIcon(getImageBackRed());
                    b[r][c].setName(redCard);

                  b[r][c].addMouseListener(cl);
                } else  if(b[r][c].getIcon() == null){
                     if ((r == 3 || r == 4) && (c == 2 || c == 3 || c == 6 || c == 7)) {
                         b[r][c] = new JButton();
                         b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                         b[r][c].setBackground(Color.YELLOW);
                         b[r][c].setName(yellow);


                     } else {
                         b[r][c] = new JButton();
                         b[r][c].setName(whiteCard);

                         b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                         b[r][c].setBackground(Color.WHITE);

                         b[r][c].addMouseListener(cl);
                     }
                 }
                b[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                if(b[r][c].getName()==redCard||b[r][c].getName()==blueCard)
                {if(control.getPlayer().getPlayer()[0].isTurn()){
                    if((this.control.getArray().getPieces()[r][c].getNum()==0||this.control.getArray().getPieces()[r][c].getNum()==11)&&this.control.getArray().getPieces()[r][c].getColor()== Model.Pieces.Color.BLUE){
                        b[r][c].setBorder(BorderFactory.createLineBorder(Color.red,3));

                    }
                }else {
                    if ((this.control.getArray().getPieces()[r][c].getNum() == 0 || this.control.getArray().getPieces()[r][c].getNum() == 11) && this.control.getArray().getPieces()[r][c].getColor() == Model.Pieces.Color.RED) {
                        b[r][c].setBorder(BorderFactory.createLineBorder(Color.red, 3));

                    }
                }
                  }


                this.add(b[r][c]);

            }

        }
        }

    check=false;
    iconSelected = false;
    }



}










