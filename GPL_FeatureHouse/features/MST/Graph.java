
import java.lang.Integer; 
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
public class Graph {
    public  Graph Prim( Node node ) {
        Node rootNode;

        rootNode = node;
        Node n;
        for ( NodeItr nodeItr = getNode(); nodeItr.hasNext(); ){
            n = nodeItr.next();
            n.predecessor = null;
            n.key = Integer.MAX_VALUE;
        }
        rootNode.key = 0;
        rootNode.predecessor = null;
        LinkedList Queue = new LinkedList();
        Set index = new HashSet( );
        Queue.add( rootNode );
        index.add( rootNode.getName( ) );
        for ( NodeItr nodeItr = getNode(); nodeItr.hasNext(); ){
            n = nodeItr.next();
            if ( n.key != 0 ){
                Queue.add( n );
                index.add( n.getName( ) );
            }
        }
        Node currentNode;
        int j,l;
        int k=0;
        LinkedList currentNodeNeighbor;
        Node n1,n2;
        EdgeInterface eEdge;
        NeighborInterface nodeNeighborIfc;
        int wuv;
        boolean isNeighborInQueue = false;
        while ( Queue.size()!=0 ){
            n1 = ( Node )Queue.removeFirst();
            index.remove( n1.getName( ) );
            currentNodeNeighbor = n1.getNodeNeighbors( );
            k = 0;
            for( EdgeItr edgeItr = n1.getEdges(); edgeItr.hasNext(); k++ ){
                nodeNeighborIfc = ( NeighborInterface )currentNodeNeighbor.get( k );
                eEdge = edgeItr.next();
                n2 = eEdge.getOtherNode(n1);
                isNeighborInQueue = false;
                if ( index.contains( n2.getName( ) ) )
                    isNeighborInQueue = true;
                wuv = eEdge.getWeight();
                if ( isNeighborInQueue && ( wuv < n2.key ) ){
                    n2.key = wuv;
                    n2.predecessor = n1.getName();
                    currentNodeNeighbor.set( k,nodeNeighborIfc );
                    Object residue = ( Object ) n2;
                    Queue.remove( residue );
                    index.remove( n2.getName( ) );
                    int position = Collections.binarySearch( Queue,n2,new Comparator() {
                        public int compare( Object obj1, Object obj2 ){
                            Node node1 = ( Node )obj1;
                            Node node2 = ( Node )obj2;
                            if ( node1.key < node2.key )
                                return -1;
                            if ( node1.key == node2.key )
                                return 0;
                            return 1;
                        }
                    } );
                    if ( position < 0 ){
                        Queue.add( - ( position+1 ),n2 );
                    }
                    else {
                        Queue.add( position,n2 );
                    }
                    index.add( n2.getName( ) );

                }
            }
        }
        String name;
        Graph newGraph = new  Graph();
        for ( NodeItr nodeItr = getNode( ); nodeItr.hasNext( ); ){
            Node node = nodeItr.next( );
            name = node.name;
            System.out.println("______The Name MST : "+name);
            newGraph.addNode( new  Node().setName( name ) );
        }
        Node nNode, predcsr;
        Node newNode, theNewPred;
        EdgeInterface   e;
        for ( NodeItr nodeItr = getNode( ); nodeItr.hasNext( ); ){
            nNode = nodeItr.next( );
            predcsr = findsNode( nNode.predecessor );
            if ( predcsr==null )
                continue;
            newNode = newGraph.findsNode( nNode.name );
            theNewPred = newGraph.findsNode( predcsr.name );
            EdgeInterface theNewEdge = newGraph.addEdge( theNewPred, newNode );
            e = findsEdge( predcsr,nNode );
            theNewEdge.adjustAdorns( e );
        }
        return newGraph;
    } 
}
