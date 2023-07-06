package Model.Pieces;

public class MovablePiece extends Piece{
    private int num;

    /**
     *
     * constructor that create new MovablePiece
     * @param color
     * @param img
     */
    public MovablePiece(Color color, String img) {
        super(color, img);
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
