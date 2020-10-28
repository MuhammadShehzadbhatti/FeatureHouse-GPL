
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	Node source=null;
	Node target=null;
	public void shortestPath(Node from, Node to) {
		Node n=null;
         LinkedList queue = new LinkedList();
        LinkedList visited = new LinkedList();
        for (NodeItr nodeItr=getNode();nodeItr.hasNext();) {
        	Node node=nodeItr.next();
			if (node==from)
				source=from;
			else if(node==to)
				target=to;
        }
        Node trgtNode=null;
//        System.out.println("source find null : "+source.name);
        source.shortestDistance=0;
        queue.add(source);

//    	System.out.print("source in SP : " +source.name );
//        for ( NodeItr nodeItr = getNode(); nodeItr.hasNext(); )
//        {
//            Node nn = nodeItr.next();
//        	if (source!=nn) {
//                queue.add( nn );
//			}
//        }
//        System.out.println("queue length " +queue.size());
		Node previous=source;
        while(!queue.isEmpty()) {
        	Node currentNode=(Node)queue.poll();
        	if (!visited.contains(currentNode)) {
        		visited.add(currentNode);
//			}
        	int weight=0;
//        	while(trgtNode!=target) {
	        	for (EdgeItr edgeItr = currentNode.getEdges(); edgeItr.hasNext();) {
					EdgeInterface edge=edgeItr.next();
					weight=edge.getWeight();
					trgtNode=edge.getOtherNode(currentNode);
	//	        		System.out.println("visited in SP : "+currentNode.name);
					int distanceFromeU = currentNode.shortestDistance + weight;
					if (distanceFromeU < trgtNode.shortestDistance) {
						trgtNode.shortestDistance = distanceFromeU;
						trgtNode.prnt = currentNode;
						queue.add(trgtNode);
					}
				}
	        	
        	}
        }
        
//        return null;
	}
}