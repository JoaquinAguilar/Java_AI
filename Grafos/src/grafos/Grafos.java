package grafos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafos {

    public static void main(String[] args) {
    
    Stack<String> stack = new Stack();
    stack.add("A");
    stack.add("B");
    stack.add("C");
    stack.add("D");
    
    stack.forEach((s)->{
        System.out.print(s+" ");
    });
    System.out.println("");
    while(stack.size()>0){
        System.out.println("POP >> "+stack.pop()); //Regresa el objeto de la pila y quitarlo
    }
        System.out.println(" ");
        System.out.println(">>>QUEUE<<<");
        
        Queue<String> queue = new LinkedList();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        
        queue.forEach((s)->{
            System.out.print(s+" ");
        });
        System.out.println("");
        while(queue.size()>0){
            System.out.println("POLL >>"+queue.poll()); 
        }
    
    }
    
}
