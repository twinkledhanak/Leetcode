class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        // 1. create a hashmap
        Map<String,Integer> map = new HashMap<>();
        for(String w: words){
            if(!map.containskey(w))
                map.put(w,1);
            else
                map.put(w,map.get(w)+1);    
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverse()); // 
        for(Map.Entry<String,Integer> record: map.entrySet() ){
            pq.push(new Pair(record.getKey(), record.getValue()));
        }
        
        while(k!=0){
            String res = pq.peek();
            result.add(res);
            pq.pop();
            k--;
        }

        return result;

    }
}

class Solution {
    class Word implements Comparable<Word> {
        private String word;
        private int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(Word other) {
            if (this.count == other.count) {
                return this.word.compareTo(other.word);
            }
            return other.count - this.count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {


        // for(String w: words){
        //     if(!map.containsKey(w))
        //         map.put(w,1);
        //     else
        //         map.put(w,map.get(w)+1);    
        // }

//// REDUCED TOOOO ///////

        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<Word> candidates = new ArrayList<>();
        for (var entry : cnt.entrySet()) {
            candidates.add(new Word(entry.getKey(), entry.getValue()));
        }

        Queue<Word> h = new PriorityQueue<>(candidates);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(h.poll().word);
        }
        return res;

    }
}