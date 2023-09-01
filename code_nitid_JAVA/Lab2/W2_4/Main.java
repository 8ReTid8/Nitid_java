
// public class Main {
//     public static void main(String[] args) {
//         int[] a = {1, 2};
//         swap(a[0], a[1]);
//         System.out.println("a[0] = " + a[0]+ " a[1] = " + a[1]);
//     }

//     public static void swap(int n1, int n2) {
//         int temp = n1;
//         n1 = n2;
//         n2 = temp;
//     }
// }


public class Main {
    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        System.out.println("t1's i = " + t1.i + " and j = " + t1.j);
        System.out.println("t2's i = " + t2.i + " and j = " +t2.j);
    }
}

class T {
    static int i = 0;
    int j = 0;
    T(){
        i++;
        j = 1;
    }
}