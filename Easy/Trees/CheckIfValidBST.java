boolean checkBST(Node root, int minValue, int maxValue) {
    if (root == null) {
        return true;
    }
    
    if (root.data < minValue || root.data > maxValue) {
        return false;
    }
    
    return (    checkBST(root.left, minValue, root.data - 1) 
            &&  checkBST(root.right, root.data + 1, maxValue)
            );
}
    
boolean checkBST(Node root) {
    return checkBST(root, 0, 10000);
}

// lhs <= node
// rhs >= node

// overall, lhs <= rhs