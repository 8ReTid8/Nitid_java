public class W6_8 {
    public static void main(String[] args) {

        // contains method
        coord c1 = new coord(4, 10);
        Rectangle r1 = new Rectangle(10, 15, c1);

        coord c2 = new coord(1, 2);
        Rectangle r2 = new Rectangle(5, 5, c2);

        coord c3 = new coord(5, 5);
        coord c4 = new coord(6, 5);
        Line l1 = new Line(c3, c4);

        System.out.println(contains(l1, r1));


        // cross method
        coord c5 = new coord(1, 1);
        coord c6 = new coord(5, 5);
        Line l2 = new Line(c5, c6);

        coord c7 = new coord(5, 1);
        coord c8 = new coord(1, 5);
        Line l3 = new Line(c7, c8);

        System.out.println(cross(l2, l3));

        // overlaps method
        System.out.println(overlaps(r1, r2));

        // distance method
        System.out.println(distance(l1, r1));

    }

    public static boolean inside(Rectangle a, coord b) {
        if (b.x > a.topleft.x && b.y < a.topleft.y &&
            b.x < a.topright.x && b.y < a.topright.y &&
            b.x > a.botleft.x && b.y > a.botleft.y &&
            b.x < a.botright.x && b.y > a.botright.y ) {
            return true;
        }
        return false;
    }
    public static int contains(Line a, Rectangle b) {
        if (inside(b, a.start) && inside(b, a.end)) {
            return 1;
        }
        return 0;
    }
    public static int cross(Line a, Line b) {
        if (a.start.x <= b.end.x && a.end.x >= b.start.x && a.start.y <= b.end.y && a.end.y >= b.start.y) {
            return 1;
        } else {
            return 0;
        }
    }
    public static boolean overlaps(Rectangle a, Rectangle b) {
        int counter = 0;
        if (a.topleft.x < b.topleft.x && a.topleft.y > b.topleft.y) {
            counter++;
        }
        if (a.topright.x > b.topright.x && a.topright.y > b.topright.y) {
            counter++;
        }
        if (a.botleft.x < b.botleft.x && a.botleft.y < b.botleft.y) {
            counter++;
        }
        if (a.botright.x > b.botright.x && a.botright.y < b.botright.y) {
            counter++;
        }
        return counter > 0;
    }
    public static double distance(Line a, Rectangle b) {
        coord centerA = new coord((a.start.x+a.end.x)/2, (a.start.y+a.end.y)/2);
        coord centerB = new coord(b.width/2, b.height/2);

        return Math.sqrt(Math.pow((centerA.x)-(centerB.x),2)+Math.pow((centerA.y)-(centerB.y),2));
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

class Rectangle {
    coord topleft, topright, botleft, botright;
    double width;
    double height;

    Rectangle() {
        topleft = new coord(0, 0);
        width = 0;
        height = 0;
    }
    Rectangle(double width, double height, coord pos) {
        this.width = width;
        this.height = height;

        topleft = pos;
        topright = new coord(topleft.x+width, topleft.y);
        botleft = new coord(topleft.x, topleft.y-height);
        botright = new coord(topleft.x+width, topleft.y-height);
    }
    double getArea() {
        return width*height;
    }
}

class Line {
    coord start;
    coord end;

    Line() {
        start = new coord(0,0);
        end = new coord(0, 0);
    }
    Line(coord p1, coord p2) {
        start = p1;
        end = p2;
    }
    double getLong() {
        return Math.sqrt(Math.pow((start.x)-(end.x),2)+Math.pow((start.y)-(end.y),2));
    }
}