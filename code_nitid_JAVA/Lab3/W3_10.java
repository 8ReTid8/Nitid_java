import java.util.Scanner;

public class W3_10{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int ship = input.nextInt();
        int laser = input.nextInt();
        boom a = new boom(ship,laser);
        a.shiplong();
        a.laserpoint();
        a.shipboom();
    }
}

class boom{
    Scanner input = new Scanner(System.in);
    public int n,ship,laser;
    public int[][] shiplong; 
    public int[] lasershot;
    
    public boom(int x,int y){
        ship = x;
        laser = y;
        shiplong = new int[x][2];
        lasershot = new int[y];
    }
    void shiplong(){
        for(int i=0;i<ship;i++){
            for(int j=0;j<2;j++){
                shiplong[i][j] = input.nextInt();
            }
        }
    }
    void laserpoint(){
        for(int i=0;i<laser;i++){
            lasershot[i] = input.nextInt();
        }
    }

    void shipboom(){
        for(int i=0;i<ship;i++){
            for(int j=0;j<laser;j++){
                if(shiplong[i][1]>lasershot[j]&&shiplong[i][0]<lasershot[j]){
                    n++;
                }
            }
        }
        System.out.println(n);
    }

}