package life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class LifeBoard extends JPanel implements ActionListener {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    
    public static final Color COLOR_DEAD = Color.black;
    public static final Color COLOR_ALIVE = Color.green;
    
    int width;
    int height;
    int xMax;
    int yMax;
    Timer timer;
    Cell[][] cellGrid;
    

    public LifeBoard(int width, int height) {
        Random random = new Random();
        this.width = width;
        this.height = height;
        xMax = width / WIDTH;
        yMax = height / HEIGHT;
        
        setPreferredSize(new Dimension(width, height));
        setBackground(COLOR_DEAD);
        
        cellGrid = new LifeCell[xMax][yMax];
        
        for(int y = 0; y < yMax; y++) {
            for(int x = 0; x < xMax; x++) {
                Cell cell = CellFactory.createCell(x, y);
                if(random.nextBoolean()) {
                    cell.beBorn();
                } else {
                    cell.die();
                }
                cellGrid[x][y] = cell;
            }
        }
        
        for(int y = 0; y < yMax; y++) {
            for(int x = 0; x < xMax; x++) {
                cellGrid[x][y].setupNeighbours(cellGrid);
            }
        }
        
        timer = new Timer(50, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw((Graphics2D)g);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < xMax; i++) {
            for(int j = 0; j < yMax; j++) {
                cellGrid[i][j].changeState();
            }
        }
        
        repaint();
        
        for(int i = 0; i < xMax; i++) {
            for(int j = 0; j < yMax; j++) {
                cellGrid[i][j].calculateNextState();
            }
        }
    }
    

    private void draw(Graphics2D g2) {
        Color oldColor = g2.getColor();
        for(int i = 0; i < xMax; i++) {
            for(int j = 0; j < yMax; j++) {
                if (cellGrid[i][j].isAlive()) {
                    g2.setColor(COLOR_ALIVE);
                } else {
                    g2.setColor(COLOR_DEAD);
                }
                g2.fillRect(cellGrid[i][j].getX() * WIDTH, 
                            cellGrid[i][j].getY() * HEIGHT, WIDTH, HEIGHT);
            }
        }
        g2.setColor(oldColor);
    }
    
    private static final long serialVersionUID = 4800242511174486443L;
}
