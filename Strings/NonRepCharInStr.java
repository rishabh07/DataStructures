

package Strings;

import java.util.Scanner;

/**
 *
 * @author rishabh
 */

public class NonRepCharInStr {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str=sc.next();
        for(int i=0;i<str.length();i++) {
            int temp=0;
            for(int j=0;j<str.length();j++) {
                if(str.charAt(i)==str.charAt(j)){
                    temp=temp+1;
                }
            }
            if(temp==1) {
                System.out.println(str.charAt(i));
                return;
            }
        }
    }
}
