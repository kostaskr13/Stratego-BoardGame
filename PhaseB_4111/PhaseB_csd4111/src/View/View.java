package View;
import Control.Controller;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import Model.Player.Player;
import Control.Controller;
import javax.swing.JDesktopPane;

public class View extends JFrame {


    private final Controller control;

    BoardPanel mePanel;
    Info1 Info1Panel;
    Info2 Info2Panel;
    Info3 Info3Panel;
    CardLayout cardLayout;

    /**
     * @param control the view class is the main class of the graphics that i put all  the panels on it
     */
    public View(Controller control) {

        this.cardLayout=new CardLayout();
        this.control=control;

        mePanel=new BoardPanel(this.control,this);
        Info1Panel=new Info1();
        Info2Panel=new Info2(this.control,this);
        Info3Panel=new Info3();


        ImageIcon image = new ImageIcon("C:\\Users\\kostantinos\\Project_PhaseA\\src\\View\\koo.png");
        this.setTitle("Stratego");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200, 930);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setIconImage(image.getImage());
        this.setLayout(null);



        JPanel Text1 = new JPanel();
        JPanel Text2 = new JPanel();
        JPanel Text3 = new JPanel();

        Text1.setBackground(Color.lightGray);
        Text1.setBounds(810, 0, 370, 40);

        Text2.setBackground(Color.lightGray);
        Text2.setBounds(810, 250, 370, 40);

        Text3.setBackground(Color.lightGray);
        Text3.setBounds(810, 550, 370, 40);


        JLabel label = new JLabel("Energoi kanones");
        label.setFont(new Font("", Font.PLAIN, 30));

        JLabel label1 = new JLabel("Statistika");
        label1.setFont(new Font("", Font.PLAIN, 30));

        JLabel label2 = new JLabel("Aixmalotisis");
        label2.setFont(new Font("", Font.PLAIN, 30));


        BoardPanel ip = new BoardPanel(control,this);
        this.getContentPane().add(ip, BorderLayout.CENTER);


        this.add(mePanel);
        this.add(Info1Panel);
        this.add(Info2Panel);
        this.add(Info3Panel);
            this.add(Text1);
            this.add(Text2);
            this.add(Text3);
            Text1.add(label);
            Text2.add(label1);
            Text3.add(label2);

        this.setVisible(true);

    }


    /**
     *  refresh the board
     */
public void refresh()  {


        this.mePanel.removeAll();
        this.Info2Panel.playerTurnText();
        this.mePanel.boardRefresh();



    }


}