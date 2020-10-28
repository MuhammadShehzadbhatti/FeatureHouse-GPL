
public class Edge implements EdgeInterface{
	private int weight;
	public void theEdge( Node start,  Node end, int weight ) {
		theEdge( start,end );
	    this.weight = weight;
	}
	public void adjustAdorns( EdgeInterface edge ) {
		setWeight(edge.getWeight());
        original( edge );
//		adjustAdorns( edge );
	}
	public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return this.weight;
    }
    public void display() {
        System.out.print( " Weight= " + getWeight() +" ");
        original();
    }
}
