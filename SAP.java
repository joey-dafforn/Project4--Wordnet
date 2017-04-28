import java.util.ArrayDeque;
import java.util.Deque;

public class SAP {

    private Digraph myGraph;

    //constructor
    public SAP(Digraph G) {
        // SAP must be immutable:
        this.myGraph = new Digraph(G);
    }

    //return length of shortest ancestral path of v and w; -1 if no such path
    public int length(int v, int w) {
        //do error checking to see if
        BreadthFirstDirectedPaths path1 = new BreadthFirstDirectedPaths(myGraph, v);
        BreadthFirstDirectedPaths path2 = new BreadthFirstDirectedPaths(myGraph, w);
        int ancestor = ancestor(v, w);
        int pathLength;
        if (ancestor == -1) {
            pathLength = -1;
        }
        else {
            pathLength = path1.distTo(ancestor) + path2.distTo(ancestor);
        }
        return pathLength;
    }

    //return a common ancestor of v and w that participates in a shortest
    //ancestral path, -1 is no such path
    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths path1 = new BreadthFirstDirectedPaths(myGraph, v);
        BreadthFirstDirectedPaths path2 = new BreadthFirstDirectedPaths(myGraph, w);
        int shortestAncestor = -1;
        int shortestPath = Integer.MAX_VALUE;
        Deque<Integer> ancestors = new ArrayDeque<Integer>();

        for (int i = 0; i < this.G.V(); i++) {
            if (path1.hasPathTo(i) && path2.hasPathTo(i)) {
                ancestors.push(i);
            }
        }

        for (Integer integer : ancestors) {
            if ((path1.distTo(integer) + path2.distTo(integer)) < shortestPath) {
                shortestPath = (path1.distTo(integer) + path2.distTo(integer));
                shortestAncestor = integer;
            }
        }
        return shortestAncestor;

    }
}

public static void main(String[] args) {
    //args[1] contains digraphX.txt
    //args[2] contains digraphX.input
    //using .txt, construct digraph
    //using .input, see if there is a shortest path
}