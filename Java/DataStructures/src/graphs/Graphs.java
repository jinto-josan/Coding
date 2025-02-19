package graphs;

import java.util.*;

/**
 * Traversals in a graph
 * <ul>
 *     <li>DFS</li>
 *     <li>BFS</li>
 * </ul>
 * <ul>
 *     <li>Strongly connected components are subset of vertices where each vertex can be reached from other vertex if
 *     followed in direction. Only applicable to directed graph</li>
 *     <li>Strong orientation of an undirected graph is an assignment of a direction to each edge that makes it a strong connected graph
 *     and only <b>bridgeless graph</b> can be strongly oriented - Robbin's theorem. So we can solve this by running a DFS
 *     and let the tree edges point away from DFS root and all other edges from descendants to ancestor in DFS tree</li>
 *     <li>Connected components are components they are connected to each other in undirected graph </li>
 *     <li>Bridge is an edge which when removed makes graph disconnected (more connected components formed)</li>
 * </ul>
 */
public class Graphs {

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
     *     <li>An edge <b>that is not part of dfs tree</b> becomes </li>
     *     <li>Back edge :- Links a node to its ancestor that has already been visited </li>
     *     <li>Forward edge :- Links a node directly to its descendant that has already been visited </li>
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

    /**
     * tin[v] is the time when dfs enters v
     * low[v] is the lowest tin of any vertex reachable from v except its parent i.e min(tin(v), tin(p where p is a back edge), low(to where to is tree edge))
     * Bridge is an edge (v,to) such that low[to]>tin[v] where to is a child of v
     * Articulation point or cut edge is a vertex v where low[to]>=tin[v]
     * @param adj
     * @param size
     */

    public static void dfsBridge(List<List<Integer>> adj, int size, int v, boolean[] visited, int parent, int[] tin, int[] low, int timer){
        boolean isParentSkipped=false;
        for(int to : adj.get(v)) {
            if (to == parent && !isParentSkipped) {
                isParentSkipped = true;
                continue;
            }
            if (visited[to]) {
                low[v] = Math.min(low[v], tin[to]);
            } else {
                tin[to] = low[to] = timer++;
                dfsBridge(adj, size, to, visited, v, tin, low, timer);
                low[v] = Math.min(low[v], low[to]);
                if (low[to] > tin[v])
                    System.out.println(v + " " + to);
            }
        }

    }
    public static void dfsArticulationPoint(List<List<Integer>> adj, int size, int v, boolean[] visited, int parent, int[] tin, int[] low, int timer){
        boolean isParentSkipped=false;
        //diff
        int children=0;
        for(int to : adj.get(v)) {
            if (to == parent && !isParentSkipped) {
                isParentSkipped = true;
                continue;
            }
            if (visited[to]) {
                low[v] = Math.min(low[v], tin[to]);
            } else {
                tin[to] = low[to] = timer++;
                dfsArticulationPoint(adj, size, to, visited, v, tin, low, timer);
                low[v] = Math.min(low[v], low[to]);
                //diff
                if (low[to] >= tin[v] && parent!=-1)
                    System.out.println(v + " ");
                children++;
            }
        }
        //diff
        if(parent==-1 && children>1)
            System.out.println(v + " ");


    }

    public static void findBridges(List<List<Integer>> adj, int size){
        int[] tin = new int[size];
        int[] low = new int[size];
        boolean[] visited = new boolean[size];
        dfsBridge(adj,size,0,visited,-1,tin,low,0);

    }
    public static void findArticulationPoint(List<List<Integer>> adj, int size){
        int[] tin = new int[size];
        int[] low = new int[size];
        boolean[] visited = new boolean[size];
        dfsArticulationPoint(adj,size,0,visited,-1,tin,low,0);

    }


    /**
     * Topographical sort, assume graph is asyclic
     * In a directed graph find order that all vertex leads from a smaller index to a larger one. Find a permutation of
     * vertices which corresponds to order defined by all edges of graph.
     * Do multiple dfs and reverse by their exit times (or use stack so that order is lifo)
     *
     * Use stack for topological sort and Vector for no lifo
     */
    public static void dfsTopologicalSort(int v, List<Integer>[] graph, boolean[] visited, Vector<Integer> srtedResult){
        visited[v] = true;
        for(int i : graph[v])
            if(!visited[i])
                dfsTopologicalSort(i,graph,visited,srtedResult);
        srtedResult.add(v);

    }
    public static void topologicalSort(List<Integer>[] graph, int size){

        boolean[] visited= new boolean[size];
        Stack<Integer> sorted=new Stack<>();
        for(int i=0; i< graph.length && !visited[i];i++)
            dfsTopologicalSort(i, graph,visited, sorted);

    }

    /**
     * Strongly connected components in a graph
     * Do a topological sort in reverse order and then do dfs on the transposed graph, that will be strongly connected components
     * Condensed graph is a graph where strongly connected components are connected. So no cycles. {{v1,v2,v3}->{u1,u2},{w3}}
     */
    public  static void findSCC(List<Integer>[] graph, int size){

        boolean[] visited=new boolean[size];
        Vector<Integer> reverseSorted=new Vector<>();

        for (int i=0;i< graph.length && !visited[i];i++)
            dfsTopologicalSort(i,graph,visited,reverseSorted);

        List<Integer>[] transposedGraph=new ArrayList[size];
        int i=0;
        for(List<Integer> list:graph)
            for(int j:list)
                transposedGraph[j].add(i);

        boolean[] transposedVisited=new boolean[size];
        List<Vector<Integer>> components=new ArrayList<>();
        int[] roots=new int[graph.length]; // to store root of each element, and each element will have root as the first value of that component

        Vector<Integer> comp=new Vector<>();
        for(int el:reverseSorted)
            if(!transposedVisited[el]) {
                dfsTopologicalSort(el, transposedGraph, transposedVisited, comp);
                components.add(comp);
                for(var n:comp)
                    roots[n]=comp.get(0);
                comp.clear();
            }


        //Forming condenstation graph
        List<Integer>[] condensedGraph=new ArrayList[graph.length];
        //Now we will map between two roots rather than lists which can be difficult
        for(int n=0;i< graph.length;i++)
            for(int el:graph[n])
                if(roots[n]!=roots[el])
                    condensedGraph[n].add(el);
    }

    /**
     *
     * Finding a graph orientation so that the number of SCC is minimal
     * Remove all bridges temporarily. Now we get some number of bridgeless components, we orient each one of them. And bridges can be oriented in any direction
     * @param graph
     * @param size
     */
    private String findBridgelessOrientation(int v, List<Integer>[] graph, int size, int[] low, int[] tin, boolean[] edgeUsed){
        //Todo: implement
        return "";
    }

    public static void findStrongOriented(List<Integer>[] graph, int size){

    }


}
