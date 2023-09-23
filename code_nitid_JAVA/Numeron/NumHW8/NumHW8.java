import java.util.Scanner;
public class NumHW8 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("size of data : ");
        Method8 cal = new Method8();
        System.out.println("add data x and f(x) :");
        cal.add();
        System.out.print("how many point you choose : ");
        cal.choosemanyX();
        System.out.print("what x you choose : ");
        cal.addchoosex();
        // cal.c();
        for(int i=1;i<cal.size;i++){
            cal.c[i] = cal.c(cal.fx,cal.x,0,i);
        }
        System.out.print("add x you want to find : ");
        int x = input.nextInt();
        System.out.println("y is "+cal.findy(x));
        for(int i=0;i<cal.size;i++){
            System.out.println(cal.c[i]);
        } 
    }
}
