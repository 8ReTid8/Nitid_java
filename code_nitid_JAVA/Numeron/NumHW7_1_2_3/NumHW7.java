// package NumHW7_1_2_3;
import java.util.Scanner;
public class NumHW7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Method7 math = new Method7();
        int i=1;
        math.add();
        System.out.print("start x : ");
        math.addx();
        System.out.print("choose operation : ");
        int n = input.nextInt();
        if(n==1){
            do{
                System.out.println("iter "+i);
                math.cal();
                // math.seidel();
                for(int j=0;j<math.size;j++){
                    System.out.print(math.x[j]+" ");
                }
                System.out.println("");
                i++;
            }while(math.checkErr());
            for(i=0;i<math.size;i++){
                System.out.println(math.x[i]);
            }
        }
        if(n==2){
            math.R();
            while(math.conjuCheck()){
                System.out.println("iter "+i);
                if(i==1){
                    math.D0();
                }
                else{
                    math.D();
                }
                math.X();
                math.R();
                i++;
            }
            for(i=0;i<math.size;i++){
                System.out.println(math.x[i]);
            }
        }
    }
}
