
package Queues;

import java.util.Scanner;

/**
 *
 * @author rishabh
 */

public class Queues {
    Object arr[];
    int size, front, pos;
    
    Queues(int n) {
        size=n;
        pos=-1;
        arr=new Object[n];
    }
    
    //TO ENTER THE ELEMENTS IN THE QUEUE//
    public void enqueue(int num) {
        pos++;
        if(pos<size)
            arr[pos]=num;
        else
            System.out.println("\nQueue Is Full");
    }
    
    //TO REMOVE ELEMENTS FROM THE QUEUE//
    public void dequeue() {
        if(pos>-1) {
            System.out.println("\nDequed element: "+arr[0]);
            for(int i=0,j=i+1; i<size-1; i++, j++) {
                arr[i]=arr[j];
            }
            arr[pos]=null;
            pos--;
        }
        else
            System.out.println("\nEmpty Queue");       
    }
    
    //TO DISPLAY ELEMENTS PRESENT IN QUEUE//
    public void disp() {
        if(pos>-1){
            for(int i=pos; i>=0; i--) {
                System.out.println("|"+arr[i]+"|");
            }
        }
        else
            System.out.println("\nEmpty Queue");
    }
    
    //TO DISPLAY IF QUEUE IS EMPTY OR NOT//
    public void isEmpty() {
        if(pos==-1)
            System.out.println("\nEmpty");
        else
            System.out.println("\nNot Empty");
    }
    
    //main METHOD//
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("\nEnter Size of Array: ");
        int n=sc.nextInt();
        Queues stack=new Queues(n);
        while(true) {
            System.out.print("\n1. Enqueue\n2. Dequeue\n3. Display\n4. IsEmpty\nCHOICE: ");
            int ch=sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("Enter Number: ");
                    int num=sc.nextInt();
                    stack.enqueue(num);
                    break;
                case 2:
                    stack.dequeue();
                    break;
                case 3:
                    stack.disp();
                    break;
                case 4:
                    stack.isEmpty();
                    break;
                default:
                    System.exit(0);                    
            }
        }
    }
}
