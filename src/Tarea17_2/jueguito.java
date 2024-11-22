package Tarea17_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class jueguito extends JFrame {
    private Circulo circulo;
    private final int squareX = 300, squareY = 200, squareSize = 50;

    public jueguito() {
        circulo = new Circulo(50, 200);

        setTitle("Movimiento y Colisión");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> circulo.mover(-10, 0);
                    case KeyEvent.VK_RIGHT -> circulo.mover(10, 0);
                    case KeyEvent.VK_UP -> circulo.mover(0, -10);
                    case KeyEvent.VK_DOWN -> circulo.mover(0, 10);
                }
                verificarColision();
                repaint();
            }
        });

        setVisible(true);
    }

    private void verificarColision() {
        if (circulo.getX() + 20 > squareX && circulo.getX() < squareX + squareSize &&
            circulo.getY() + 20 > squareY && circulo.getY() < squareY + squareSize) {
            JOptionPane.showMessageDialog(this, "¡Colisión detectada!");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(circulo.getX(), circulo.getY(), 20, 20);
        g.setColor(Color.RED);
        g.fillRect(squareX, squareY, squareSize, squareSize);
    }

    public static void main(String[] args) {
        new jueguito();
    }
}
