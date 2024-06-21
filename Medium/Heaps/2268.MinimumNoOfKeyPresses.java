class Solution {
    public int minimumKeypresses(String s) {
        Map<Integer,List<Character>> resultMap = new HashMap<>();
        int ctr=1;
        int presses=0;
        int keyPosition = 1; 

        // 0. Get all distinct characters, so we only process them

        // 1. get a hashmap of frequency of elements we need
        Map<Character,Integer> map = new HashMap<>();
        for(Character ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // create a list of all pairs
        List<MyPair> myList = new ArrayList<>();
        for(Map.Entry<Character,Integer> record: map.entrySet()){
            myList.add(new MyPair(record.getKey(),record.getValue()));
        }


        // 2. Create a max heap with character freq
        PriorityQueue<MyPair> pq = new PriorityQueue<>((a,b) -> b.getSecond() - a.getSecond());
        pq.addAll(myList);
        // instead of offer() one by one, give everything together.
        // Able to reduce runtime by 2 ms, from 21 to 19

        while(!pq.isEmpty()){
            MyPair elem = pq.peek();
            pq.poll();
             presses += elem.getSecond() * ((keyPosition - 1) / 9 + 1);
             keyPosition++;

        }

        return presses;
        
    }


    public class MyPair{
        Character first;
        Integer second;

        public MyPair(Character first, Integer second){
            this.first = first;
            this.second = second;
        }

        public Character getFirst(){
            return this.first;
        }

        public Integer getSecond(){
            return this.second;
        }
    }



}

