// package W2_7;

// public class Cal {
//     public double x,y,w,h;
//     public double left,right,top,bottom;
//     public Cal(double x,double y,double w,double h){
//         this.x = x;
//         this.y = y;
//         this.w = w;
//         this.h = h;
//         this.bottom = y+h/2;
//         this.top = y-h/2;
//         this.left = x-w/2;
//         this.right = x+w/2;
//     }
    

    // public void left(){
    //      this.left = (x-w)/2;
    // }
    // public void right(){
    //     this.right = (x+w)/2;
    // }
    // public void top(){
    //     this.top = (y-h)/2;
    // }
    // public void bottom(){
    //     this.bottom =(y+h)/2;
    // }
//}

public class Circle {
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
