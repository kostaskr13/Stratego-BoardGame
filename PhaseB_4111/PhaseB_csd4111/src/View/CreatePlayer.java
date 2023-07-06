package View;

import Model.Player.Player;

import javax.swing.*;

public class CreatePlayer {
    Player[] player;

    /**
     * create the player
     */
    public CreatePlayer() {
       this.player=new Player[2];
       Name();
    }


    /**
     * @return get the player
     */
    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }



 public void Name(){

     JTextField Player1Name = new JTextField();
     JTextField Player2Name = new JTextField();
     final JComponent[] inputs = new JComponent[] {

             new JLabel("Player1 Name (Blue Team)"),
             Player1Name,
             new JLabel("Player2 Name (Red Team)"),
             Player2Name

     };
     int result = JOptionPane.showConfirmDialog(null, inputs, "New game ", JOptionPane.PLAIN_MESSAGE);

     this.player[0]=new Player(Player1Name.getText(), Model.Pieces.Color.BLUE);
     this.player[1]=new Player(Player2Name.getText(), Model.Pieces.Color.RED);
 }

}
