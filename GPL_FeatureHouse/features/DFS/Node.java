/**
 * TODO description
 */
public class Node {
	Node node;
    public void nodeSearch( CommonSearch cs ){
//        Node node;
        cs.preVisitAction( ( Node ) this );
        if ( visited )
            return;
        visited = true;
        this.display();
        for ( NodeItr  nodeitr = getNeighbors(); nodeitr.hasNext(); ){
            node = nodeitr.next( );
            System.out.print(" "+node.name+" ");
            cs.checkNeighborAction( ( Node ) this, node );
            node.nodeSearch( cs );
        }
       cs.postVisitAction( ( Node ) this );
    } 
    public void display(){
//    	System.out.println("_____________DFS_____________");
        if ( visited )
            System.out.print( " DFS visited" +"  ");
        else
            System.out.print( " DFS !visited" );
        original();
//        display( );
    }
}