import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
public class Graph {
	public boolean isDirected = true;
	private LinkedList edgeList;
	public Graph(){
//		original();
		edgeList=new LinkedList();
	} 
	public void sortEdges(Comparator c) {
        Collections.sort(edgeList, c);
    }
	public EdgeInterface addEdge(Node start,Node end,int weight) {
		Edge edge=new Edge();
		edge.theEdge(start, end, weight);
		edgeList.add(edge); 
		start.addNeighbor(new Neighbor(end, edge));
		display();
		return edge;
	}
	public EdgeInterface addEdge(Node start,Node end) {
		Edge edge=new Edge();
		edge.theEdge(start, end);
		edgeList.add(edge); 
		start.addNeighbor(new Neighbor(end, edge));
		display();
		return edge;
	}
	public Node findsNode(String nodeName) {
		Node node=null;
		for (NodeItr nodeItr=getNode();nodeItr.hasNext();) {
			node=nodeItr.next();
			if (node.getName()==nodeName) {
				return node;
			}
		}
		return null; 
	}
	public EdgeItr getEdges() {
		return new EdgeItr() {
		    private Iterator iter = edgeList.iterator();
			public EdgeInterface next() { return (EdgeInterface)iter.next(); }
			public boolean hasNext() { return iter.hasNext(); }
	    };
	}

	public void display() { 
	//		    	 int i;
		System.out.println( "--Directed Graph Nodes--" );
		System.out.println( "Nodes " );
		for ( NodeItr nodeiter = getNode(); nodeiter.hasNext() ; )
			nodeiter.next().display();
		System.out.println( "--Directed Graph Edge--" );
		System.out.println( "Edges " );
		for ( EdgeItr edgeiter = getEdges(); edgeiter.hasNext(); )
			edgeiter.next().display();
	}
	public Graph Prim(Node node) {
		return null;
	}

	public void shortestPath() {
		
	}
}
