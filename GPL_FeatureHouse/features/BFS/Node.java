/**
 * TODO description

 */
import java.util.LinkedList;
public class Node {
	public boolean visited = false;
	Node n;
    public void nodeSearch( CommonSearch cs ){
//	    int     s, c;
	    Node  head;
	    Node  node; 
        cs.preVisitAction( ( Node ) this );
        if (visited ){
            return;
        }
        
        visited = true;
        this.display();
        cs.postVisitAction( ( Node ) this );

        for ( NodeItr nodeItr = getNeighbors( ); nodeItr.hasNext( ); )
        {
            node = nodeItr.next( );
            if ( !node.visited )
            {
            	SharedVariablesContainer.queueList.add( node );
            }

        } // end of for
        //if queue is not null
        while( SharedVariablesContainer.queueList.size( )!= 0 )
        {
            head = ( Node ) SharedVariablesContainer.queueList.get( 0 );
            SharedVariablesContainer.queueList.remove( 0 );
            head.nodeSearch( cs );
//            System.out.println("visit in while ;"+head.visited);
        }
    }
    public void display( )
    {
    	
//    	System.out.println("_____________BFS_____________");
        if ( visited )
            System.out.print( " BFS visited" );
        else
            System.out.print( " BFS !visited" );
    	original();
//        display( );
        
    }
}