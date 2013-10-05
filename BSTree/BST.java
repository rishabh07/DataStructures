package BSTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/********** BST **********/

/**
 *
 * @author rishabh
 */

class Node {
    Node parent, left, right;
    int data;
    Node(int data) {
        this.data=data;
    }
    public String toString() {
        return ""+data;
    }
}

public class BST {
    static Node root;
    
    /********** INSERT **********/
    public static void insert(int data) {
        root=insert(root,data);
    }
    public static Node insert(Node node,int data) {
        if(node==null) {
            node=new Node(data);
        }
        else if(data<node.data) {
            node.left=insert(node.left,data);
            node.left.parent=node;
        }
        else {
            node.right=insert(node.right,data);
            node.right.parent=node;
        }
        return node;
    }
    
    /********** DELETE **********/
    public static void swap(Node a, Node b) {
        if(a.parent==null) {
            root=b;
        }
        else if(a==a.left.parent) {
            a.left.parent=b;
        }
        else {
            a.right.parent=b;
        }
    }
    public static void delete(int data) {
        delete(root,data);
    }
    public static void delete(Node node,int data) {
        if(node==null){
            return;
        }
        else if(data==node.data) {
            if(node.left==null) {
                swap(node,node.left);
            }
            else if(node.right==null) {
                swap(node,node.right);
            }
            else {
                Node midNode= node.right;
                while(midNode.left!=null) {
                    midNode=midNode.left;
                }
                if(midNode.parent!=node) {
                    swap(midNode,midNode.right);
                    midNode.right=node.right;
                    midNode.right.parent=midNode;
                }
                swap(node,midNode);
                midNode.left=node.left;
                midNode.left.parent=midNode;
            }
        }
        else if(data<node.data) {
            delete(node.left,data);
        }
        else {
            delete(node.right,data);
        }
    }
    
    /********** LOOKUP **********/
    public static boolean lookup(int data) {
        return lookup(root,data);
    }
    public static boolean lookup(Node node,int data) {
        if(node==null)
            return false;
        else if(data==node.data) {
            return true;
        }
        else if(data<node.data) {
            return lookup(node.left,data);
        }
        else {
            return lookup(node.right,data);
        }
    }
    
    /********** SIZE **********/
    public static int size() {
        return size(root);
    }
    public static int size(Node node) {
        if(node==null) {
            return 0;
        }
        int leftSize=size(node.left);
        int rightSize=size(node.right);
        int size=leftSize+rightSize+1;
        return size;
    }
    
    /********** HEIGHT **********/
    public static int height() {
        return height(root);
    }
    public static int height(Node node) {
        if(node==null) {
            return 0;
        }
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        int height=leftHeight>rightHeight?leftHeight+1:rightHeight+1;
        return height;
    }
    
    /********** MIN VALUE **********/
    public static int minVal() {
        return minVal(root);
    }
    public static int minVal(Node node) {
        if(node==null) {
            return 0;
        }
        Node cursor=node;
        while(cursor.left!=null) {
            cursor=cursor.left;
        }
        return cursor.data;
    }
    
    /********** MAX VALUE **********/
    public static int maxVal() {
        return maxVal(root);
    }
    public static int maxVal(Node node) {
        if(node==null) {
            return 0;
        }
        Node cursor=node;
        while(cursor.right!=null) {
            cursor=cursor.right;
        }
        return cursor.data;
    }
    
    /********** INORDER **********/
    public static void inOrder() {
        inOrder(root);
    }
    public static void inOrder(Node node) {
        if(node==null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    
    /********** PATH **********/
    private static String path(int data) {
        return path(root,data);
    }
    static String path="";
    private static String path(Node node,int data) {
        
        if(node==null) {
            return null;
        }
        else if(data==node.data) {
            path=path+node.data;
            String path1=path;
            path="";
            return path1;
        }
        else if(data<node.data) {
            path=path+node.data+"->";
            return path(node.left,data);
        }
        else {
            path=path+node.data+"->";
            return path(node.right,data);
        }
    }
    
    /********** COMMON ANCESTOR **********/
    public static int LCA(int data1,int data2) {
        return LCA(root,data1,data2);
    }
    static int ancestor;
    public static int LCA(Node node,int data1,int data2) {
        if(node==null) {
            return 0;
        }
        if(data1<node.data || data2<node.data) {
            if(data1>node.data || data2>node.data) {
                ancestor=node.data;
                return ancestor;
            }
        }
        if(data1<node.data && data2<node.data) {
            return LCA(node.left,data1,data2);
        }
        else {
            return LCA(node.right,data1,data2);
        }
    }
    
    /********** LevelOrder **********/
    public static void LOT() {
        LOT(root);
    }
    public static void LOT(Node node) {
        Node temp;
        Queue queue=new LinkedList();
        if(node==null) {
            return;
        }
        queue.add(node);
        while(!queue.isEmpty()) {
            temp=(Node) queue.remove();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        queue.removeAll(queue);
    }
    
    /********** LevelOrder ZIG ZAG **********/
    public static void LOTZigZag() {
        LOTZigZag(root);
    }
    public static void LOTZigZag(Node node) {
        Node temp;
        boolean LtoR=true;
        Stack currentLevel=new Stack();
        Stack nextLevel=new Stack();
        if(node==null) {
            return;
        }
        currentLevel.push(node);
        while(!currentLevel.isEmpty()) {
            temp=(Node) currentLevel.pop();
            if(temp!=null) {
                System.out.print(temp.data+" ");  
                if(LtoR) {
                    nextLevel.push(temp.left);
                    nextLevel.push(temp.right);
                }
                else {
                    nextLevel.push(temp.right);
                    nextLevel.push(temp.left);
                }
            }
            if(currentLevel.isEmpty()) {
                System.out.print("\n");
                LtoR=!LtoR;
                Stack tempo=currentLevel;
                currentLevel=nextLevel;
                nextLevel=tempo;
            }
        }
    }
    
    /********** MAIN FUNCTION **********/
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        while(true) {
            System.out.print("\n*************\n     BST     \n*************\n  1. INSERT\n  2. DELETE\n  3. DISPLAY\n  4. SIZE\n  5. HEIGHT\n  6. MINVAL\n  7. MAXVAL\n  8. PATH\n  9. Ancestor\n  10.LOT\n  11. ZigZag\n*************\nCHOICE: ");
            int ch=sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("\nEnter The Number: ");
                    int data=sc.nextInt();
                    insert(data);
                    break;
                case 2:
                    System.out.print("\nEnter The Number: ");
                    data=sc.nextInt();
                    delete(data);
                    break;
                case 3:
                    inOrder();
                    break;
                case 4:
                    System.out.println("\nSize: "+size());
                    break;
                case 5:
                    System.out.println("\nHeight: "+height());
                    break;
                case 6:
                    System.out.println("\nMinValue: "+minVal());
                    break;
                case 7:
                    System.out.println("\nMaxValue: "+maxVal());
                    break;
                case 8:
                    System.out.print("\nEnter The Number: ");
                    data=sc.nextInt();
                    System.out.println("\nPath: "+path(data));
                    break;
                case 9:
                    System.out.print("\nEnter The Numbers: ");
                    int data1=sc.nextInt();
                    int data2=sc.nextInt();
                    System.out.println("\nAncestor: "+LCA(data1,data2));
                    break;
                case 10:
                    LOT();
                    break;
                case 11:
                    LOTZigZag();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}