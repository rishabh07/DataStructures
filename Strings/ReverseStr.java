

package Strings;

import java.util.Scanner;

/**
 *
 * @author rishabh
 */
public class ReverseStr {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str=sc.next();
        
        /********** Reverse using extra space **********/
        String rev="";
        for(int i=str.length()-1; i>=0; i--) {
            rev=rev+str.charAt(i);
        }
        System.out.println("reverse using extra variable : "+rev);
        
        /********** reverse using string buffer class **********/
        StringBuffer a= new StringBuffer(str);
        System.out.println("reverse using Stringbuffer   : "+a.reverse());
        
        /********** IN place reverse by swapping **********/
        char str1[];
        str1=str.toCharArray();
        for(int i=0;i<=str1.length/2;i++) {
            char c=str1[i];
            str1[i]=str1[str1.length-1-i];
            str1[str1.length-1-i]=c;
        } 
        System.out.print("in place reverse             : ");
        for(int i=0;i<str1.length;i++) {
            System.out.print(str1[i]);
        }
        
        /********** reverse using substring function **********/
        for(int i=0;i<str.length()-1;i++) {
            str=str.substring(1, str.length()-i)+str.substring(0,1)+str.substring(str.length()-i);
        }
        System.out.print("\nreverse using substring func.: "+str);
    }
}
