public class CleanExtract {
    public static String extract(String s) {
        if (s == null) return null;

        s = s.trim();
        String[] parts = s.split("\\|");

        StringBuilder result = new StringBuilder();

        for (String part: parts) {
            part = part.trim();

            if (part.isEmpty()) continue;

            int first = part.indexOf('.');
            int last = part.lastIndexOf('.');

            if (first + 1 == last) {
                continue;
            }

            if (first == -1) {
                result.append(part.trim()).append(" ");
            } else if (first == last) {
                result.append(part.substring(first + 1).trim()).append(" ");
            } else {
                result.append(part.substring(first + 1, last).trim()).append(" ");
            }
        }
        return result.toString().trim();
    }
}