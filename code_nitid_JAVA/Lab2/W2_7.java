import java.util.Scanner;
public class W2_7{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i;
        System.out.println("Enter r1's center x-, y-coordinates, width, and height: ");
        double[] sq1 = new double[4];
        for(i=0;i<4;i++){
            sq1[i] = input.nextDouble();
        }
        double[] sq2 = new double[4];
        Circle square1 = new Circle(sq1[0],sq1[1],sq1[2],sq1[3]);
        System.out.println("Enter r2's center x-, y-coordinates, width, and height: ");
        for(i=0;i<4;i++){
            sq2[i] = input.nextDouble();
        }
        Circle square2 = new Circle(sq2[0],sq2[1],sq2[2],sq2[3]);
        square2.inside(square1);
    }
}
class Circle {
    //variable in class
    public double x;
    public double y;
    public double wid;
    public double hei;
    public double left;
    public double right;
    public double top;
    public double bottom;
    public double topleft_x;
    public double topleft_y;
    public double topright_x;
    public double topright_y;
    public double bottomleft_x;
    public double bottomleft_y;
    public double bottomright_x;
    public double bottomright_y;
    public int corner;
    //constructor
    Circle(double x, double y,double wid, double hei){
        this.x = x;
        this.y = y;
        this.wid = wid;
        this.hei = hei;
        this.left = this.x -(this.wid/2);
        this.right = this.x +(this.wid/2);
        this.top = this.y + (this.hei/2);
        this.bottom = this.y - (this.hei/2);
        this.topleft_x = this.left;
        this.topleft_y = this.top;
        this.topright_x = this.right;
        this.topright_y = this.top;
        this.bottomleft_x = this.left;
        this.bottomleft_y = this.bottom;
        this.bottomright_x = this.right;
        this.bottomright_y = this.bottom;
    }
    //method
    void inside(Circle r){
        //(1)
        if((this.topleft_x >= r.left)&&(this.topleft_x <= r.right)){
            if((this.topleft_y >= r.bottom)&&(this.topleft_y <= r.top)){
                this.corner++;
            }
        }
        if((this.topright_x >= r.left)&&(this.topright_x <= r.right)){
            if((this.topright_y >= r.bottom)&&(this.topright_y <= r.top)){
                this.corner++;
            }
        }
        if((this.bottomleft_x >= r.left)&&(this.bottomleft_x  <= r.right)){
            if((this.bottomleft_y >= r.bottom)&&(this.bottomleft_y  <= r.top)){
                this.corner++;
            }
        }
        if((this.bottomright_x >= r.left)&&(this.bottomright_x  <= r.right)){
            if((this.bottomright_y >= r.bottom)&&(this.bottomright_y  <= r.top)){
                this.corner++;
            }
        }
        if(this.corner == 4){
            System.out.println("r2 is inside r1");
        }else if(this.corner < 4 && this.corner > 0){
            System.out.println("r2 is overlaps with r1");
        }
    }
}
