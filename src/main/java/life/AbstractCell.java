package life;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCell implements Cell{
      private int x;
      private int y;
      private List<Cell> neighbours;
      protected boolean nextState;
      protected boolean alive;

    public AbstractCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.neighbours = new ArrayList<>();
        this.nextState = false;
        this.alive = false;
        
    }
    
    public abstract void calculateNextState();
    
    @Override
    public List<Cell> getNeighbours() {
        return neighbours;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
   
    @Override
    public void beBorn() {
        nextState = true;
    }

    @Override
    public void die() {
        nextState = false;
    }
    
    @Override
    public void changeState() {
        alive = nextState;
    }
    
    @Override
    public boolean isAlive() {
        return alive;
    }
    
    @Override
    public void setupNeighbours(Cell[][] cellGrid) {

        int numRows = cellGrid.length;
        int numCols = cellGrid[0].length;

        for (int newx = -1; newx <= 1; newx++) {
            for (int newy = -1; newy <= 1; newy++) {
                if (newx == 0 && newy == 0) {
                    continue;
                }

                int neighbourX = x + newx;
                int neighbourY = y + newy;


                if (neighbourX >= 0 && neighbourX < numRows && neighbourY >= 0 && neighbourY < numCols) {
                    neighbours.add(cellGrid[neighbourX][neighbourY]);
                }
            }
        }
    }
     
    public int countAliveNeighbours() {
        int count = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour.isAlive()) {
                count++;
            }
        }
        return count;
    }
}
