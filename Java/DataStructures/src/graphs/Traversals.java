package graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Traversals in a graph
 * <ul>
 *     <li>DFS</li>
 *     <li>BFS</li>
 * </ul>
 * <ul>
 *     <li>Strongly connected components are subset of vertices where each vertex can be reached from other vertex if
 *     followed in direction. Only applicable to directed graph</li>
 *     <li>Connected components are components they are connected to each in undirected graph </li>
 * </ul>
 */
public class Traversals {

    /**
     * Queue based
     * <ol>
     *     <li>Find shortest path from a source to other vertices in a unweighted graph</li>
     *     <li>Finding a solution with least moves of a game if all states of game can be represented as nodes</li>
     *     <li>Find shortest cycle in a directed weighted graph, as soon as we reach the source we have found shortest
     *     cycle involving that vertex, now do it for other vertex and find shortest cycle of all</li>
     *     <li>Finding all connected components in a <b>uni-directed</b> graph. We do bfs from each nodes that has already been not visited</li>
     *     <li>Find all vertices & edges on shortest path between two nodes(a,b). For that do two bfs from a and b .
     *     Then let d<sub>a</sub>[] & d<sub>b</sub>[] be two array of shortest distances from a & b respectively.
     *     For each edge (u,v) check if it satisfies d<sub>a</sub>[u]+1+d<sub>b</sub>[v]=d<sub>a</sub>b, to get edges
     *     For each node v check d<sub>a</sub>[v]+d<sub>b</sub>[v]=d<sub>a</sub>b, to get vertices </li>
     *     <li>Find shortest path of even length from source s to t in unweighted graph</li>
     * </ol>
     * @param adj
     * @param s
     * @param size
     */
   public static void bfs(List<List<Integer>> adj, int s, int size){//adjacency list
       Queue<Integer> q = new ArrayDeque<Integer>();
       boolean[] visited = new boolean[size];
       int[] distance = new int[size];
       int[] parent = new int[size];
       q.add(s);
       visited[s]=true;
       parent[s]=-1; // this can help trace path
       distance[s]=0;
       while(!q.isEmpty()){
           int v=q.poll();
           for(int i: adj.get(s))
               if(!visited[i]){
                   q.add(i);
                   visited[i]=true;
                   parent[i]=v;
                   distance[i]=distance[v]+1;
               }

       }

   }

    /**
     * Stack based or recursion
     * <ul>
     *     <li>Tree edge :- All edges in dfs traversal for which v has not been visited  </li>
     *     <li>An edge becomes </li>
     *     <li>Back edge :- Links a node to its ancestor that has already been visited</li>
     *     <li>Forward edge :- Links a node directly to its descendant that has already been visited</li>
     *     <li>Cross edge :- Connects two node that dont share any ancestor-descendant relation in the dfs tree</li>
     *     <li>Forward & Cross edge exist only in directed graph</li>
     * </ul>
     * <ol>
     *     <li>Find any path from source u to v</li>
     *     <li>Find lexicographical first path in graph from u to all vertices</li>
     *     <li>Check if a vertex in a tree is an ancestor of some other vertices. Calculate entry and exit of each node.
     *     If a node i is ancestor of j then then entry[i]<entry[j] & exit[i]>exit[j]</li>
     *     <li>Find LCA</li>
     *     <li>Topographical sorting. Do a series of dfs as to visit each node exactly once. And required sorting would
     *     nodes sorted in descending order of exit time</li>
     *     <li>Check if given graph is acyclic. Counting back edges in all connected components.</li>
     *     <li>Find strongly connected components in a directed graph. First do topographical sort and then do dfs in order
     *     defined by the sort. And component thus created is strongly connected</li>
     *     <li>Find bridges in uni-directed graph. First make it directed by running dfs and make each edge directed as we go
     *     .Second find strongly connected components in directed graph. Bridges are edges belonging to different strongly connected components</li>
     * </ol>
     * @param adj
     * @param size
     * @param visited
     * @param v
     */

   public static void dfsRecursive(List<List<Integer>> adj, int size, boolean[] visited, int v){
       visited[v]=true;
       for(int i : adj.get(v))
           if(!visited[i])
               dfsRecursive(adj,size,visited,i);
   }

    /**
     * Coloring + entry and exit tiems
     * @param adj
     * @param size
     * @param color - 1 if visited, 0 if not visited & 2 if exited
     * @param v
     */

    public static void dfsRecursive(List<List<Integer>> adj, int size, int[] color, int v, int dfsTimer,int timeIn[], int timeOut[]){
        color[v]=1;
        timeIn[v]=dfsTimer++;
        for(int i : adj.get(v))
            if(color[v]==0)
                dfsRecursive(adj,size,color,i,dfsTimer,timeIn,timeOut);
        color[v]=2;
        timeOut[v]=dfsTimer++;
    }
    /**
     * Finding connected components in a graph stack based approach
     */
    public static Stack<Integer> dfsStack(List<List<Integer>> adj, int size, int v  ){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        Stack<Integer> component = new Stack<>();
        boolean visited[] = new boolean[size];
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visited[vertex]){
                component.push(vertex);
                visited[vertex]=true;
                for(int i: adj.get(vertex))
                    stack.push(i);
            }
        }
        return component;

    }
    public static void findConnectedComponents(List<List<Integer>> adj, int size){
        boolean visited[] = new boolean[size];
        for(int i=0;i<size;i++)
            if(!visited[i]) {
                dfsStack(adj, size, i).forEach(System.out::println);
            }
    }


}
