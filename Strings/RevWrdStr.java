

package Strings;

import java.util.Scanner;

/**
 *
 * @author rishabh
 */
public class RevWrdStr {
    public static void main(String args[]) {
        System.out.print("Enter a sentence : ");
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        System.out.println("Entered sentence : "+sentence);
        String[] words = sentence.split(" ");
        sentence="";
        for(int i=words.length-1;i>=0;i--) {
            sentence=sentence+words[i]+" ";
        }
        System.out.println("Reversed sentence: "+sentence);
    }
}
