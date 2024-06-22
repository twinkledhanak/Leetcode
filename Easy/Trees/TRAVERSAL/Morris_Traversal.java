class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) { // if left doesnt exists, go to right directly.
                output.add(node.val);
                node = node.right;
            } 
            else {
                TreeNode predecessor = node.left; // Go to left and then go rightmost
                while ((predecessor.right != null) && (predecessor.right != node)){
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) { // if rightmost is null, save & go to left
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else { // rightmost is present, go to right
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }
}