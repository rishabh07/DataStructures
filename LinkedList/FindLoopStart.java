
//program to find starting of loop in a circular linked list //

package LinkedList;

/**
 *
 * @author rishabh
 */

public class FindLoopStart {
    public static void main(String args[]) {
        LList ll=new LList();
        int a[]={2,5,3,8,6,1,9,4,7};
        for(int i=0;i<a.length;i++) {
            ll.insert(a[i]);
        }
        ll.disp();
        LLNode slow=ll.first, fast=ll.first;
        while(fast.next!=null) {
            fast=fast.next;
            if(fast.next!=null)
                fast=fast.next;
            slow=slow.next;
        }
        fast.next=slow;
        findLoop(ll.first);
        //System.out.println("\nCircular\n");
        //ll.disp();
    }
    
    public static void findLoop(LLNode node){
        int flag=0;
        LLNode fast=node, slow=node;
        while(fast.next!=null) {
            fast=fast.next;
            if(fast.next!=null)
                fast=fast.next;
            slow=slow.next;
            if(fast==slow){
                flag=1;
                break;
            }
        }
        if(flag==1) {
            slow=node;
            while(slow!=fast) {
                slow=slow.next;
                fast=fast.next;
            }
            System.out.println("\nLoopStart: "+slow.key);
        }
    }
}
