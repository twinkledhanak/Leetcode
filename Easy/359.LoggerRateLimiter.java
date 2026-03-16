class Logger {

    private HashMap<String, Integer> msgDict;

    /** Initialize your data structure here. */
    public Logger() {
        msgDict = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.msgDict.containsKey(message)) {
            this.msgDict.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        } 
        else 
            return false;
    }
}

/**
I can make it more space efficient by removing expired messages from Map. That would help
with growing map size.
But it will be more costly to search for invalid entries in Map.
Hence we have the queue approach
Deque:
The first value of the queue = oldest message we have (eg. 1)
If the current timestamp we receive is 15 - 
we want to keep queue to record memory of only the 10 seconds we need
1....5 to 15
messages older than 5 are not needed/messages older than 15-10 are not needed
older than current-10 are not needed

*/
// I am using an ArrayDeque here:
class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Logger {

    Deque<Pair<String,Integer>> msgQueue;
    HashSet<String> msgSet;

    public Logger() {
        msgQueue = new ArrayDeque<>();
        msgSet = new HashSet<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        // Remove expired messages
        while (!msgQueue.isEmpty()) {
            Pair<String,Integer> head = msgQueue.peekFirst();

            if (timestamp - head.second >= 10) {
                msgQueue.pollFirst();
                msgSet.remove(head.first);
            } else {
                break;
            }
        }

        // Check if message is still in cooldown
        if (!msgSet.contains(message)) {
            Pair<String,Integer> newEntry = new Pair<>(message, timestamp);

            msgQueue.offerLast(newEntry);
            msgSet.add(message);

            return true;
        }

        return false;
    }
}


// Below uses LL + Generics
class Pair<U, V> {

    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Logger {

    private LinkedList<Pair<String, Integer>> msgQueue;
    private HashSet<String> msgSet;

    /** Initialize your data structure here. */
    public Logger() {
        msgQueue = new LinkedList<Pair<String, Integer>>();
        msgSet = new HashSet<String>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // clean up.
        while (msgQueue.size() > 0) {
            Pair<String, Integer> head = msgQueue.getFirst();
            if (timestamp - head.second >= 10) {
                msgQueue.removeFirst();
                msgSet.remove(head.first);
            } else break;
        }

        if (!msgSet.contains(message)) {
            Pair<String, Integer> newEntry = new Pair<String, Integer>(
                message,
                timestamp
            );
            msgQueue.addLast(newEntry);
            msgSet.add(message);
            return true;
        } else return false;
    }
}