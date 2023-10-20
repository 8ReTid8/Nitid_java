class Thread1 extends Thread {
    Thread1(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " ");
        }
    }
}

public class W11_2and3 {
    public static void main(String args[]) {
        new Thread1("A").start();
        new Thread1("B").start();
    }
}
// 2. มันจะทำงาน print ค่า A B 10 จำนวนแบบสุ่มไม่ขึ้นอยู่กับว่าจะเรียกตัวไหนทำงานก่อน ตามการทำงานของ thread 
// 3. บรรทัดที่ 28 มีการสร้าง Thread ใหม่ชื่อ gameThread โดยหลักการทำงานคือ จะขยับ position ของบอลตลอดเวลา เมื่ออยู่ในจุดขอบของจอจะคูณ -1 ให้ทิศสลับกลับไปทางตรงข้าม ทำให้บอลเด้งไปมาอยู่ในหน้าจอ โดยทุกครั้งที่มีการเปลี่ยน position จะมีการ repaint() ภาพบอลขึ้นจอ โดยการทำงานทั้งหมดเกิดขึ้นทุกๆ 0.3 วินาที