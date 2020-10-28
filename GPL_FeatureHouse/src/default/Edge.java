
import java.util.LinkedList; 
import java.util.Iterator; 
public   class  Edge  extends Neighbor  implements EdgeInterface {
	
	public Node start,end=null;

	
	public void theEdge  (Node startNode, Node endNode){
		start=startNode;
		end=endNode;
	}

	
	public void theEdge  ( Node start,  Node end, int weight ) {
		theEdge( start,end );
	    this.weight = weight;
	}

	
	public Node getStart(){
		return this.start;
	}

	
	public Node getEnd(){
		return this.end;
	}

	
	 private void  display__wrappee__Directed  ( ) {
		 System.out.println( "start Node = " + start.getName() + " end Node = " + end.getName() );
	}

	
    public void display() {
        System.out.print( " Weight= " + getWeight() +" ");
        display__wrappee__Directed();
    }

	
	public void setWeight  (int weight){
        this.weight = weight;
    }

	
    public int getWeight  (){
        return this.weight;
    }

	
    public Node getOtherNode  ( Node node ) {
    	 if(node == start)
             return end;
         else if(node == end)
             return start;
         else
             return null;
    }

	
	public Node getStartNode  () {
		return this.start;
	}

	
	public Node getEndNode  () {
		return this.end;
	}

	
     private void  adjustAdorns__wrappee__Directed  ( EdgeInterface theEdge ) {
    	
    }

	
	public void adjustAdorns( EdgeInterface edge ) {
		setWeight(edge.getWeight());
        adjustAdorns__wrappee__Directed( edge );
//		adjustAdorns( edge );
	}

	
	private int weight;


}
