package Exp10;
import java.util.*;

class TreeNode{
    int data;
    TreeNode left ,right;
    public TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinarySearchTree{
    TreeNode root;
    public BinarySearchTree(){
        root = null;
    }
    
    public void insert(int data){
        root = insertRec(root,data);
    }
    private TreeNode insertRec(TreeNode root,int data){
        if(root == null){
            TreeNode newNode = new TreeNode(data);
            root = newNode;
            return root;
        }
        if(root.data < data){
            root.right = insertRec(root.right, data);
        }else{
            root.left = insertRec(root.left,data);
        }
        return root;
    }

    public void inorder(){
        System.out.print("InOrder Traversal: ");
        inorderRec(root);
        System.out.println("");
    }
    private void inorderRec(TreeNode root){
        if(root != null){
            inorderRec(root.left);
            System.out.print(root.data+" ");
            inorderRec(root.right);
        }
    }

    public void preorder(){
        System.out.print("PreOrder Traversal: ");
        preorderRec(root);
        System.out.println("");
    }
    private void preorderRec(TreeNode root){
        if(root != null){
            System.out.print(root.data+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder(){
        System.out.print("PostOrder Traversal: ");
        postorderRec(root);
        System.out.println("");
    }
    private void postorderRec(TreeNode root){
        if(root != null){
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void levelorder(){
        System.out.print("LevelOrder Traversal: ");
        if(root == null){
            return ;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data+ " ");

            if(tempNode.left != null) queue.add(tempNode.left);
            if(tempNode.right != null) queue.add(tempNode.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Inserting nodes into the binary search tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Performing traversals
        bst.inorder();    // Expected: 20 30 40 50 60 70 80
        bst.preorder();   // Expected: 50 30 20 40 70 60 80
        bst.postorder();  // Expected: 20 40 30 60 80 70 50
        bst.levelorder(); // Expected: 50 30 70 20 40 60 80
    }
}
