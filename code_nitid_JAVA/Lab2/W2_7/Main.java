// package W2_7;
// import java.util.Scanner;
// public class Main {
//     public static void main(String[] args){
//         double[] a = new double[4];
//         Scanner input = new Scanner(System.in);
//         for(int i=0;i<4;i++){
//             a[i] = input.nextDouble();
//         }
//         Cal r2 = new Cal(a[0],a[1],a[2],a[3]);

//         for(int i=0;i<4;i++){
//             a[i] = input.nextDouble();
//         }
//         Cal r1 = new Cal(a[0],a[1],a[2],a[3]);
//        System.out.println(r1.left);
//        System.out.println(r2.right);
//        System.out.println(r1.right);
//        System.out.println(r2.left);
//        System.out.println(r1.top);
//        System.out.println(r2.bottom);
//        System.out.println(r1.bottom);
//        System.out.println(r2.top);
//         if((r2.left>=r1.left)&&(r2.right<=r1.right)&&(r2.top>=r1.top)&&(r2.bottom<=r1.bottom)){
//             System.out.print("r2 is in r1");
//         }
//         else if((r1.left>=r2.right)||(r1.right>=r2.left)||(r1.top>=r2.bottom)||(r1.bottom>=r2.top)){
//             System.out.print("the two are inside");
//         }
//         else{
//             System.out.print("nethier inside");
//         }
//     }
// }

import java.util.Scanner;
public class Main{
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
