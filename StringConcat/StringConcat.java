public class StringConcat {
    public static String concat(String s1, String s2) {
        return (s1 == null ? "" : s1) + (s2 == null ? "": s2);
    }
}