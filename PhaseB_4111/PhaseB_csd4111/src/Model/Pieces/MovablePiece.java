package Model.Pieces;


public class MovablePiece extends Piece{
    private int num;
    /**
     * constructor of Piece
     *
     * @param color
     * @param img
     * @param num
     */
    public MovablePiece(Color color, String img,int num) {
        super(color, img,num);
        this.num=num;
    }




    /**
     * accesor
     * @return the Number of each movable Piece
     */
    public int getNum() {
        return num;
    }

    /**
     * transformer set for each movable Piece the Number
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

}
