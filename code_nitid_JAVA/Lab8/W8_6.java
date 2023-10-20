public class week8_6 {
    public static void main(String[] args) {

    }
}

interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "(x, y) : ("+x+", "+y+")";
    }
    public void moveUp() {
        y += ySpeed;
    }
    public void moveDown() {
        y -= ySpeed;
    }
    public void moveLeft() {
        x -= xSpeed;
    }
    public void moveRight() {
        x += xSpeed;
    }
}

class MovableCircle implements Movable {
    int radius;
    MovablePoint center;

    MovableCircle(int x, int y, int xSpeed, int ySpeed) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
    }
    @Override
    public String toString() {
        return "(x, y) : ("+center.x+", "+center.y+")\n"+"Radius: "+radius;
    }
    @Override
    public void moveUp() {
        center.y += center.ySpeed;
    }
    public void moveDown() {
        center.y -= center.ySpeed;
    }
    public void moveLeft() {
        center.x -= center.xSpeed;
    }
    public void moveRight() {
        center.x += center.xSpeed;
    }
}