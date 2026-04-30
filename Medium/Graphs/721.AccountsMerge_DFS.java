class Solution {
    Set<String> visited = new HashSet<>();
    Map<String, List<String>> graph = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Step 1: build adjacency list
        // Skip the name at pos:0, start building nodes and connecting them from emails starting at pos:1
        for (List<String> account : accounts) {
            String first = account.get(1);
            
            // Make connections of all emails to first email at index:1 
            // Repeat this for all lists
            // We are NOT connecting emails from account:0 to account:1,2,3...n
            // We are connecting emails WITHIN an account only
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                graph.computeIfAbsent(first, k -> new ArrayList<>()).add(email);
                graph.computeIfAbsent(email, k -> new ArrayList<>()).add(first);
            }

        }

        // Step 2: DFS to collect components
        List<List<String>> result = new ArrayList<>();
        for (List<String> account : accounts) {
            String name  = account.get(0);
            String first = account.get(1);
            if (!visited.contains(first)) {
                List<String> emails = new ArrayList<>();
                dfs(first, emails);
                Collections.sort(emails);
                emails.add(0, name);
                result.add(emails);
            }
        }
        return result;
    }

    private void dfs(String email, List<String> emails) {
        visited.add(email);
        emails.add(email);
        for (String neighbor : graph.getOrDefault(email, new ArrayList<>())) {
            if (!visited.contains(neighbor))
                dfs(neighbor, emails);
        }
    }
}
```

---

### What changed from editorial
```
computeIfAbsent         → replaced verbose containsKey + put blocks
getOrDefault            → replaced containsKey check in DFS
accountName added once  → instead of passing it around
removed redundant vars  → accountListSize, accountSize never needed
DFS signature cleaner   → just email + collector list