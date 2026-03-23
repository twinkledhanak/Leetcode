class Solution {
    public int[] powerGridDistance(int n, int[][] edges, int[] solarPanels) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int[] distance = new int[n];

        // 1. Build the graph
        for (int[] edge : edges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // 2. Seed solar panel houses — mark visited HERE
        for (int house : solarPanels) {
            queue.offer(house);
            visited.add(house);   // ← Bug 1 fix
        }

        // 3. Multi-source BFS
        while (!queue.isEmpty()) {
            int house = queue.poll();
            for (int neighbour : adjMap.getOrDefault(house, new ArrayList<>())) {
                if (!visited.contains(neighbour)) {
                    distance[neighbour] = distance[house] + 1;  // ← Bug 2 fix
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        return distance;
    }
}