package View;

import javax.swing.*;
import java.awt.*;

public class Info2 extends JPanel {

    private JLabel select0=new JLabel("Player ");
    private JLabel select00  =new JLabel("0 Turn",JLabel.RIGHT);

    private JLabel select1=new JLabel("Ποσοστό Επιτ.Επίθεσης: ");
    private JLabel select11  =new JLabel("0",JLabel.RIGHT);
    private JLabel select2=new JLabel("Διασώσεις: ");
    private JLabel select22 =new JLabel("0",JLabel.RIGHT);
    private JLabel select3=new JLabel("Γύρος: ");
    private JLabel select33 =new JLabel("0",JLabel.RIGHT);

    public Info2() {

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
        this.add(select0);
        this.add(select00);
        this.add(select1);
        this.add(select11);
        this.add(select2);
        this.add(select22);
        this.add(select3);
        this.add(select33);


    }
}
