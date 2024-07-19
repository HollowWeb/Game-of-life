package life;

import java.util.List;



public interface Cell {
	

	void setupNeighbours(Cell[][] cellGrid);

	void changeState();

	void calculateNextState();

	void beBorn();

	void die();

	boolean isAlive();

	int getX();

	int getY();

	List<Cell> getNeighbours();
}
