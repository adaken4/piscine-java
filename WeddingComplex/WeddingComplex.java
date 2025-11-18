// Instructions

// Create a file WeddingComplex.java.

// Write a function createBestCouple that returns a map of name from the first map associated with a name from the second list.
// Each map argument will be composed as follows :

// Key: The name of the member to marry

// Value: The ordered list of preference containing members (keys) from the other map.

// To objective of this function is to determine the best couple possible.
// The optimal solution occurs when, considering a particular member named Alice, if there exists a preferred partner Bob over the selected partner Charly, then Bob is happier with his chosen partner Daphnee compared to being with Alice.

// With an example :

// First map :

// Naruto orders his preferences : Sakura > Hinata

// Sasuke orders his preferences : Sakura > Hinata

// Second map :

// Sakura orders her preferences : Sasuke > Naruto

// Hinata orders her preferences : Naruto > Sasuke

// A correct solution for this example is :

// Sasuke <-> Sakura (they are both with their first preference)

// Naruto <-> Hinata (Naruto would prefere Sakura, but Sakura is happier with Sasuke, Hinata has her first choice)

// All the test will be chosen to guarantee such a solution exists. More than one solution could exist.

// In order to simplify, the list will always have the same size.

// Expected Functions
// import java.util.List;
// import java.util.Map;

// public class WeddingComplex {
//     public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.util.List;
// import java.util.Map;

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         System.out.println(WeddingComplex.createBestCouple(
//                 Map.of("Naruto", List.of("Sakura", "Hinata"), "Sasuke", List.of("Sakura", "Hinata")),
//                 Map.of("Sakura", List.of("Sasuke", "Naruto"), "Hinata", List.of("Naruto", "Sasuke"))));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// {Sasuke=Sakura, Naruto=Hinata}
// $ 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> engaged = new HashMap<>(); // second -> first (who second is engaged to)
        Map<String, Integer> nextProposal = new HashMap<>(); // tracks next person to propose to
        
        // Initialize proposal tracking
        for (String person : first.keySet()) {
            nextProposal.put(person, 0);
        }
        
        // Keep track of free people from first group
        java.util.Queue<String> freePeople = new java.util.LinkedList<>(first.keySet());
        
        while (!freePeople.isEmpty()) {
            String proposer = freePeople.poll();
            List<String> preferences = first.get(proposer);
            int nextIndex = nextProposal.get(proposer);
            
            // If proposer has exhausted all preferences, skip
            if (nextIndex >= preferences.size()) {
                continue;
            }
            
            String proposed = preferences.get(nextIndex);
            nextProposal.put(proposer, nextIndex + 1);
            
            if (!engaged.containsKey(proposed)) {
                // proposed is free, engage them
                engaged.put(proposed, proposer);
            } else {
                // proposed is already engaged, check if they prefer proposer
                String currentPartner = engaged.get(proposed);
                List<String> proposedPreferences = second.get(proposed);
                
                int proposerRank = proposedPreferences.indexOf(proposer);
                int currentRank = proposedPreferences.indexOf(currentPartner);
                
                if (proposerRank < currentRank) {
                    // proposed prefers proposer, break current engagement
                    engaged.put(proposed, proposer);
                    freePeople.add(currentPartner); // current partner becomes free
                } else {
                    // proposed prefers current partner, proposer stays free
                    freePeople.add(proposer);
                }
            }
        }
        
        // Convert to first -> second mapping
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : engaged.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        
        return result;
    }
}