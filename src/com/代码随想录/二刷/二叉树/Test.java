package com.代码随想录.二刷.二叉树;


import java.util.*;

public class Test {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                //一直向左
                stack.push(cur.left);
                cur = cur.left;
            } else {
                //吐出来上一个元素，保存，指向右节点
                TreeNode node = stack.pop();
                res.add(node.val);
                cur = node.right;
            }
        }
        return res;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return dfsisSameTree(p, q);
    }

    private boolean dfsisSameTree(TreeNode p, TreeNode q) {
        //出口，业务，方向
        if (p == null || q == null) return p == q;
        return p.val == q.val && dfsisSameTree(p.left, q.left) && dfsisSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {

        return isSymmetricdfs(root.left, root.right);
    }

    boolean isSymmetricdfs(TreeNode l, TreeNode r) {
        //出口，业务，方向
        if (l == null || r == null) return l == r;
        return l.val == r.val && isSymmetricdfs(l.left, r.right) && isSymmetricdfs(l.right, r.left);
    }

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        maxDepthdfs(root, 1);
        return maxDepth;
    }

    void maxDepthdfs(TreeNode treeNode, int cur) {
        //出口业务方向
        if (treeNode == null) return;
        maxDepth = Math.max(cur, maxDepth);
        maxDepthdfs(treeNode.left, cur + 1);
        maxDepthdfs(treeNode.right, cur + 1);
    }

    HashMap<Integer, Integer> buildTreeMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            buildTreeMap.put(inorder[i], i);
        }
        return buildTreedfs(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }

    TreeNode buildTreedfs(int inleft, int inright, int posleft, int postright, int[] inorder, int[] postorder) {
        //出口，业务，方向
        if (inleft > inright) return null;
        //root,业务
        Integer idx = buildTreeMap.get(postorder[postright]);
        TreeNode node = new TreeNode(inorder[idx]);
        //cnt=左子树节点数，左子树的后序遍历序列长度正好等于其节点数 cnt。
        //左子树的所有节点在后序序列中是连续出现的一段。
        int cnt = idx - inleft;
        //方向
        node.left = buildTreedfs(inleft, idx - 1, posleft, posleft + cnt - 1, inorder, postorder);
        node.right = buildTreedfs(idx + 1, inright, posleft + cnt, postright - 1, inorder, postorder);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTdfs(nums, 0, nums.length - 1);
    }

    TreeNode sortedArrayToBSTdfs(int[] nums, int l, int r) {
        //出口，业务，方向
        //叶子节点
        if (l > r) return null;
        //业务
        int mid = (l + r) >> 1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        //方向
        treeNode.left = sortedArrayToBSTdfs(nums, l, mid - 1);
        treeNode.right = sortedArrayToBSTdfs(nums, mid + 1, r);
        return treeNode;
    }

    public boolean isBalanced(TreeNode root) {
        isBalanceddfs(root);
        return flag;
    }

    boolean flag = true;

    int isBalanceddfs(TreeNode treeNode) {
        //出口业务方向
        if (treeNode == null) return 0;
        //业务，方向
        int left = isBalanceddfs(treeNode.left) + 1;
        int right = isBalanceddfs(treeNode.right) + 1;
        if (Math.abs(left - right) > 1) flag = false;
        return Math.max(left, right);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        minDepthdfs(root, 1);
        return min;
    }

    Integer min = Integer.MAX_VALUE;

    //_111二叉树最小深度
    void minDepthdfs(TreeNode treeNode, int cur) {
        //出口业务方向
        if (treeNode == null || cur > min) return;
        //业务
        if (treeNode.left == null && treeNode.right == null)
            //叶子节点记录当前深度
            min = Math.min(cur, min);
        //方向
        minDepthdfs(treeNode.left, cur + 1);
        minDepthdfs(treeNode.right, cur + 1);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        return hasPathSumdfs(root, 0);
    }

    int targetSum;

    boolean hasPathSumdfs(TreeNode root, int sum) {
        //出口业务方向
        if (root == null) return false;//遍历叶子节点还没返回true
        if (root.left == null && root.right == null) {
            //叶子节点
            return (sum + root.val) == this.targetSum;
        }
        //方向
        return hasPathSumdfs(root.right, sum + root.val) || hasPathSumdfs(root.left, sum + root.val);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    int cnt;

    public int countNodes(TreeNode root) {
        countNodesdfs(root);
        return cnt;
    }

    void countNodesdfs(TreeNode root) {
        //出口业务方向
        if (root == null) return;
        if (root != null) cnt++;
        countNodes(root.left);
        countNodes(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        invertTreedfs(root);
        return root;
    }

    void invertTreedfs(TreeNode root) {
        if (root == null) return;
        swap(root);
        invertTreedfs(root.left);
        invertTreedfs(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        this.res = new ArrayList<>();
        binaryTreePathsdfs(root, new StringBuilder());
        return res;
    }

    List<String> res;

    void binaryTreePathsdfs(TreeNode root, StringBuilder path) {
        //出口业务方向
        if (root == null) return;
        if (root.left == null && root.right == null) {
            //叶子节点
            path.append(root.val);
            this.res.add(path.toString());
        }
        //非叶子节点
        path.append(root.val).append("->");
        binaryTreePathsdfs(root.left, new StringBuilder(path));
        binaryTreePathsdfs(root.right, new StringBuilder(path));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesdfs(root);
        return this.sumofleft;
    }

    int sumofleft;

    void sumOfLeftLeavesdfs(TreeNode treeNode) {
        if (treeNode == null) return;
        //出口业务方向
        if (treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) {
            //根节点的左叶子节点
            this.sumofleft += treeNode.left.val;
        }
        sumOfLeftLeavesdfs(treeNode.left);
        sumOfLeftLeavesdfs(treeNode.right);
    }

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValuedfs(root, 1);
        return leftres;
    }

    int maxdp;
    int leftres;

    void findBottomLeftValuedfs(TreeNode root, int dp) {
        //出口业务方向
        if (root == null)
            return;
        if (dp > maxdp) {
            leftres = root.val;
            maxdp = dp;
        }
        findBottomLeftValuedfs(root.left, dp + 1);
        findBottomLeftValuedfs(root.right, dp + 1);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        mergeTreesdfs(root1, root2);
        return root1;
    }

    void mergeTreesdfs(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return;
        //出口业务方向
        if (node1 != null && node2 != null) node1.val += node2.val;
        if (node1.right == null && node2.right != null) {
            node1.right = node2.right;
            node2.right = null;
        }
        if (node1.left == null && node2.left != null) {
            node1.left = node2.left;
            node2.left = null;
        }
        mergeTreesdfs(node1.left, node2.left);
        mergeTreesdfs(node1.right, node2.right);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return builddfs(nums, 0, nums.length - 1);
    }

    TreeNode builddfs(int[] nums, int l, int r) {
        if (l > r) return null;
        //出口业务方向
        //找到最大值，划分区间，构建左右节点
        int maxidx = getmaxidx(nums, l, r);
        TreeNode node = new TreeNode(nums[maxidx]);
        node.left = builddfs(nums, l, maxidx - 1);
        node.right = builddfs(nums, maxidx + 1, r);
        return node;
    }

    int getmaxidx(int[] nums, int l, int r) {
        int max = -1;
        int idx = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
