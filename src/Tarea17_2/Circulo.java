package Tarea17_2;
 public class Circulo {
    private int x, y;

    public Circulo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}