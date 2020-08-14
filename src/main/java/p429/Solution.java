package p429;

import common.Node;

import java.util.*;

/**
 * 429. N 叉树的层序遍历
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) level.add(node.val);
                if (node.children != null) queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    private List<List<Integer>> s1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        res.add(Collections.singletonList(root.val));
        List<Node> temp = root.children;

        while (!temp.isEmpty()) {
            List<Integer> items = new ArrayList<>();
            for (Node node : temp) {
                items.add(node.val);
            }
            res.add(items);
            temp = allChildren(temp);
        }
        return res;
    }

    private List<Node> allChildren(List<Node> nodes) {
        List<Node> children = new ArrayList<>();
        if (nodes == null) return children;

        for (Node node : nodes) {
            if (node.children != null && !node.children.isEmpty())
                children.addAll(node.children);
        }
        return children;
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

        List<List<Integer>> res = new Solution().levelOrder(n1);
        System.out.println(res);
    }

}
