import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Main {
    public static boolean checkForCycle(int[][] adj, int s, boolean[] vis) {
        Queue<Node> q =  new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            for (Integer it : adj[node]) {
                if (!vis[it]) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                } else if (par != -1 && par != it) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++) if(!vis[i]) if(checkForCycle(edges, i,vis)) return "Yes";
        return "No";
    }
    public static void main(String[] args) {
        int[][] edges={{3,2},{1,2},{2,3}};
        System.out.println(cycleDetection(edges, edges.length, edges[0].length));
    }
}