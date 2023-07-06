package Control;

import Model.Board;
import Model.Pieces.*;
import Model.Player.Player;
import View.CreatePlayer;

import javax.swing.*;
import java.util.Random;

public class Controller {
    private CreatePlayer player;
    private Board array;



    /**
     * constructor of controler
     */
    public Controller() {
        this.player=new CreatePlayer();
        this.array = new Board();


    }

    /**
     * accesor return if player1 starts
     * @return
     */
    public CreatePlayer getPlayer() {

        return this.player;
    }




    /**
     * transformer that initialize the board game
     */

     public Board getArray() {
         return this.array;
    }


    /**
     * start_Turn ,take random who is playig first red or blue
     */
    public void start_Turn(){
        Color[] arr = {Color.BLUE,Color.RED};
        Random random = new Random();

        // randomly selects an index from the arr
        int select = random.nextInt(arr.length);
                if (arr[select]== Model.Pieces.Color.BLUE)
                {
                    this.getPlayer().getPlayer()[0].setTurn(true);
                }else{
                    this.getPlayer().getPlayer()[1].setTurn(true);
                }
    }

    /**
     * transformer that initialize the Pawns
     */
    void initialize_Pawns(){
        //is in Board class

    }

    /**
     * transformer that initialize the Pieces
     */
    void initialize_Pieces(){
       //is in Board class

    }

    /**
     * transformer that initialize the board game
     */
    void initialize_Board( Piece array) {
        //is in Board class

    }

    /**
     * observe return if the attacker wins
     * @param attacker
     * @param defender
     * @return
     */
    boolean is_attacker_winning(Piece attacker,Piece defender){
        //is in BoardPanel class

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

        //is in BoardPanel class
    return false;

    }



}
