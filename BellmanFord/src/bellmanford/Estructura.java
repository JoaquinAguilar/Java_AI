package bellmanford;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Estructura {

    public static void main(String[] args) {
Stack<String> stack = new Stack();
        Queue<String> queue = new LinkedList();
        
        stack.add("A");
        stack.add("B");
        stack.add("C");
        stack.add("D");
        stack.add("E");
        stack.add("F");
        stack.add("G");
        
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        queue.add("F");
        queue.add("G");
        System.out.println(">>>>>>PILA<<<<<<<");
        stack.forEach((s) -> {
                System.out.print(s+" ");
            });
        System.out.println("");
        while(stack.size()>0){
            System.out.println("POP >> "+stack.pop());
        }
        
        System.out.println(">>>>>>COLA<<<<<<<");
        queue.forEach((s) -> {
            System.out.print(s+" ");
        });
        System.out.println("");
        while(queue.size()>0){
            System.out.println("POLL >> "+queue.poll());
        }
    }    
}
