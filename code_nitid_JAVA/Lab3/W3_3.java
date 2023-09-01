public class W3_3{

    a. int i=m(1,1);
    public static int m(int x,int y){
    }

    b. float f=m(Math.exp(5));
    public static float m(float x){

    }

    c. String s=m(2f,8d);
    public static String m(float x,double y){
        
    }

    d. CsStudent l = m("John","K.","Wick");
    public static CsStudent m(String x,String y,String z){
        return new CsStudent(x,y,z);
    }
    class CsStudent{

    }

    e. for(double d=1; d<=256; d*=2) m(d);

    for(double d=1; d<=256; d*=2){
        m(d);
    }
    public static void m(double d){

    }


}