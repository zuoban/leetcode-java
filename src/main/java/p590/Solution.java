package p590;

import common.Node;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                stack.addAll(node.children);
            }
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 递归解法
     */
    private List<Integer> s1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node node, List<Integer> list) {
        if (node == null) return;
        if (node.children != null) {
            for (Node child : node.children) helper(child, list);
        }
        list.add(node.val);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.children = Arrays.asList(n2, n3, n4);
        n2.children = Arrays.asList(n5, n6);
        List<Integer> result = new Solution().postorder(n1);
        System.out.println(result);
    }
}
