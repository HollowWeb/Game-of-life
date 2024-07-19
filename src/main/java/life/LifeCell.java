package life;



public class LifeCell extends AbstractCell {

   
    public LifeCell(int x, int y) {
        super(x, y);  
    }

    @Override
    public void calculateNextState() {
        int aliveNeighbours = countAliveNeighbours();

        nextState = (aliveNeighbours == 3 || aliveNeighbours == 2 && alive);
    }

}

