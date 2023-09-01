public class W3_4{
    public static void main(String[] args){
        System.out.println(g("A"));
    }
    public static String f(){
        System.out.println("A");
        return "A";
    }
    public static String g(String s){
        return f()+s;
    }
}

ans เกิดจาก print method g() ที่เก็บ ค่า s กับ f()
    ซึ่ง f() จะ print A และ g() จะ print AA

public class W3_4{
    public static void main(String[] args) {
        int max = 0;
        max(1,2,max);
        System.out.println(max);
    }
    public static void max(int value1,int value2,int max) {
        if (value1 > value2)
            max = value1;
        else
            max = value2;
    }
}

ans = 0 เพราะ ค่าที่ใส่ใน max มันอยู่แค่ใน method max

public class W3_4{
    public static void main(String[] args) {
        int i = 0;
        while (i <= 4) {
            method1(i);
            i++;
        }
        System.out.println("i is " + i);
    }
    public static void method1(int i) {
        do {
            if (i % 3 != 0)
            System.out.print(i + " ");
            i--;
        }
        while (i >= 1);
        System.out.println();
    }
}

ans ลูปตัวเลข 4 ครั้งตั้งแต่ 0 แล้วเข้า method ว่าค่าของเลขตั้งแต่แรกลดลงถึง 0
    ว่า หาร 3 ไม่ลงตัวมั้ยถ้าใช่ ให้ print ค่านั้น