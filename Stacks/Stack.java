

package Stacks;

import java.util.Scanner;

/**
 *
 * @author rishabh
 */

public class Stack {
    Object arr[];
    int size, top;
    
    //CONSTRUCTOR//
    Stack(int n) {
        size=n;
        top=-1;
        arr=new Object[size];
    }
    
    //PUSH THE ELEMENT INTO STACK//
    public void push(int n) {
        top++;
        if(top<size) {
            arr[top]=n;  
        }
        else
            System.out.println("\nSTACK Is Full");
    }
    
    //POP THE ELEMENT FROM STACK//
    public void pop() {
        if(top>-1) {
            top--;
            System.out.println("\nDeleted Element: "+arr[top+1]);
        }
        else
            System.out.println("\nEmpty Stack");
    }
    
    //DISPLAY THE ELEMENTS IN STACK//
    public void disp() {
        if(top>-1) {
            for(int d=top; d>=0; d--) {
                System.out.println("|"+arr[d]+"|");
            }
        }
        else
            System.out.println("\nEmpty Stack");
    }
    
    //DISPLAY THE PEEK ELEMENT//
    public void peek() {
        if(top>-1)
            System.out.println("\nPeek Element: "+arr[top]);
        else
            System.out.println("\nEmpty Stack");
    }
    
    //DISPLAYS IF STACK IS EMPTY OR NOT//
    public void isEmpty() {
        if(top==-1)
            System.out.println("\nEmpty");
        else
            System.out.println("\nNot Empty");
    }
    
    //main METHOD//
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("\nEnter Size of Array: ");
        int n=sc.nextInt();
        Stack stack=new Stack(n);
        while(true) {
            System.out.print("\n1. Push\n2. Pop\n3. Display\n4. Peek\n5. IsEmpty\nCHOICE: ");
            int ch=sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("Enter Number: ");
                    int num=sc.nextInt();
                    stack.push(num);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.disp();
                    break;
                case 4:
                    stack.peek();
                    break;
                case 5:
                    stack.isEmpty();
                    break;
                default:
                    System.exit(0);                    
            }
        }
    }
}
