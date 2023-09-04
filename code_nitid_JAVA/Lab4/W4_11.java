import java.util.Scanner;

public class W4_11{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int m = scanner.nextInt(); // จำนวนแถว
            int n = scanner.nextInt(); // จำนวนคอลัมน์

            if (m == 0) {
                break; // ถ้า m เป็น 0 ให้จบการทำงาน
            }

            char[][] grid = new char[m][n]; // สร้าง GRID

            // อ่านข้อมูล GRID
            for (int i = 0; i < m; i++) {
                String row = scanner.next();
                grid[i] = row.toCharArray();
            }

            // นับจำนวนบ่อน้ำมัน
            int oilPockets = countOilPockets(grid);

            System.out.println(oilPockets);
        }

        scanner.close();
    }

    // ฟังก์ชันนับบ่อน้ำมัน
    private static int countOilPockets(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        // ตรวจสอบทุกช่องใน GRID
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '@') {
                    // พบบ่อน้ำมัน
                    count++;
                    // เริ่มตรวจสอบบ่อน้ำมันในพื้นที่ที่เชื่อมกัน
                    floodFill(grid, i, j);
                }
            }
        }

        return count;
    }

    // ฟังก์ชันทำการลบบ่อน้ำมันและบ่อน้ำมันที่เชื่อมโยง
    private static void floodFill(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // ตรวจสอบขอบเขต
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '@') {
            return;
        }

        grid[i][j] = '*';

        floodFill(grid, i - 1, j);
        floodFill(grid, i + 1, j);
        floodFill(grid, i, j - 1);
        floodFill(grid, i, j + 1);
        floodFill(grid, i - 1, j - 1);
        floodFill(grid, i - 1, j + 1);
        floodFill(grid, i + 1, j - 1);
        floodFill(grid, i + 1, j + 1);
    }
}
