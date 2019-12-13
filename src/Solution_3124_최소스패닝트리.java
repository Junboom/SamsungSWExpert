import java.io.*;
import java.util.*;

public class Solution_3124_최소스패닝트리 {

    public static class Edge {
        int[] node;
        long distance;

        Edge(int a, int b, long c) {
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

    public static void merge(Edge[] edge, int s, int e, int m) {
        Edge[] ret = new Edge[e-s+1];
        int i = s;
        int j = m + 1;
        int copy = 0;

        while (i <= m || j <= e) {
                 if (m < i)     ret[copy++] = edge[j++];
            else if (e < j)     ret[copy++] = edge[i++];
            else if (edge[i].distance <= edge[j].distance)
                ret[copy++] = edge[i++];
            else if (edge[j].distance <  edge[i].distance)
                ret[copy++] = edge[j++];
        }

        for (int k = 0; k < copy; ++k)
            edge[s+k] = ret[k];
    }

    public static void mergeSort(Edge[] edge, int s, int e) {
        if (s < e) {
            int m = (s + e) / 2;

            mergeSort(edge, s, m);
            mergeSort(edge, m+1, e);

            merge(edge, s, e, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t_c = 1; t_c <= T; ++t_c) {
            // 입력값 받기, V = 노드, E = 간선
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 간선 등록, arr 사용
            Edge[] edge = new Edge[E];
            for (int e = 0; e < E; ++e) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                long C = Long.parseLong(st.nextToken());

                edge[e] = new Edge(A, B, C);
            }

            // 간선을 오름차순으로 정렬, Merge Sort 사용
            mergeSort(edge, 0, E - 1);

            // 노드 arr 생성
            int[] arr = new int[V+1];
            for (int v = 1; v <= V; ++v) {
                arr[v] = v;
            }

            // 간선을 돌면서 가장 짧은 간선만을 선택하는 Kruskal을 사용해 연결
            long ans = 0;
            int connectEdge = 0;
            for (int i = 0; i < E; ++i) {
                if (find(arr, edge[i].node[0], edge[i].node[1])) {
                    ans += edge[i].distance;
                    unionParent(arr, edge[i].node[0], edge[i].node[1]);
                    connectEdge += 1;
                }
                if (connectEdge == V - 1)  break;
            }

            System.out.println("#" + t_c + " " + ans);
        }

    }

}
