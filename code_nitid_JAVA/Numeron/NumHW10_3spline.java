public class NumHW10_3spline {
  
        public static void main(String[] args) {
            double[] x = {2, 4, 6, 8, 10};
            double[] y = {9.5, 8, 10.5, 39.5, 72.5};
    
            double[][] arr = {
                    {64, 16, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 64, 16, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 216, 36, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 216, 36, 6, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 512, 64, 8, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 512, 64, 8, 1},
                    {8, 4, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1000, 100, 10, 1},
                    {-48, -8, -1, 0, 48, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, -108, -12, -1, 0, 108, 12, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, -192, -16, -1, 0, 192, 16, 1, 0},
                    {-24, -2, 0, 0, 24, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, -36, -2, 0, 0, 36, 2, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, -48, -2, 0, 0, 48, 2, 0, 0},
                    {12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 2, 0, 0},
            };
    
            double x_target = 4.5;
            int start = 0;
            int size = 16;
    
            for (int i = 1; i < size; i++) {
                if (x_target > x[i - 1] && x_target < x[i]) {
                    start = i - 1;
                    break;
                }
            }
    
            double[] answer = {8, 8, 10.5, 10.5, 39.5, 39.5, 9.5, 72.5, 0, 0, 0, 0, 0, 0, 0, 0};
    
            for (int i = 0; i < size; i++) {
                double fixed = arr[i][i];
    
                if (fixed == 0) {
                    boolean swapped = false;
                    for (int j = i + 1; j < size; j++) {
                        if (arr[j][i] != 0) {
                            swapRows(arr, i, j);
                            swapRows(answer, i, j);
                            swapped = true;
                            break;
                        }
                    }
                    if (!swapped) {
                        System.out.println("Error: Matrix is not invertible");
                        return;
                    }
                    fixed = arr[i][i];
                }
    
                for (int j = i; j < size; j++) {
                    arr[i][j] /= fixed;
                }
                answer[i] /= fixed;
    
                for (int j = 0; j < size; j++) {
                    if (i == j) continue;
                    double factor = arr[j][i];
                    for (int k = i; k < size; k++) {
                        arr[j][k] -= factor * arr[i][k];
                    }
                    answer[j] -= factor * answer[i];
                }
            }
    
            double y_interpolation = answer[start * 4 + 0] * Math.pow(x_target, 3) +
                    answer[start * 4 + 1] * Math.pow(x_target, 2) +
                    answer[start * 4 + 2] * x_target +
                    answer[start * 4 + 3];
    
            System.out.println(y_interpolation);
        }
    
        public static void swapRows(double[][] matrix, int row1, int row2) {
            double[] temp = matrix[row1];
            matrix[row1] = matrix[row2];
            matrix[row2] = temp;
        }
    
        public static void swapRows(double[] array, int row1, int row2) {
            double temp = array[row1];
            array[row1] = array[row2];
            array[row2] = temp;
        }
    
}
