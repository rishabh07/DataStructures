

package LinkedList;

/**
 *
 * @author rishabh
 */

import LinkedList.LLNode;
import LinkedList.LList;

public class LLReverse {
    public static void main(String args[]) {
        LList ll=new LList();
        int a[]={2,5,3,8,6,1,9,4,7};
        for(int i=0;i<a.length;i++) {
            ll.insert(a[i]);
        }
        System.out.print("List   : ");
        ll.disp();
        
        LLNode curr=ll.first;
        ll.first=null;
        while(curr!=null) {
            LLNode temp=curr;
            curr=curr.next;
            temp.next=ll.first;
            ll.first=temp;
        }
        System.out.print("\nreverse: ");
        ll.disp();    
    }
}
