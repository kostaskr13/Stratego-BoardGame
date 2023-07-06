package Control;

import Model.Board.Board;
import Model.Pieces.*;
import Model.Player.Player;

public class Controller {
    private Player player1,player2;
    private Board array[][];


    /**
     * constructor of controler
     */
    public Controller(Player player1, Player player2, Board[][] array) {
        this.player1 = player1;
        this.player2 = player2;
        this.array = array;

    }


    /**
     * accesor return if player1 starts
     * @return
     */
    public Player getPlayer1() {
        return player1;
    }


    /**
     * transformer set the player1
     * @param player1
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * accesor return if player2 starts
     * @return
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * transformer set the player1
     * @param player2
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }


    /**
     * transformer that initialize the board game
     */
    public Board[][] getArray() {
        return array;
    }

    /**
     * transformer that set the array of board
     * @param array
     */
    public void setArray(Board[][] array) {
        this.array = array;
    }

    /**
     * accessor return who has Turn
     * @return
     */
    Color get_Turn(){
        return Color.RED;
    }

    /**
     * transformer that initialize the Pawns
     */
    void initialize_Pawns(){

    }

    /**
     * transformer that initialize the Pieces
     */
    void initialize_Pieces(){


    }

    /**
     * transformer that initialize the board game
     */
    void initialize_Board( Piece[][] array) {

        int i;
        int j;
        for (i=0;i<=3;i++){
            for(j=0;j<=10;j++){
             array[i][j]=new BeastRider(Color.BLUE,"/images/RedPieces/dragonR.png");
            }
        }

    }

    /**
     * observe return if the attacker wins
     * @param attacker
     * @param defender
     * @return
     */
    boolean is_attacker_winning(Piece attacker,Piece defender){

     return false;

    }


    /**
     * observe return if the Piece of the possition
     * that is now if he can move or not
     * @param board
     * @param xFrom
     * @param yFrom
     * @param xTo
     * @param yTo
     * @return
     */
    boolean is_move_alloed(Board board,int xFrom,int yFrom,int xTo,int yTo){

    return false;

    }


}
