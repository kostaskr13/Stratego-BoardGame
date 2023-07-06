package Model.Pieces;

/**
 * public color of two teams
 */
public enum Color {

    BLUE("BLUE"),RED("RED");


    String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

