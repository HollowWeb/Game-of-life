package life;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class LifeApp implements Runnable {

    private static final int BOARD_WIDTH = 1028;  // Breite des Spielfeldes
    private static final int BOARD_HEIGHT = 1028; // Höhe des Spielfeldes


    public static void main(String[] args) {
        EventQueue.invokeLater(new LifeApp());
    }


    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setResizable(false); // Fenstergröße nicht veränderbar
        frame.setTitle("Life"); // Titel des Fensters
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beendet das Programm bei Schließen des Fensters
        LifeBoard gameBoard = new LifeBoard(BOARD_WIDTH, BOARD_HEIGHT); // Erstellt das Spielfeld
        frame.add(gameBoard); // Fügt das Spielfeld zum Fenster hinzu
        frame.pack(); // Passt die Größe des Fensters an das Spielfeld an
        frame.setFocusable(true); // Erlaubt Fokus, wichtig für Tastatureingaben
        frame.setVisible(true); // Macht das Fenster sichtbar
        frame.setLocationRelativeTo(null); // Zentriert das Fenster auf dem Bildschirm
    }
}

