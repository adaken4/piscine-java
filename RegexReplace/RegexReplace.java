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
        String[] parts = s.split("@");
        String username = parts[0];
        String domain = parts[1];

        // Obfuscate username
        String obfuscatedUsername;
        if (username.contains("-") || username.contains(".") || username.contains("_")) {
            // Hide characters after -, . or _
            obfuscatedUsername = username.replaceAll("([-._]).*", "$1***");
        } else if (username.length() > 3) {
            // Hide characters from the end
            int charsToHide = Math.min(3, username.length() - 3);
            obfuscatedUsername = username.substring(0, username.length() - charsToHide);
            for (int i = 0; i < charsToHide; i++) {
                obfuscatedUsername += "*";
            }
        } else {
            obfuscatedUsername = username;
        }

        // Obfuscate domain
        String[] domainParts = domain.split("\\.");
        String obfuscatedDomain;
        
        if (domainParts.length == 3) {
            // Format: third.second.top (e.g., example.co.edu)
            // Hide third and top level domains
            obfuscatedDomain = "*******." + domainParts[1] + ".***";
        } else if (domainParts.length == 2) {
            // Format: second.top (e.g., example.com)
            String topLevel = domainParts[1];
            if (topLevel.equals("com") || topLevel.equals("org") || topLevel.equals("net")) {
                // Don't hide .com, .org, .net
                obfuscatedDomain = "*******." + topLevel;
            } else {
                // Hide both second and top level
                obfuscatedDomain = "*******.***";
            }
        } else {
            obfuscatedDomain = domain;
        }

        return obfuscatedUsername + "@" + obfuscatedDomain;
    }
}