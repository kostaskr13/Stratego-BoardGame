package View;

import javax.swing.*;
import java.awt.*;


public class Info1 extends JPanel {
    private JLabel select1=new JLabel("Μειωμένος Στρατός");
    private JLabel select2=new JLabel("Καμία Υποχώριση");



    public Info1() {
        this.setLayout(new GridLayout(2,2));

        this.setBackground(Color.darkGray);
        this.setBounds(810, 50, 370, 120);
        select1.setFont(new Font("",Font.PLAIN,15));
        select1.setForeground(Color.white);
        select2.setFont(new Font("",Font.PLAIN,15));
        select2.setForeground(Color.white);
        this.add(select1);
        this.add(select2);
    }
}
