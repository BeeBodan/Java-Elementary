package com.bogdan;

public class Main {

    public static void main(String[] args) {
        //Lesson Eighth

        /*
        * 1. Написать метод который возвращает N-ное число фибоначи, по правилу:
        *
        * F(0) = 0, F(1) = 1
        * F(N) = F(N - 1) + F(N - 2)
        */

        System.out.println(fibonacci(9));
        System.out.println(fibonacci(13));
        System.out.println(fibonacci(30));
        System.out.println();

        /*
        * 2. Объединить 2 бинарных дерева
        */

        System.out.println("First tree: ");
        TreeNode rootOne = new TreeNode(1);
        rootOne.left = new TreeNode(3);
        rootOne.right = new TreeNode(2);
        rootOne.left.left = new TreeNode(5);
        output(rootOne);
        System.out.println();

        System.out.println("Second tree: ");
        TreeNode rootTwo = new TreeNode(2);
        rootTwo.left = new TreeNode(1);
        rootTwo.right = new TreeNode(3);
        rootTwo.left.right = new TreeNode(4);
        rootTwo.right.right = new TreeNode(7);
        output(rootTwo);
        System.out.println();

        TreeNode rootThree = mergeTrees(rootOne, rootTwo);
        System.out.println("Merged trees: ");
        output(rootThree);
    }

    //Method for task #1
    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    //Method and classes for task #2
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    private static void output(TreeNode node)
    {
        if (node == null) {
            return;
        }
        output(node.left);
        System.out.print(node.val + " ");
        output(node.right);
    }
}