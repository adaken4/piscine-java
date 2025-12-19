// Instructions

// Create a file RegexReplace.java.

// Write a function removeUnits that returns the string where the units cm and € are removed if they follow directly a number and followed by a space. Write a function obfuscateEmail that returns a string where parts of email addresses are replaced by '*' if they follow the rules below:

// Hide from the username any character next to -, . or _ if they exist. Otherwise, hide 3 characters from the username if its length > 3

// If the remaining part after @ is in the format @<third level domain>.<second level domain>.<top level domain>, then hide the third and top level domains, otherwise hide the second level domain and the top level domain if it is not included in .com, .org and .net.

// Expected Functions
// public class RegexReplace {
//     public static String removeUnits(String s) {
//         // your code here
//     }
    
//     public static String obfuscateEmail(String s) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your function :

// import java.io.IOException;

// public class ExerciseRunner {
//     public static void main(String[] args) throws IOException {
//         System.out.println(RegexReplace.removeUnits("32cm et 50€"));
//         System.out.println(RegexReplace.removeUnits("32 cm et 50 €"));
//         System.out.println(RegexReplace.removeUnits("32cms et 50€!"));
        
//         System.out.println(RegexReplace.obfuscateEmail("john.doe@example.com"));
//         System.out.println(RegexReplace.obfuscateEmail("jann@example.co.org"));
//         System.out.println(RegexReplace.obfuscateEmail("jackob@example.fr"));
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner 
// 32 et 50
// 32 cm et 50 €
// 32cms et 50€!
// l lapin jou à la bel ball avec d animau rigolo pour gagner l bill bleu
// john.***@*******.com
// jan*@*******.co.***
// jac***@*******.**
// $ 

public class RegexReplace {
    public static String removeUnits(String s) {
        return s.replaceAll("(\\d)(cm|€)(?=\\s|$)", "$1");
    }
    
    public static String obfuscateEmail(String s) {
        if (s == null) return null;
    
        // Split the email into username and domain
        String[] parts = s.split("@", 2);
        if (parts.length != 2) return s;
    
        String username = parts[0];
        String domain = parts[1];
    
        // Obfuscate username
        if (username.matches(".*[-._].*")) {
             // find last occurrence of -, . or _
            int lastDot = username.lastIndexOf('.');
            int lastDash = username.lastIndexOf('-');
            int lastUnd = username.lastIndexOf('_');
        
            int lastSymbol = Math.max(lastDot, Math.max(lastDash, lastUnd));
        
            int charsToMask = username.length() - (lastSymbol + 1);
            if (charsToMask > 0) {
                username = username.substring(0, lastSymbol + 1) + "*".repeat(charsToMask);
            }
        } else {
            if (username.length() > 3) {
                String prefix = username.substring(0,3);
                int remaining = username.length() - 3;
                int statsToAdd = Math.min(3, remaining);
                username = prefix + "*".repeat(statsToAdd);

                if (remaining > statsToAdd) {
                    username = username + username.substring(3 + statsToAdd);
                }
            }
            // If length is 3 or less, do nothing
        }
    
        // Obfuscate domain
        String[] domainParts = domain.split("\\.");
        if (domainParts.length >= 3) {
            // Format: @<third>.<second>.<top>
            domain = "*******." + domainParts[domainParts.length - 2] + ".***";
        } else if (domainParts.length == 2) {
            // Format: @<second>.<top>
            String topLevelDomain = domainParts[1];
            if (topLevelDomain.equals("com") || topLevelDomain.equals("org") || topLevelDomain.equals("net")) {
                domain = "*******." + topLevelDomain;
            } else {
                domain = "*******.**";
            }
        }
        return username + "@" + domain;
    }
}