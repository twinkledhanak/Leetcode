//“Because snap_id is monotonic and append-only, 
// a List<int[]> maintains sorted order naturally and supports binary search 
// with less overhead than TreeMap. HashMap fails because it cannot answer floor-key queries efficiently.”
/**
Important to understand that problem constraints make the variable snap_id always increasing 
So, the list of pairs is always going to be sorted
Option 1: Use a ordered structure: TreeMap, SortedMap, Balanced BST
Option 2: List<int[]> + Binary Search

List<int[]> is like:

Git commit history on a single file
Commits only append
History is sorted
You binary search by commit time

TreeMap is like:

A database index that must stay sorted even with random inserts

You don’t need a DB index for a Git log.
*/

class SnapshotArray {
    int snapId = 0;
    TreeMap<Integer, Integer>[] historyRecords;
    
    public SnapshotArray(int length) {
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<Integer, Integer>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return historyRecords[index].floorEntry(snapId).getValue(); // **floorEntry()
    }
}

/*
Constructor: O(n)
set: O(k log k) - log k for k times 
snap: O(k) - O(1) for k times 
get: O(k log k) - log k for k times 

Total: O(n + k log k)

 Space complexity
	•	n TreeMaps → O(n)
	•	Each set adds an entry → ≤ k entries across all maps → O(k)

Total space: O(n + k)
*/


