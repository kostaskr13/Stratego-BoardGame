package View;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import Control.Controller;
import Model.Player.Player;


public class Info2 extends JPanel {


    private final View view;

   private final Controller control;

    private JLabel select0=new JLabel("Player ");

    private JLabel select00  =new JLabel();

    private JLabel select1=new JLabel("Pososto epit.Epithesis: ");
    private JLabel select11  =new JLabel("0",JLabel.RIGHT);
    private JLabel select2=new JLabel("Diasoseis: ");
    private JLabel select22 =new JLabel("0",JLabel.RIGHT);
    private JLabel select3=new JLabel("Round: ");
    private JLabel select33 =new JLabel("0",JLabel.RIGHT);


    /**
     * info2 panel of informations of  game
     * and for who is playing
     */
    public Info2(Controller control,View view) {


        this.view=view;
        this.control=control;



        this.setBackground(Color.darkGray);
        this.setBounds(810, 300, 370, 140);
        this.setLayout(new GridLayout(4,2));

        select0.setFont(new Font("",Font.PLAIN,15));
        select0.setForeground(Color.white);
        select1.setFont(new Font("",Font.PLAIN,15));
        select1.setForeground(Color.white);
        select2.setFont(new Font("",Font.PLAIN,15));
        select2.setForeground(Color.white);
        select3.setFont(new Font("",Font.PLAIN,15));
        select3.setForeground(Color.white);






        select00.setFont(new Font("",Font.PLAIN,15));
        select00.setForeground(Color.white);

        select11.setForeground(Color.white);

        select22.setForeground(Color.white);

        select33.setForeground(Color.white);

        playerTurnText();
        this.add(select0);
        this.add(select00);
        this.add(select1);
        this.add(select11);
        this.add(select2);
        this.add(select22);
        this.add(select3);
        this.add(select33);

        this.setVisible(true);


    }
    public void playerTurnText(){
        if(this.control.getPlayer().getPlayer()[0].isTurn()) {
            select00.setText(this.control.getPlayer().getPlayer()[0].getName()+" Blue Turn");
        }else{
            select00.setText(this.control.getPlayer().getPlayer()[1].getName()+" Red Turn");
        }

    }

}
