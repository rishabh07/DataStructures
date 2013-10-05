/********** IT REMOVES DUPLICATE CHARACTERS FROM A STRING **********/

package Strings;

import java.util.Scanner;

/**
 *
 * @author rishabh
 */

public class RemoveDupStr {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Text: ");
        String str=sc.nextLine();
        char s[]=str.toCharArray();
        if(s==null)
            return;
        int l=s.length;
        if(l<2)
            return;
        int tail=1;
        for(int i=1;i<l;i++) {
            int j;
            for(j=0;j<tail;j++) {
                if(s[i]==s[j]) {
                    s[i]=0;
                    break;
                }
            }
            if(j==tail) {
                s[tail]=s[i];
                tail++;
            }
        }
        s[tail]=0;
        System.out.println(s.length);
        for(int i=0;i<s.length;i++) {
            System.out.print(s[i]);
        }
    }
}
