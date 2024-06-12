class Solution {
    int[][] adjMatrix;
    Map<String,Integer> indexMap;

    public boolean isValid(String s1, String s2){
        String[] dict = {s1,s2};
        // Create a HashSet to store unique patterns of the words
        Set<String> patterns = new HashSet<>();
      
        // Iterate over each word in the dictionary
        for (String word : dict) {
            // Replace each character one by one with '*' to create patterns
            for (int i = 0; i < word.length(); ++i) {
                // Generate a new pattern by replacing the character at index 'i' with '*'
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
              
                // If the pattern already exists in the set, return true
                if (patterns.contains(pattern)) {
                    return true;
                }
              
                // Add the new pattern to the set
                patterns.add(pattern);
            }
        }
      
        // If no pattern has two matching strings, return false
        return false;
    }


    public void createMatrix(List<String> wordList){
        int l = wordList.size();
        adjMatrix = new int[l][l];
        for(int i = 0; i<l; i++){
            for(int j=0; j<l; j++){
                if(isValid(wordList.get(i),wordList.get(j))){
                    adjMatrix[i][j] = 1;
                }
                
            }
        }

        
    }



    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        int ctr = 0;
        String startWord = "";
        Map<Integer,Boolean> visited = new HashMap();
        indexMap = new HashMap();

        for(String s: wordList){
            indexMap.put(s,ctr);
            ctr++;
        }

        // 1. Create a matrix where only valid combinations can be picked
        createMatrix(wordList);

        // 2. Iterate through valid combinations in BFS manner until end node is reached
        // FInding the first common vertex 
        for(int i=0; i<wordList.size(); i++){
            visited.put(indexMap.get(wordList.get(i)), false);
            if(isValid(beginWord,wordList.get(i))){
                // found our dict's startnode
                startWord = wordList.get(i);
                result += 1;
                break;
            }
        }

        Queue<Integer> queue = new ArrayDeque();
        queue.offer(indexMap.get(startWord));
        visited.put(indexMap.get(startWord),true);

        for (String key : indexMap.keySet()) {
        System.out.println("Key: " + key + ", Value: " + indexMap.get(key));
}
        String currIDX = "";
        while(!queue.isEmpty()){
            for (Map.Entry<String, Integer> entry : indexMap.entrySet()) {
            if (entry.getValue() == queue.peek()) {
                currIDX = entry.getKey();
            }
        }
            int currentWord = indexMap.get(currIDX);
            queue.poll();
            System.out.println("Current word: "+currentWord);
            visited.put(currentWord,true);
            
            for(int neighbours: adjMatrix[currentWord]){
                System.out.println(visited.get(neighbours));
                if(adjMatrix[currentWord][neighbours] == 1){
                    visited.put(neighbours,true);
                    queue.offer(neighbours);
                    result += 1;
                }
            }


        }


        return result;

    }
}