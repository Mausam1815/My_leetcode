class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();
        boolean inBlockComment = false;

        for (String line : source) {
            int i = 0;
            int lineLength = line.length();

            while (i < lineLength) {
                if (!inBlockComment) {
                    if (i + 1 < lineLength && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        // Line comment, ignore the rest of the line
                        break;
                    } else if (i + 1 < lineLength && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        // Start of block comment
                        inBlockComment = true;
                        i++;
                    } else {
                        currentLine.append(line.charAt(i));
                    }
                } else {
                    if (i + 1 < lineLength && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        // End of block comment
                        inBlockComment = false;
                        i++;
                    }
                }
                i++;
            }

            // If we are not in a block comment and the line is not empty, add it to the result
            if (!inBlockComment && currentLine.length() > 0) {
                result.add(currentLine.toString());
                currentLine.setLength(0);
            }
        }

        return result;
    }
}