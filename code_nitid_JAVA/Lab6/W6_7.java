// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class W6_7 {
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(0, 0, 10, 10);
        MyRectangle2D r2 = new MyRectangle2D(0, 0, 20, 20);

        System.out.println(r1.overlaps(r2));
        System.out.println(r1.contains(r2));
    }
}

class MyRectangle2D {
    double x,y;
    double width, height;
    coord topLeft, topRight, botLeft, botRight;
    MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

        topLeft = new coord(x-width/2, y+height/2);
        topRight = new coord(x+width/2, y+height/2);
        botLeft = new coord(x-width/2, y-height/2);
        botRight = new coord(x+width/2, y-height/2);

    }

    double getX() {
        return x;
    }
    double getY() {
        return y;
    }
    void setX(double x) {
        this.x = x;
    }
    void setY(double y) {
        this.y = y;
    }

    double getArea() {
        return width*height;
    }
    double getPerimeter() {
        return 2*width+2*height;
    }
    boolean contains(double x, double y) {
        return topLeft.x < x &&
                topLeft.y > y &&
                topRight.x > x &&
                topRight.y > y &&
                botLeft.x < x &&
                botLeft.y < y &&
                botRight.x > x &&
                botRight.y < y;
    }
    boolean overlaps(MyRectangle2D r) {
        int counter = 0;
        if (topLeft.x < r.topLeft.x && topLeft.y > r.topLeft.y) {
            counter++;
        }
        if (topRight.x > r.topRight.x && topRight.y > r.topRight.y) {
            counter++;
        }
        if (botLeft.x < r.botLeft.x && botLeft.y < r.botLeft.y) {
            counter++;
        }
        if (botRight.x > r.botRight.x && botRight.y < r.botRight.y) {
            counter++;
        }
        if (counter > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    boolean contains(MyRectangle2D r) {
        int counter = 0;
        if (topLeft.x < r.topLeft.x && topLeft.y > r.topLeft.y) {
            counter++;
        }
        if (topRight.x > r.topRight.x && topRight.y > r.topRight.y) {
            counter++;
        }
        if (botLeft.x < r.botLeft.x && botLeft.y < r.botLeft.y) {
            counter++;
        }
        if (botRight.x > r.botRight.x && botRight.y < r.botRight.y) {
            counter++;
        }
        if (counter == 4) {
            return true;
        }
        else {
            return false;
        }
    }
}
class coord {
    double x;
    double y;

    coord(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
