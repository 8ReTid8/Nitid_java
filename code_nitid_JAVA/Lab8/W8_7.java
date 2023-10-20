import java.util.*;
import java.io.*;

public class W8_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // Number of stations
        int M = Integer.parseInt(st.nextToken()); // Number of subway lines

        List<List<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // Number of stations in this line
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < S; j++) {
                line.add(Integer.parseInt(st.nextToken()));
            }
            lines.add(line);
        }

        int Q = Integer.parseInt(br.readLine()); // Number of queries

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int Ai = Integer.parseInt(st.nextToken());
            int Bi = Integer.parseInt(st.nextToken());

            int ans = findMinLineChanges(N, lines, Ai, Bi);
            if (ans == Integer.MAX_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(ans);
            }
        }
    }

    private static int findMinLineChanges(int N, List<List<Integer>> lines, int Ai, int Bi) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[Ai] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(Ai);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains(current)) {
                    for (int next : lines.get(i)) {
                        if (dist[next] == Integer.MAX_VALUE) {
                            dist[next] = dist[current] + 1;
                            queue.add(next);
                        }
                    }
                }
            }
        }

        return (dist[Bi] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dist[Bi] - 1;
    }
}
