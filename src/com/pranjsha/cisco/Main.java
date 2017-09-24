package com.pranjsha.cisco;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode treeNode = new TreeNode(5);
        Tree tree = new Tree(treeNode);
        tree.addNode(treeNode, 10, "left");
        tree.addNode(treeNode, 20, "right");

        TreeNode node = treeNode.getLeft();
        tree.addNode(node, 30, "left");
        tree.addNode(node, 40, "right");
        TreeNode rootleft = node.getRight();
        tree.addNode(rootleft, 80, "left");

        TreeNode node1 = treeNode.getRight();
        tree.addNode(node1, 50, "left");
        tree.addNode(node1, 60, "right");
        tree.printTree(treeNode, "preorder");
        tree.printTree(treeNode, "into");
        tree.printTree(treeNode, "postman");
        System.out.println(tree.maxDepth(treeNode));
        System.out.println(tree.maxPathSum(treeNode));
        System.out.println(tree.pathSum(treeNode, 135));

    }
}
