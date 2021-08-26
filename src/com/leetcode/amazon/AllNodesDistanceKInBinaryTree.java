package com.leetcode.amazon;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;

import java.util.*;

// Amazon Top Questions
// tag: BFS
public class AllNodesDistanceKInBinaryTree {

    // Annotate Parent
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == k) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree test = new AllNodesDistanceKInBinaryTree();

        // Example 1
        TreeNode root = new TreeNode(3, new TreeNode(5), new TreeNode(1));
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode target = new TreeNode(5);
        int k = 2;
        List<Integer> result = test.distanceK(root, target, k);
        Utils.printIntergerArray(result);

        // Example 1
        root = new TreeNode(1);
        target = new TreeNode(1);
        k = 3;
        result = test.distanceK(root, target, k);
        Utils.printIntergerArray(result);

    }
}
