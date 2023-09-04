import java.util.Scanner;

public class W4_10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt(); // จำนวนเลน
        int n = scanner.nextInt(); // เลนเริ่มต้น
        int t = scanner.nextInt(); // ระยะเวลา

        int[] lanes = new int[m]; // สถานะของถนน

        // อ่านสถานะของถนนตามเวลา
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < m; j++) {
                lanes[j] = scanner.nextInt();
            }

            int choice = chooseLane(lanes, n);
            System.out.println(choice);
            n = choice;
        }

        scanner.close();
    }

    // เลือกเลนในการบังคับรถ
    private static int chooseLane(int[] lanes, int currentLane) {
        int leftLane = currentLane > 1 ? lanes[currentLane - 2] : Integer.MAX_VALUE;
        int rightLane = currentLane < lanes.length ? lanes[currentLane] : Integer.MAX_VALUE;
        int stayLane = lanes[currentLane - 1];

        // หาเลนที่มีสิ่งกีดขวางน้อยที่สุด
        if (leftLane < rightLane && leftLane < stayLane) {
            return currentLane - 1;
        } else if (rightLane < stayLane) {
            return currentLane + 1;
        } else {
            return currentLane;
        }
    }
}
