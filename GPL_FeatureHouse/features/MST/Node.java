
import java.lang.Integer; 
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
public class Node {
    public String predecessor;
    public int key; 
    public void display( ){
        System.out.print( " Pred " + predecessor + " Key " + key + " " );
        original();
    }
}
