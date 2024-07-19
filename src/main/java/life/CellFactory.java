package life;


public class CellFactory {
    

    public static Cell createCell(int x, int y) {

       return new LifeCell(x, y);
    }
}

