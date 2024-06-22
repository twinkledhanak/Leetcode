/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


// LEVEL ORDER TRAVERSAL:
// PRE-ORDER HAS ALL PARENTS IN L->R, 
// EG. 1 (ROOT), 2(LST), 3(RST) , THEN LEVEL ORDER TRAVERSAL IS:
// [[1],[2,3]]

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();


        queue.add(root);
        List<Integer> list1 = new ArrayList<>();
        list1.add(root.val);
        result.add(list1);


        while(!queue.isEmpty()){
            Node curr = queue.pollLast();

            List<Integer> list2 = new ArrayList<>();

            for(Node n: curr.children){
                if(n != null){
                    list2.add(n.val);
                    queue.add(n);
                }
                
            }    

            result.add(list2);


        }

        return result;

    }
}
// What is wrong with above code? It does not print the null values
// Input: [1,null,3,2,4,null,5,6]
// Expected Output: [[1],[3,2,4],[],[],[5,6],[],[]]
// My Output: [[1],[3,2,4],[5,6]] -> node 2 is leaf node, so ideally doesnt have any children
// Leetcode is expecting to put null or [] in their level order traversal

// 
// This code is a modified version of the code posted by
// #zzzliu on the discussion forums.
class Solution {

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
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }
}