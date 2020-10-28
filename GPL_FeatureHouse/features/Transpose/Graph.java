/**
 * TODO description

 */
import java.util.HashMap;


//Transpose
public  class Graph {
	public  Graph ComputeTranspose( Graph graph )
	   {
	        String name;
	        HashMap newNodesCollection = new HashMap( );

	        Graph newGraph = new  Graph();

	        for ( NodeItr nodeItr = getNode(); nodeItr.hasNext(); )
	        {
	            name = nodeItr.next().getName();
	            Node node = new  Node( ).setName( name );
	            newGraph.addNode( node );
	            newNodesCollection.put( name, node );
	        }

	        Node node,newNode=null;
	        Node neighbor;
	        Node newAdjacent;
	        EdgeInterface newEdge;
	        int nodeWeight=0;

	        // adding transposed edges
	        NodeItr newNodeItr = newGraph.getNode( );
	        //nodes
	        for ( NodeItr nodeItr = getNode(); nodeItr.hasNext(); ){
	             node = nodeItr.next();
	            newAdjacent = newNodeItr.next( );
	            //neighbors
	            for( NodeItr neighbors = node.getNeighbors(); neighbors.hasNext(); ) {
	                neighbor = neighbors.next();
//	                for(EdgeItr edgeItr = newAdjacent.getEdges(); edgeItr.hasNext();) {
//	                	newEdge=edgeItr.next();
//	                	nodeWeight=newEdge.getWeight();
//	                }
	                newNode = ( Node ) newNodesCollection.get( neighbor.getName( ) );
	                newEdge = newGraph.addEdge( newNode, newAdjacent );
//	                System.out.println("Transposed Source: "+newEdge.getStartNode().getName()+" Traget: " +newEdge.getEndNode().getName() );
	            } 
		      } 	       
//	        display();
	        return newGraph;

	    } 
}