
import java.util.LinkedList; 
public   class  Neighbor  implements NeighborInterface {
	
	public Node end  ;

	
    public Edge edge  ;

	
        
    public Neighbor  () {
        end = null;
        edge = null;
    
        end = null;
        edge = null;
    }

	
        
    public Neighbor  ( Node endNode,  Edge edge ) {
        end = endNode;
        this.edge = edge;
    
        end = endNode;
        this.edge = edge;
//        System.out.println("My Sorce Node "+edge.getStartNode() +" Source Node neighbor "+end);
    }

	
	public Node neighbor;


}
