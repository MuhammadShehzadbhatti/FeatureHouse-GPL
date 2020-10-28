
import java.util.LinkedList;
import java.util.Iterator;
public class Node {
    public LinkedList neighbors = new LinkedList();
    public Node setName( String name ) {
	    this.name = name;
	    return ( Node ) this; 
	}
    public void addNeighbor( Neighbor nbr ) {
    	neighbors.add( nbr );
    } 
    public NodeItr getNeighbors() {
    	return new NodeItr() {
            private Iterator iter = neighbors.iterator();
            public Node next() { return ((Neighbor)iter.next()).end; }
            public boolean hasNext() { return iter.hasNext(); }
        };
    }
    public EdgeItr getEdges()
    {
        return new EdgeItr()
            {
                private Iterator iter = neighbors.iterator();
                public EdgeInterface next( )
                {
                  return ( ( EdgeInterface ) ( ( Neighbor ) iter.next( ) ).edge );
                }
                public boolean hasNext() { return iter.hasNext(); }
            };
    }
    public void display() {
        System.out.print( " Node " + getName() + " connected to: " );
        for(NodeItr nodeitr = getNeighbors(); nodeitr.hasNext(); )
         {
            Node node = nodeitr.next();
            System.out.print( node.getName() + ", " ); 
        }
        System.out.println();
    }
//    public void adjustAdorns(Neighbor sourceNeighbor) {
//		
//	}
//    public void nodeSearch() {
//        System.out.println(":::::::::::::::::::");
//		
//	}
}
