package Model.Board;

import Model.Pieces.Piece;

public class Board {
    Piece[][] array ;
    Piece[][] random;

    /**
     * constructor of Board
     */
    public Board (){
        this.random= new Piece[6][10];
        this.array=new Piece[8][10];
    }




    /**
     * accesor return the array of Pieces
     * @return
     */
    public Piece[][] getArray() {
        return array;
    }

    /**
     * transformer set the array of pieces
     * @param array
     */
    public void setArray(Piece[][] array) {
        this.array = array;
    }

    /**
     * accesor return the random array of Pieces
     * @return
     */
    public Piece[][] getRandom() {
        return random;
    }

    /**
     * transformer set the random array of Pieces
     * @param random
     */
    public void setRandom(Piece[][] random) {
        this.random = random;
    }
}
