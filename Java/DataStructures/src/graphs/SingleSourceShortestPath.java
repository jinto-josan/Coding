package graphs;

public class SingleSourceShortestPath {

    /**
     * Given a directed or undirected graph, a source vertex ‘s’ and a weight function w(u, v) associated with every edge u-v,
     * the shortest path from ‘s’ to ‘v’ is the minimum weighted path from vertex ‘s’ to vertex ‘v’.
     */


    /**
     * Dijkstra's Algorithm
     * Main assertion is that after any vertex v is visited, the current distance of v is the shortest path from s to v, and it will not change.
     * So each vertex is visited only once.
     * At each iteration , a vertex v is selected which is an unmarked vertex with the smallest distance d[v].
     * Relaxation is done for all the edges from (v,to) are considered and for each vertex algorithm tries to improve value d[to].
     * d[to]=min(d[to],d[v]+w(v,to))
     * @param graph matrix representation of graph because we have to get weight of edges
     *              graph[i][j] = weight of edge from i to j
     * @param source source vertex
     */
    public static void dijkstra(int[][] graph, int source, int destination) {
        int n = graph.length;
        int[] distance = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        // Initialize distance array with infinity except source vertex
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        for (int i = 0; i < n; i++) {
            // Find the vertex with minimum distance and is not visited
            // Also v is initialized with -1 so that it can be assigned with first unvisited vertex before checking condition
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (v == -1 || distance[j] < distance[v])) {
                    v = j;
                }
            }
            visited[v] = true;
            for (int to = 0; to < n; to++) {
                // Relaxation step, also check if there is an edge from v to to
                if (graph[v][to] != 0) {
                    distance[to] = Math.min(distance[to], distance[v] + graph[v][to]);
                    parent[to] = v;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Distance from " + source + " to " + i + " is " + distance[i]);
        }
        printPath(parent, destination);

    }
    private static void printPath(int[] parent, int v) {
        if (v == -1) {
            return;
        }
        printPath(parent, parent[v]);
        System.out.print(v + " ");
    }



}
