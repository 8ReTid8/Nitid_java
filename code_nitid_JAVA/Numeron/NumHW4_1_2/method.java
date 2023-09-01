import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
class method{
    DecimalFormat format = new DecimalFormat("#.##");
    Scanner input = new Scanner(System.in);
    public int row,colum;
    public double[][] matrix,copy,inver,Low,Up;
    public double[] x,y,b;
    
    public method(){
        row = input.nextInt();
        colum = input.nextInt();
        matrix = new double[row][colum];
        copy = new double[row][colum];
        inver = new double[row][colum];
        Low = new double[row][colum];
        Up = new double[row][colum];
        x = new double[row];
        y = new double[row];
        b = new double[colum];
    }

    public void matrix_input(){
        for(int i=0;i<row;i++){
            for(int j=0;j<colum;j++){
                matrix[i][j] = input.nextDouble();
            }
        }
    }

    public void Binput(){
        for(int i=0;i<row;i++){
            b[i]=input.nextDouble();
        }
    }

    public void matrix_copy(){
        for(int i=0;i<row;i++){
            inver[i][i] = 1;
            Up[i][i] = 1;
            for(int j=0;j<colum;j++){
                copy[i][j] = matrix[i][j];
            }       
        }
    }

    // DET
    public double det(double[][] matrix){
        double det = 0;
        for(int i=0;i<row;i++){
            double minus = 1,head = 1;
            for(int j=0;j<row;j++){
                head *= matrix[j][(i+j)%row];
                minus *= matrix[row-j-1][(i+j)%row];
            }
            det += head - minus;
        }
        return det;
    }    

    // GAUSS
    public void gauss(){
        matrix_copy();
        for (int i = 0; i < row; ++i) {
            for (int j = i + 1; j < row; ++j) {
                double ratio = copy[j][i] / copy[i][i];
                for (int k = 0; k < row; ++k) {
                    copy[j][k] -= ratio * copy[i][k];
                }
                b[j] -= ratio * b[i];
            }
        }

        for(int i=row-1;i>=0;i--){
            for(int j=i+1;j<row;j++){
                 b[i] -= copy[i][j]*x[j];
            }
            x[i] = b[i]/copy[i][i];
            System.out.println(Math.ceil(x[i]));
        }
    }

    // GAUSS_JORDAN
    public void gauss_jordan(){
        matrix_copy();
        for (int i = 0; i < row; ++i) {
            for (int j = i + 1; j < row; ++j) {
                // double ratio = copy[j][i] / copy[i][i];
                double keep = copy[j][i];
                for (int k = 0; k < row; ++k) {
                    // copy[j][k] -= ratio*copy[i][k];
                    copy[j][k] -= (copy[i][k]/copy[i][i])*keep;
                }
                // b[j] -= ratio * b[i];
                b[j] -= (b[i]/copy[i][i])*keep;
            }
        }
     
        for (int i = row-1; i >= 0; --i) {
            for (int j = i-1; j >= 0; --j) {
                // double ratio = copy[j][i] / copy[i][i];
                double keep = copy[j][i];
                for (int k = row-1; k >= 0; --k) {
                    copy[j][k] -= (copy[i][k]/copy[i][i])*keep;
                    // copy[j][k] -= copy[i][k]*ratio;
                }
                // b[j] -= ratio*b[i];
                b[j] -= (b[i]/copy[i][i])*keep;
            }
        }

        for(int i=row-1;i>=0;i--){   
            x[i] = b[i]/copy[i][i];
            System.out.println(Math.ceil(x[i]));
        }  
    }

    // CRAMER
    public void cramer(){
        System.out.println(det(matrix));
        for(int i=0;i<row;i++){
            matrix_copy();
            for(int j=0;j<row;j++){
                copy[j][i] = b[j];
            }
            x[i] = det(copy)/det(matrix);
            System.out.printf("%.0f\n",x[i]);            
        }
    }

    // INVERSION
    public void inversion(){
        matrix_copy();
        for (int i = 0; i < row; ++i) {
            for (int j = i + 1; j < row; ++j) {
                double keep = copy[j][i];
                for (int k = 0; k < row; ++k) {
                    copy[j][k] -= (copy[i][k]/copy[i][i])*keep;
                    inver[j][k] -= (inver[i][k]/copy[i][i])*keep;
                }
            }
        }
        
        for (int i = row-1; i >= 0; --i) {
            for (int j = i-1; j >= 0; --j) {
                double keep = copy[j][i];
                for (int k = row-1; k >= 0; --k) {
                    copy[j][k] -= (copy[i][k]/copy[i][i])*keep;
                    inver[j][k] -= (inver[i][k]/copy[i][i])*keep;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                inver[i][j] /= copy[i][i];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                System.out.print(inver[i][j]+" ");
            }
            System.out.println("");
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                x[i] += b[j]*inver[i][j];
            }   
            System.out.println(Math.ceil(x[i]));
        }  
    }
    
    // LU
    public void LU(){
        matrix_copy();
        // find L U
        for (int i = 0; i < row; i++){
            int index = 0;
            for (int j = 0; j < i+1; j++){
                double sum = 0;
                for (int k = 0; k < row; k++)
                    sum += (Low[i][k] * Up[k][j]);
                Low[i][j] = copy[i][j] - sum;
                index++;
            }
 
            for (int j = index; j < row; j++){
                double sum = 0;
                for (int k = 0; k < row; k++)
                    sum += (Low[i][k] * Up[k][j]);
 
                Up[i][j] = (copy[i][j] - sum) / Low[i][i];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                System.out.print(Low[i][j]+" ");
            }
            System.out.println("");
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                System.out.print(Up[i][j]+" ");
            }
            System.out.println("");
        }
        // find LY=B
        for(int i=0;i<row;i++){
            double sum = 0;
            for(int j=0;j<row;j++){
                sum += Low[i][j]*y[j];
            }
            y[i] = (b[i]-sum)/Low[i][i];
        }
        // find UX=Y
        for(int i=row-1;i>=0;i--){
            double sum = 0;
            for(int j=0;j<row;j++){
                sum += Up[i][j]*x[j];
            }
            x[i] = y[i]-sum;
            System.out.println(Math.ceil(x[i]));
        }
    } 
}

// for(int i=0;i<row;i++){
//     for(int j=0;j<row;j++){
//         System.out.print(inver[i][j]+" ");
//     }
//     System.out.println("");
// }