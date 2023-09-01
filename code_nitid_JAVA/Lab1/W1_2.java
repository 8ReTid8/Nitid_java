public class W1_2{
    public static void main(String[] args){
        int i;
        System.out.print("Enter the monthly saving amount: 100\n");
        double a = 0;
        for(i=0;i<6;i++){
            a = (100 + a)*(1 + 0.00417);
        }
        System.out.print(String.format("After the sixth month, the account value is %.2f",a));
    }
}