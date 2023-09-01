import java.util.Scanner;

public class W3_6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        
        if(Palin.ispalin(s)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}

class Palin{
    public String s;
 
    Palin(String s){
        this.s = s;
    }
    public static boolean ispalin(String s){
        boolean chk = true;
        s = s.replaceAll("[^a-zA-Z]","");
        int j = s.length()-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(j)){
                chk=false;
            }
            else{
                j--;
            }
        }
        return chk;
    }
    
}