/**
Thought process:
index 0: name, email1, email2, ....
index 1: name, email0, email3, ....

same person account: at least one common email
condition: on name and then email (same name but not same email X)

O/P: name, sorted email addresses
index i: name, email0, email1, email2, email3, ....

Tricky: For same set of names, how to efficiently compare two lists of strings
to find something common in them?

Could it be that -
I represent a given node of a tree as account name
If this given name has set of 3 strings => it means my nodes
has three outgoing edges => each of them corresponding to three emails

ONE PROBLEM: NODES HAVE TO BE UNIQUE IN A GRAPH. So I cannot have my nodes as account names.
What if we represent email as nodes?

This gives me vibes for: 
1. cycle detection in graph (where we keep reaching the same person even on tracing different emails) 
OR 2. Finding connected components of graph 
OR 3. Something on the lines of union find.

This is still giving me vibes of network concepts I had studied in data mining.
Like a social network graph. I'm still not able to pinpoint exact detaisl.

Turns out this problem IS a social network.

is it like we first construct a connected component out of given graph and then merge two
intersecting components into one and declare one of them as parent? 
Like the parent of the merged account?

Draw the problem:
Account 1: [email1, email2]
Account 2: [email2, email3]
Account 3: [email4, email5]

 {E1     [E2}      E3]
            {E4 E5}

Note the merging of two components into one
The DATA Structure is Union Find. The Data Mining concept is from: 

Connected components in social graphs
Community detection
Transitive closure of relationships

1. LC 547  - Number of Provinces    (medium) → classic Union Find intro
2. LC 684  - Redundant Connection   (medium) → Union Find + cycle detection



### The three steps map exactly to what you reasoned earlier
```
Step 1 → "iterate accounts, union emails together"       (you said this)
Step 2 → "group by root = find connected components"     (you said this)
Step 3 → "sort + prepend name"                           (problem requirement)

name  = "John"
first = "email1"   // account.get(1) — always the anchor
```
```
i=1: email = "email1"
     parent    → {email1: email1}      // add node, points to itself
     emailToName → {email1: John}
     union(email1, email1)             // union with itself, no-op

i=2: email = "email2"
     parent    → {email1: email1, email2: email1}  // email2 points to email1
     emailToName → {email1: John, email2: John}
     union(email1, email2)             // email2 connected to email1

Magic of Union Find:
String first = account.get(1); // anchor email
...
union(first, email); // connect everything to anchor
```

By always unioning to `first`, you're creating a **star topology** per account:
```
Account 1:          Account 2:
email1              email2
  ├── email2          └── email3
  └── email3 (via find, email2's root is email1)

Result:
email1
  ├── email2
  └── email3    ← all three in one component    

### How to identify if a problem needs explicit self-initialization

Ask yourself:
```
Are there nodes that might never appear in any union() call?
        │
        ├── Yes → explicitly initialize them
        │         (isolated nodes, zero-degree vertices)
        │
        └── No  → lazy initialization inside union() is fine  
*/

class Solution {
    // Union Find template — strings instead of ints. Since the node represents emails which is string
    Map<String, String> parent = new HashMap<>();

    String find(String x) {
        if (!parent.get(x).equals(x))
            parent.put(x, find(parent.get(x))); // path compression
        return parent.get(x);
    }

    // X is present. Connect Y to X. 
    void union(String x, String y) {
        String px = find(x), py = find(y);
        if (!px.equals(py)) 
            parent.put(px, py);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: build union find
        for (List<String> account : accounts) {
            String name  = account.get(0);
            String first = account.get(1);

            // Why to start from index:1? index:0 is name, index:1,2,3... is all emails (nodes in DSU)
            // But, starting from index:1 also means like self joining parent to itself
            // It is redundant but can keep it
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);   // parent: {email1: email1}  
                emailToName.put(email, name);        // emailToName → {email1: John}
                union(first, email);                 // union(email1, email1); union(email1, email3)
            }
        }

        // Step 2: group emails by root
        // Output:
        // groups → {email1: [email1, email2, email3],
        //          email4: [email4]}
        Map<String, List<String>> groups = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 3: build result
        /**
        INPUTS from previous step:
        groups:
        email1 → [email1, email2, email3]
        email4 → [email4]

        emailToName:
        email1 → John
        email2 → John
        email3 → John
        email4 → Mary
        
        OUTPUT:
        result → [[John, email1, email2, email3],
                  [Mary, email4]]

        */
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.add(0, emailToName.get(entry.getKey())); // prepend name
            result.add(emails);
        }

        return result;
    }
}
