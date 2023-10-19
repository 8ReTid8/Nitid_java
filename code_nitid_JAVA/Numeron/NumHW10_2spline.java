
public class NumHW10_2spline {
    public static void main(String[] args){
        double x[] = {2,4,6,8,10};
        double fx[] = {9.5,8,10.5,39.5,72.5};
        int size = 9;
        int head=0;
        int butt = 2;
        double cal = 4.5;
        double a=0;
        double mat[][] = new double[size][size];
        double ans[] = new double[size];
        default0(mat,size,ans);
        for(int i=0;i<x.length-1;i++){
            if(i>butt){
                head++;
                butt++;
            }
            if(x[i]<=cal&&cal<=x[i+1]){
                
                add(x,fx,mat,ans,head);
                gauss(size,ans,mat);
                // a= (ans[((head+i)*3)%9]*Math.pow(cal,2)+ans[(((head+i)*3)+1)%9]*cal+ans[(((head+i)*3)+2)%9]);
                if(0==i-head){
                    a = ans[0]*Math.pow(cal,2)+ans[1]*cal+ans[2];
                }
                if(1==i-head){
                    a = ans[3]*Math.pow(cal,2)+ans[4]*cal+ans[5];
                }
                if(2==i-head){
                    a = ans[6]*Math.pow(cal,2)+ans[7]*cal+ans[8];
                }
                // a = ans[6]*Math.pow(cal,2)+ans[7]*cal+ans[8];

                break;
            }
        }
        System.out.println(a);
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<9;i++){
            System.out.println(ans[i]);
        }
        System.out.println(head);
    }
  
    public static void default0(double[][] m,int size,double[] a){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                m[i][j] = 1e-9;
            }
        }
    }
    public static void gauss(int size,double[] a,double[][] m){
        
        for (int i = 0; i < size; i++) {
            double fix = m[i][i]; 
          
            if (fix == 0) {
                fix = 1e-9;
            }
        
            for (int j = i; j < size; j++) {
                m[i][j] /= fix;
            }
            a[i] /= fix;
        
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                double factor = m[j][i];
                for (int k = i; k < size; k++) {
                    m[j][k] -= factor * m[i][k];
                }
                a[j] -= factor * a[i];
            }
        }
        
    }
    public static void add(double[] x,double[] fx,double m[][],double a[],int head){
        m[0][0] = x[head+1]*x[head+1];
        m[0][1] = x[head+1];
        m[0][2] = 1;
        m[1][3] = x[head+1]*x[head+1];
        m[1][4] = x[head+1];
        m[1][5] = 1;
        m[2][3] = x[head+2]*x[head+2];
        m[2][4] = x[head+2];
        m[2][5] = 1;
        m[3][6] = x[head+2]*x[head+2];
        m[3][7] = x[head+2];
        m[3][8] = 1;
        m[4][0] = x[head]*x[head];
        m[4][1] = x[head];
        m[4][2] = 1;
        m[5][6] = x[head+3]*x[head+3];
        m[5][7] = x[head+3];
        m[5][8] = 1;
        m[6][0] = -2*x[head+1];
        m[6][1] = -1;
        m[6][3] = 2*x[head+1];
        m[6][4] = 1;
        m[7][3] = -2*x[head+2];
        m[7][4] = -1;
        m[7][6] = 2*x[head+2];
        m[7][7] = 1;
        m[8][0] = 1;
        for(int i=0;i<2;i++){
            a[i] = fx[head+1];
        }
        for(int i=2;i<4;i++){
            a[i] = fx[head+2];
        }
        a[4] = fx[head];
        a[5] = fx[head+3];
    }
}
