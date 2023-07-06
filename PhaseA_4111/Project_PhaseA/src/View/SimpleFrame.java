package View;

import javax.swing.*;

public class SimpleFrame extends JFrame
{
public SimpleFrame()
{
this.setSize(200,200);
this.setLocation(200,200);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

// Makes the frame visible.
public void showIt(){
this.setVisible(true);
}

// Makes the frame visible and sets the title text.
public void showIt(String title){
this.setTitle(title);
this.setVisible(true);
}

// Makes the frame visible and sets the title text
// and the position of the window.

public void showIt(String title,int x, int y){
   this.setTitle(title);
this.setLocation(x,y);
this.setVisible(true);
}

// Makes the frame invisible.
public void hideIt(){
this.setVisible(false);
}
}
