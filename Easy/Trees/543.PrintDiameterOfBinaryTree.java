private int diameter = 0;
private List<List<Integer>> diameterPaths = new ArrayList<>();

public int diameterOfBinaryTree(TreeNode root) {
    findHeightAndPaths(root, new ArrayList<>());
    printPaths(); // Print the paths
    return diameter;
}

private void printPaths() {
    for (List<Integer> path : diameterPaths) {
        System.out.println(path);
    }
}

private PathResult findHeightAndPaths(TreeNode node, List<Integer> currentPath) {
    if (node == null) {
        return new PathResult(0, new ArrayList<>());
    }

    currentPath.add(node.val);

    PathResult leftResult = findHeightAndPaths(node.left, new ArrayList<>(currentPath));
    PathResult rightResult = findHeightAndPaths(node.right, new ArrayList<>(currentPath));

    int leftHeight = leftResult.height;
    int rightHeight = rightResult.height;

    int currentDiameter = leftHeight + rightHeight;
    if (currentDiameter > diameter) {
        diameter = currentDiameter;
        diameterPaths.clear();
        diameterPaths.addAll(combinePaths(leftResult.paths, rightResult.paths, node.val));
    } else if (currentDiameter == diameter) {
        diameterPaths.addAll(combinePaths(leftResult.paths, rightResult.paths, node.val));
    }

    List<List<Integer>> newPaths = new ArrayList<>();
    for (List<Integer> leftPath : leftResult.paths) {
        List<Integer> newPath = new ArrayList<>();
        newPath.add(node.val);
        newPath.addAll(leftPath);
        newPaths.add(newPath);
    }
    for (List<Integer> rightPath : rightResult.paths) {
        List<Integer> newPath = new ArrayList<>();
        newPath.add(node.val);
        newPath.addAll(rightPath);
        newPaths.add(newPath);
    }
    if (newPaths.isEmpty()) {
        List<Integer> singlePath = new ArrayList<>();
        singlePath.add(node.val);
        newPaths.add(singlePath);
    }

    currentPath.remove(currentPath.size() - 1);
    return new PathResult(1 + Math.max(leftHeight, rightHeight), newPaths);
}

private List<List<Integer>> combinePaths(List<List<Integer>> leftPaths, List<List<Integer>> rightPaths, int rootValue) {
    List<List<Integer>> combinedPaths = new ArrayList<>();

    if (leftPaths.isEmpty() && rightPaths.isEmpty()) {
        List<Integer> singlePath = new ArrayList<>();
        singlePath.add(rootValue);
        combinedPaths.add(singlePath);
    } else if (leftPaths.isEmpty()) {
        for (List<Integer> rightPath : rightPaths) {
            List<Integer> singlePath = new ArrayList<>();
            singlePath.add(rootValue);
            singlePath.addAll(rightPath);
            combinedPaths.add(singlePath);
        }
    } else if (rightPaths.isEmpty()) {
        for (List<Integer> leftPath : leftPaths) {
            List<Integer> singlePath = new ArrayList<>();
            singlePath.add(rootValue);
            singlePath.addAll(leftPath);
            combinedPaths.add(singlePath);
        }
    } else {
        for (List<Integer> leftPath : leftPaths) {
            for (List<Integer> rightPath : rightPaths) {
                List<Integer> combined = new ArrayList<>();
                combined.add(rootValue);
                combined.addAll(leftPath);
                combined.addAll(rightPath);
                combinedPaths.add(combined);
            }
        }
    }

    return combinedPaths;
}

class PathResult {
    int height;
    List<List<Integer>> paths;

    PathResult(int height, List<List<Integer>> paths) {
        this.height = height;
        this.paths = paths;
    }
}