
package HashTable;

/**
 *
 * @author rishabh
 */

import java.util.Scanner;

class Node {
    int key;
    int value;
    Node left,right;
}

class hashTable {
    Node[] hashBST=new Node[10];
    Node root;
    Node[] arr;
    int count=0,max,min,n=0;
    
    public int hashCode(int num) {
        return num%10;
    }
    
    public void insert(int key,int value) {
        int hc=hashCode(key);
        root=hashBST[hc];
        if(root==null) {
            hashBST[hc]=new Node();
            hashBST[hc].key=key;
            hashBST[hc].value=value;
            count++;
        }
        else {
            insertion(root,key,value);
        }
    }
    
    public void insertion(Node node,int key,int value) {
        if(key<=node.key) {
            if(node.left!=null)
                insertion(node.left,key,value);
            else {
                node.left=new Node();
                node.left.key=key;
                node.left.value=value;
                count++;
            }
        }
        else {
            if(node.right!=null)
                insertion(node.right,key,value);
            else {
                node.right=new Node();
                node.right.key=key;
                node.right.value=value;
                count++;
            }
        }
    }
    
    public void remove(int key) {
        arr=new Node[100];
        int hc=hashCode(key);
        if(hashBST[hc]!=null) {
            traverse(hashBST[hc]);
            hashBST[hc]=null;
            for(int i=0;i<arr.length;i++) {
                if(arr[i]!=null) {
                    if(arr[i].key!=key)
                        insert(arr[i].key,arr[i].value);
                }
            }
        }
        else
            System.out.println("There are no elements for entered key!!");
    }
    
    public void traverse(Node node) {
        if(node.left!=null)
            traverse(node.left);
        arr[n]=node;
        n++;
        if(node.right!=null)
            traverse(node.right);
    }
    
    public void displayAll() {
        System.out.println("Key:		Value:");
        if(count!=0) {
            for(int i=0;i<10;i++) {
                if(hashBST[i]!=null) {
                    display(hashBST[i]);
                    System.out.println("\n");
                }
            }
        }
        else
            System.out.println("Tree is Empty");
    }
    
    public void display(Node node) {
        if(node.left!=null)
            display(node.left);
        System.out.println(node.key+"\t\t"+node.value);
        if(node.right!=null)
            display(node.right);
    }
    
    public int minimum(int key) {
        min=maximum(key);
        int hc=hashCode(key);
        if(hashBST[hc]!=null)
            return minimum(hashBST[hc]);
        System.out.println("No Elements");
        return 0;
    }
    
    public int minimum(Node node) {
        if(node.left!=null)
            minimum(node.left);
        if(min>node.value)
            min=node.value;
        if(node.right!=null)
            minimum(node.right);
        return min;
    }
    
    public int maximum(int key) {
        int hc=hashCode(key);
        if(hashBST[hc]!=null)
            return maximum(hashBST[hc]);
        System.out.println("No Elements");
        return 0;
    }
    
    public int maximum(Node node) {
        if(node.left!=null)
            maximum(node.left);
        if(max<node.value)
            max=node.value;
        if(node.right!=null)
            maximum(node.right);
        return max;
    }
}

public class HT {
    public static void main(String[] args) {
        hashTable ht=new hashTable();
        int choice=0,key,value;
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("\n1.Insert\n2.Remove\n3.Find Minimum\n4.Find Maximum\n5.Display\n6.Exit");
            choice=sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter the key:");
                    key=sc.nextInt();
                    System.out.print("Enter the value:");
                    value=sc.nextInt();
                    ht.insert(key, value);
                    break;
                case 2:
                    System.out.print("Enter the key:");
                    key=sc.nextInt();
                    ht.remove(key);
                    break;
                case 3:
                    System.out.print("Enter the key:");
                    key=sc.nextInt();
                    if(ht.minimum(key)>=0)
                        System.out.println("Minimum value: "+ht.minimum(key));
                    break;
                case 4:
                    System.out.print("Enter the key:");
                    key=sc.nextInt();
                    if(ht.maximum(key)>=0)
                        System.out.println("Maximum value: "+ht.maximum(key));
                    break;
                case 5:
                    System.out.println("Elements: ");
                    ht.displayAll();
                    break;
                case 6:
                    System.exit(1);
            }
        }
    }
}


