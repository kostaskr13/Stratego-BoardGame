package Model.Pieces;


public abstract class Piece {
    private Color color;
    private String img;
    private int num;


    /**
     * constructor of Piece
     *
     * @param color
     * @param img
     * @param num
     */
    public Piece(Color color, String img, int num) {

        this.img = img;
        this.color = color;
        this.num = num;

    }

    /**
     * @return the number of card
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num set the number of card
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return get the img of card
     */
    public String getImg() {
        return this.img;
    }

    /**
     * @param img set the image of card
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * accesor
     *
     * @return the color of the Piece
     */
    public Color getColor() {
        return color;
    }

    /**
     * transformer set the color of the Piece
     *
     * @param color
     */

    public void setColor(Color color) {
        this.color = color;
    }
}




