
public class Graph {
	public boolean CycleCheck() {
//		boolean isDirected=false;
		Cyclic cycle = new Cyclic(isDirected);
        GraphSearch( cycle );
//        System.out.println("Initial node : " +cyclic.isCycle);
        
        return cycle.isCycle;
    }
}