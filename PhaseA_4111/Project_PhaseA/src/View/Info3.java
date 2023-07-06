package View;

import javax.swing.*;
import java.awt.*;

public class Info3 extends JPanel {
    private JLabel select1=new JLabel("Συνολικές Αιχμαλωτίσεις: ");

    public Info3(){
    this.setBackground(Color.darkGray);
    this.setBounds(810,600,370,260);

    select1.setFont(new Font("",Font.PLAIN,15));
    select1.setForeground(Color.white);
    this.add(select1);
}
}
