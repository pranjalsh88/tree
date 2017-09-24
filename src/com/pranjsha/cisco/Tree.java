package com.pranjsha.cisco;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree{

    TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public boolean addNode(TreeNode cur, int val, String child) {
        try {
            if(cur == null)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("current is null. Cannot add to the left or right");
            return false;
        }
        TreeNode temp = cur;
        TreeNode node = new TreeNode(val);
        if(child.equals("left")){

            temp.setLeft(node);
        }

        else if(child.equals("right")) {

            temp.setRight(node);
        }

        return true;
    }

    public void printTree(TreeNode root, String order) {
        if(root != this.root) {
            System.out.println("This is not the root");
            return;
        }
        if(root == null)
            return;
        if(order.startsWith("pre"))
            printTreePreorder(root);
        if(order.startsWith("in"))
            printTreeInorder(root);
        if(order.startsWith("post"))
            printTreePostorder(root);

    }
    public void printTreePreorder(TreeNode root) {

        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(cur);
        while(!s.isEmpty()) {
            TreeNode temp = s.pop();
            if(temp.getRight() != null)
                s.push(temp.getRight());
            if(temp.getLeft() != null)
                s.push(temp.getLeft());
            list.add(temp.getVal());
        }
        System.out.println(list);
    }
    public void printTreeInorder(TreeNode root) {
        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.getLeft();
            }
            TreeNode temp = s.pop();
            list.add(temp.getVal());

            cur = temp.getRight();
        }
        System.out.println(list);
    }
    public void printTreePostorder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode cur = root;
        s1.push(cur);
        while(!s1.isEmpty()) {
            TreeNode temp = s1.peek();
            s2.push(s1.pop());
            if(temp.getLeft() != null)
                s1.push(temp.getLeft());
            if(temp.getRight() != null)
                s1.push(temp.getRight());
        }
        List<Integer> list = new ArrayList<>();
        while(!s2.isEmpty())
            list.add(s2.pop().getVal());
        System.out.println(list);

    }

}
