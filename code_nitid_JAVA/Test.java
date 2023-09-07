import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt(); // จำนวนเลน col
        int n = input.nextInt(); // เลนเริ่มต้น row
        int t = input.nextInt(); // ระยะเวลา

        int[][] road = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                road[i][j] = input.nextInt();
            }
        }

        int[] actions = new int[t]; // บันทึกการกระทำในแต่ละช่วงเวลา
        int currentLane = n - 1; // เริ่มต้นที่เลน n (0-based index)

        for (int time = 0; time < t; time++) {
            // ตรวจสอบสถานะเลนปัจจุบัน
            int currentLaneStatus = road[currentLane][0];
            boolean hasObstacle = (currentLaneStatus == 1);

            if (currentLane > 0) {
                int leftLaneStatus = road[currentLane - 1][0];
                if (leftLaneStatus == 0 && !hasObstacle) {
                    // เปลี่ยนเลนไปทางซ้าย
                    currentLane--;
                    actions[time] = 1;
                }
            }

            if (currentLane < m - 1) {
                int rightLaneStatus = road[currentLane + 1][0];
                if (rightLaneStatus == 0 && !hasObstacle) {
                    // เปลี่ยนเลนไปทางขวา
                    currentLane++;
                    actions[time] = 2;
                }
            }

            // หากไม่มีการเปลี่ยนเลน หรือไม่มีทางเลือก ให้ยืนอยู่ในเลนเดิม
            if (actions[time] == 0) {
                actions[time] = 3;
            }
        }

        // แสดงผลลัพธ์การบังคับรถ
        for (int action : actions) {
            System.out.println(action);
        }
    }
}