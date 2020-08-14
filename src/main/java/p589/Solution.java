package p589;

import common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            List<Node> children = node.children;
            if (children != null && !children.isEmpty()) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.add(children.get(i));
                }
            }
        }

        return res;
    }

    /**
     * 递归实现
     */
    private List<Integer> s1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.children == null) return;
        for (Node node : root.children) {
            helper(node, res);
        }
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

        List<Integer> result = new Solution().preorder(n1);
        System.out.println(result);
    }

}
