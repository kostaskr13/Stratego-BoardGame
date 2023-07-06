package Model.Pieces;

public abstract class Piece {
    private Color color;
    private String img;

    /**
     *constructor of Piece
     * @param color
     * @param img
     */
    public Piece(Color color,String img){
        this.img=img;
        this.color=color;
    }


    /**
     *accesor
     * @return the color of the Piece
     */
    public Color getColor() {
        return color;
    }

    /**
     * transformer set the color of the Piece
     * @param color
     */

    public void setColor(Color color) {
        this.color = color;
    }
}
