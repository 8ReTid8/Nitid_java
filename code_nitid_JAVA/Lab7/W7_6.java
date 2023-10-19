import java.util.*;

class Maze {
    int M, N;
    int[][] maze;
    int startRow, startCol, endRow, endCol;
    int minSteps = Integer.MAX_VALUE;
    int minWallsDestroyed = Integer.MAX_VALUE;
    
    Maze(int M, int N, int[][] maze, int startRow, int startCol, int endRow, int endCol) {
        this.M = M;
        this.N = N;
        this.maze = maze;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }
    
    public void findShortestPath() {
        dfs(startRow, startCol, 0, 0);
        System.out.println(minWallsDestroyed + " " + minSteps);
    }
    
    private void dfs(int row, int col, int steps, int wallsDestroyed) {
        if (row < 0 || row >= M || col < 0 || col >= N || maze[row][col] == -1) {
            return;
        }
        
        if (row == endRow && col == endCol) {
            if (steps < minSteps || (steps == minSteps && wallsDestroyed < minWallsDestroyed)) {
                minSteps = steps;
                minWallsDestroyed = wallsDestroyed;
            }
            return;
        }
        if (maze[row][col] == 1) {
            wallsDestroyed++;
        }
        
        maze[row][col] = -1; 
        dfs(row - 1, col, steps + 1, wallsDestroyed); // North
        dfs(row + 1, col, steps + 1, wallsDestroyed); // South
        dfs(row, col - 1, steps + 1, wallsDestroyed); // West
        dfs(row, col + 1, steps + 1, wallsDestroyed); // East
        maze[row][col] = 0;
    }
}

public class W7_6{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        
        int[][] maze = new int[M][N];
        
        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;
        int endRow = scanner.nextInt() - 1;
        int endCol = scanner.nextInt() - 1;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        
        Maze mazeSolver = new Maze(M, N, maze, startRow, startCol, endRow, endCol);
        mazeSolver.findShortestPath();
    }
}
