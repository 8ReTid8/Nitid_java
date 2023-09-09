import java.util.Scanner;
public class W2_9{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n=1;
        Primenum a = new Primenum();
        while(n!=0){
            n = input.nextInt();
            a.setX(n);
            a.checkP();
            a.Pmax();
        }
        System.out.println(a.ansP());
    }
}
class Primenum{
    private int x,prime = -1;
    
    void setX(int x){
        this.x = x;
    }

    void checkP(){
        if(x==1){
            this.x = -1;
        }
        for(int i=2;i<=x;i++){
            if(x%i==0&&x!=i){
                this.x = -1;    
                break;
            }
            else{
                this.x = x;
            }
        }
    }
    
    void Pmax(){
        if(prime<x&&x!=0){
            this.prime = x;
        }
    }

    public int ansP(){
        return prime;
    }
}