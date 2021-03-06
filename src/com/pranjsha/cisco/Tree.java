package com.pranjsha.cisco;

import java.util.*;

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
        if(order.startsWith("level"))
            printLevelOrderTraversal(root);
        if(order.startsWith("zig"))
            printZigZagOrderTraversal(root);

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
    public void printLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        q.offer(cur);
        while(!q.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            int level = q.size();

            for (int i = 1; i <= level; i++) {
                if (q.peek().getLeft() != null)
                    q.offer(q.peek().getLeft());
                if (q.peek().getRight() != null)
                    q.offer(q.peek().getRight());
                sublist.add(q.poll().getVal());
            }
            list.add(sublist);

        }
        System.out.println(list);
    }
    public void printZigZagOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        q.offer(cur);
        while(!q.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            int level = q.size();
            if(level%2 !=0) {
                for (int i = 1; i <= level; i++) {
                    if (q.peek().getLeft() != null)
                        q.offer(q.peek().getLeft());
                    if (q.peek().getRight() != null)
                        q.offer(q.peek().getRight());
                    sublist.add(q.poll().getVal());
                }
                list.add(sublist);
            }
            else {
                for (int i = 1; i <= level; i++) {
                    if (q.peek().getRight() != null)
                        q.offer(q.peek().getRight());
                    if (q.peek().getLeft() != null)
                        q.offer(q.peek().getLeft());
                    sublist.add(q.poll().getVal());
                }
                list.add(sublist);
            }
        }
        System.out.println(list);
    }
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1+ Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
    }
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return maxPathSum(root, 0);

    }
    public int maxPathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return Math.max(maxPathSum(root.getLeft(), sum), maxPathSum(root.getRight(), sum))+root.getVal();
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        pathSum(root, sum, list, new ArrayList<>());
        return list;
    }
    public void pathSum(TreeNode root, int sum, List<List<Integer>> list, List<Integer> path) {
        if(root == null)
            return;
        path.add(root.getVal());
        //System.out.println(path);
        if(root.getLeft() == null && root.getRight() == null) {
            if (sum == root.getVal()) {
                list.add(new ArrayList<>(path));
                //System.out.println(list);
            }
            return;
        }
        if(root.getLeft() != null) {
            pathSum(root.getLeft(), sum - root.getVal(), list, path);
            //path.remove(path.size() - 1);
        }
        if(root.getRight() != null) {
            pathSum(root.getRight(), sum - root.getVal(), list, path);
            //path.remove(path.size() - 1);
        }
    }

}
