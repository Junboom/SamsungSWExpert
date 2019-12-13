import java.io.*;
import java.util.*;

public class Solution_3124_최소스패닝트리 {

    public static class Edge {
        int[] node;
        int distance;

        Edge(int a, int b, int c) {
            node = new int[2];
            node[0] = a;
            node[1] = b;
            distance = c;
        }
    }

    public static int getParent(int[] arr, int i) {
        if (arr[i] == i)    return i;
        return arr[i] = getParent(arr, arr[i]);
    }

    public static void unionParent(int[] arr, int i1, int i2) {
        i1 = getParent(arr, i1);
        i2 = getParent(arr, i2);

        if (i1 < i2)    arr[i2] = i1;
        else            arr[i1] = i2;
    }

    public static boolean find(int[] arr, int i1, int i2) {
        i1 = getParent(arr, i1);
        i2 = getParent(arr, i2);

        if (i1 == i2)   return false;
        else            return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t_c = 1; t_c <= T; ++t_c) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Edge> edge = new ArrayList<>();
            for (int e = 0; e < E; ++e) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                edge.add(new Edge(A, B, C));
            }
            Collections.sort(edge, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    if (o1.distance == o2.distance)
                        return 0;
                    return (o1.distance > o2.distance) ? 1 : -1;
                }
            });

            int[] arr = new int[V+1];
            for (int v = 1; v <= V; ++v) {
                arr[v] = v;
            }

            long ans = 0;
            for (int i = 0; i < V; ++i) {
                if (find(arr, edge.get(i).node[0], edge.get(i).node[1])) {
                    ans += edge.get(i).distance;
                    unionParent(arr, edge.get(i).node[0], edge.get(i).node[1]);
                }
            }
            System.out.println("#" + t_c + " " + ans);
        }
    }

}
