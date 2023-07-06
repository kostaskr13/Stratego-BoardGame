package Model.Player;
import Model.Pieces.*;

public class Player {
    private Color color;
    private String name;
    private boolean Turn;

    /**
     * constructor of Player with name ,color ,turn
     */
    public Player(){
        this.name=name;
        this.color=color;
        this.Turn=false;
    }

    /**
     * accesor
     * @return the color of Pieces that has the Player
     */
    public Color getColor() {
        return color;
    }

    /**
     * transformer set the color of the Pieces that has the Player
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * accesor
     * @return the Name of the Player
     */
    public String getName() {
        return name;
    }

    /**
     * transformer set the name of the player
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * accesor
     * @return which player has turn to play
     */
    public boolean isTurn() {
        return Turn;
    }

    /**
     * transformer set the turn of the player
     * @param turn
     */
    public void setTurn(boolean turn) {
        Turn = turn;
    }
}
