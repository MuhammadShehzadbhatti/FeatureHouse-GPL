/**
 * TODO description
 */
public interface EdgeInterface {
	public Node getStartNode();
	public Node getEndNode();
    public void display( );
    public int getWeight();

    public Node getOtherNode( Node node );
    public void adjustAdorns( EdgeInterface theEdge );
	
}