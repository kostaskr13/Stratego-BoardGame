package View;
import Control.Controller;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class View extends SimpleFrame{

    BoardPanel mePanel=new BoardPanel();
    Info1 Info1Panel=new Info1();
    Info2 Info2Panel=new Info2();
    Info3 Info3Panel=new Info3();


    private final String picturePathBlue = ("C:\\Users\\kostantinos\\Project_PhaseA\\src\\images\\bluePieces\\");
    private final String picturePathRed = ("C:\\Users\\kostantinos\\Project_PhaseA\\src\\images\\RedPieces\\");

    public View() {

        ImageIcon image=new ImageIcon("C:\\Users\\kostantinos\\Project_PhaseA\\src\\View\\koo.png");

        this.setTitle("Stratego");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200,900);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setIconImage(image.getImage());
        this.setLayout(null);


        JPanel Text1=new JPanel();
        JPanel Text2=new JPanel();
        JPanel Text3=new JPanel();

        Text1.setBackground(Color.lightGray);
        Text1.setBounds(810,0,370,40);

        Text2.setBackground(Color.lightGray);
        Text2.setBounds(810,250,370,40);

        Text3.setBackground(Color.lightGray);
        Text3.setBounds(810,550,370,40);


        JLabel label=new JLabel("Ενεργοί Κανόνες");
        label.setFont(new Font("",Font.PLAIN,30));

        JLabel label1=new JLabel("Στατιστικά");
        label1.setFont(new Font("",Font.PLAIN,30));

        JLabel label2=new JLabel("Αιχμαλωτίσεις");
        label2.setFont(new Font("",Font.PLAIN,30));


        BoardPanel ip=new BoardPanel();
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

}