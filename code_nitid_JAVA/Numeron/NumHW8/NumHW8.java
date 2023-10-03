import java.util.Scanner;

public class NumHW8 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("size of data : ");
        Method8 cal = new Method8();
        System.out.println("add data x and f(x) :");
        cal.add();
        while(true){
            System.out.print("how many point you choose : ");
            cal.choosemanyX();
            System.out.print("what x you choose : ");
            cal.addchoosex();
            System.out.print("what method you choose : ");
            System.out.flush();
            String s = input.nextLine();
            System.out.print("add x you want to find : ");
            double x = input.nextDouble();
            input.nextLine();
            if(s.equals("d")){
                // cal.c();
                for(int i=1;i<cal.size;i++){
                    cal.c[i] = cal.c(cal.fx,cal.x,0,i);
                }
                System.out.println("y is "+cal.findy(x));
                for(int i=0;i<cal.size;i++){
                    System.out.println(cal.c[i]);
                }
            }
            if(s.equals("l")){
                cal.l_and_y(x);
                System.out.println("y is "+cal.y);
                for(int i=0;i<cal.size;i++){
                    System.out.println(cal.l[i]);
                }
            }
            if(s.equals("s")){
                for(int i=0;i<cal.size-1;i++){
                    if(cal.x[i]<=x&&x<=cal.x[i+1]){
                        System.out.println(cal.linearspline(x,i));
                        System.out.println(cal.m(i));
                        break;
                    }
                }
            }
        }
    }
}
