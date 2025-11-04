public class CleanExtract {
    public static String extract(String s) {
        if (s == null) return null;

        s = s.trim();
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String rawPart: parts) {
            String part = rawPart.trim();
            if (part.isEmpty()) continue;

            int first = part.indexOf('.');
            int last = part.lastIndexOf('.');

            if (first + 1 == last) {
                continue;
            }

            String extracted;
            if (first == -1) {
                extracted = part.trim();
            } else if (first == last) {
                extracted = part.substring(first + 1).trim();
            } else {
                extracted = part.substring(first + 1, last).trim();
            }
            if (!extracted.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(extracted);
            }
        }
        return result.toString();
    }
}