// 2.1 
// บรรทัดที่ 1 สร้าง class ที่ implement libary cloneable กับ compable
// บรรทัดที่ 2-4 สร้าง private มา สามตัว ที่มีค่า เป็น int กับ double และ date
// บรรทัดที่ 5-9 สร้าง constuctor เก็บตัว แปร id area when built
// บรรทัดที่ 10-18 สร้าง method เรียกใช้ตัวแปร private ที่เก็บค่าไว้ 
// บรรทัดที่ 21-28 เขียนทับ method ของ cloneable ทำการ clone ทุกอย่างของ class นั้น
// บรรทัดที่ 30-37 เขียนทับ method ของ comparable ทำการเทียบ area ของ class บ้าน

// 2.2

public class W8_2{
    public static void main(String[] args){
        House house1 = new House(1, 1750.50);
        House house2 = (House)house1.clone();
        System.out.println(house1.compareTo(house2));
    }
}


class House implements Cloneable, Comparable<House> {
    private int id;
    private double area;
    private java.util.Date whenBuilt;

    public House(int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new java.util.Date();
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public java.util.Date getWhenBuilt() {
        return whenBuilt;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(House o) {
        if (area > o.area)
            return 1;
        else if (area < o.area)
            return -1;
        else
            return 0;
    }
}