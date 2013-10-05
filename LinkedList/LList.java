
package LinkedList;

import java.util.Scanner;

/**
 *
 * @author rishabh
 */


class LLNode {
    int key;
    LLNode next;
    LLNode(int key) {
        this.key=key;
    }
}

public class LList {
    LLNode temp, first;
    int size;
    
    LList() {
        temp=null;
        first=null;
        size=0;
    }
    
    public void insert(int key) {
        LLNode data=new LLNode(key);
        if(first==null) {
            first=data;
            temp=data;
            //temp.next=temp;
        }
        else {
            temp=first;
            while(temp.next!=null) {
                temp=temp.next;
            }
            temp.next=data;
            //temp.next.next=first;
        }
        size++;
    }
    
    public void remove(int key) {
        if(size==0) {
            System.out.println("\nEmpty LL");
            return;
        }
        temp=first;
        if(temp.key==key) {
            first=first.next;
            size--;
            return;
        }
        else {
            while(temp.next!=null) {
                if(temp.next.key==key) {
                    if(temp.next.next==null) {
                        temp.next=null;
                        size--;
                        return;
                    }
                    temp.next=temp.next.next;
                    size--;
                    return;
                }
                temp=temp.next;
            }
        }
        System.out.println("\nElement Not Found");
    }
    
    public boolean hasLoop() {
        LLNode slow=first;
        LLNode fast=first;
        while(fast!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                return true;
            }
        }
        return false;
    }
    
    public void disp() {
        temp=first;
        while(temp!=null) {
            System.out.print(temp.key+" ");
            temp=temp.next;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        LList ll=new LList();
        while(true) {
            System.out.print("\n1. Insert\n2. Remove\n3. Display\n4. hasLoop\nCHOICE: ");
            int ch=sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.println("\nEnter A Number: ");
                    int num=sc.nextInt();
                    ll.insert(num);
                    break;
                case 2:
                    System.out.println("\nEnter A Number: ");
                    num=sc.nextInt();
                    ll.remove(num);
                    break;
                case 3:
                    ll.disp();
                    break;
                case 4:
                    System.out.println(ll.hasLoop());
                    break;
                default :
                    System.exit(0);
            }
        }
    }
}