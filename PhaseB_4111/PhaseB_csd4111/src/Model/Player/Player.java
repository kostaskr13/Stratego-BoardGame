package Model.Player;
import Model.Pieces.*;

public  class Player {
    private Color color;
    private String name;
    private boolean Turn;

    /**
     * constructor of Player with name ,color ,turn
     */
    public Player(String name,Color color){
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
        return this.name;
    }

    /**
     * transformer set the name of the player
     * @param Newname
     */
    public void setName(String Newname) {
        this.name = Newname;
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
