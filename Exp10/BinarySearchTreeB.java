package Exp10;
import java.util.*;

class TreeNode{
    int data;
    TreeNode left,right;
    public TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinarySearchTreeB {
    TreeNode root;
    public BinarySearchTreeB(){
        root = null;
    }

    public void insert(int data){
        root = insertRec(root,data);
    }
    private TreeNode insertRec(TreeNode root,int data){
        if(root==null){
            TreeNode newNode = new TreeNode(data);
            root = newNode;
            return root;
        }
        if(root.data<data) root.right = insertRec(root.right,data);
        else root.left = insertRec(root.left,data);
        return root;
    }

    public void inorder(){
        System.out.print("Inorder Traversal: ");
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(TreeNode root){
        inorderRec(root.left);
        System.out.print(root.data+" ");
        inorderRec(root.right);
    }

    public void levelorder(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if(tempNode.left!=null) queue.add(tempNode.left);
            if(tempNode.right!=null) queue.add(tempNode.right);
        }
        System.out.println();
    }
}
