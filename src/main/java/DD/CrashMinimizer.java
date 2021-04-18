package DD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CrashMinimizer {
    public static String minimize(String command, String failingInputFilename)
            throws IOException {
        List<String> lines = Utilities.readFile(failingInputFilename);
        return processBasedOnLineSize(command, lines);
    }

    private static String processBasedOnLineSize(String command, List<String> lines) throws IOException {
        int splitSize = 2;
        if (lines.size() == 0) {
            return "";
        }
        lines = lines.size() > 1 ? lines : splitIntoEachWord(lines);

        List<String> returnedLines = getBuggyChar(command, lines, splitSize);
        if (returnedLines.size() == lines.size()) {
            return "";
        } else if (returnedLines.size() == 1) {
            returnedLines = getBuggyChar(command, splitIntoEachWord(returnedLines), splitSize);
            List<String> forEachChar = Arrays.asList(returnedLines.get(0).split(""));
            returnedLines = getBuggyChar(command, forEachChar, splitSize);
        }
        return returnedLines.get(0);
    }

    private static List<String> getBuggyChar(String command, List<String> lines, int splitSize) throws IOException {
        while (lines.size() >= 2) {
            List<List<String>> subsets = split(lines, splitSize);
            boolean isTestFailing = false;

            for (List<String> subset : subsets) {
                List<String> reduced = removeSubsetFromLine(lines, subset);
                Utilities.writeToFile("reduced.txt", new ArrayList<>(reduced));
                String result = Utilities.runCommand(command + " reduced.txt");

                if (result.contains("ArrayIndexOutOfBoundsException")) {
                    lines = reduced;
                    splitSize = Math.max(splitSize - 1, 2);
                    isTestFailing = true;
                    break;
                }
            }

            if (!isTestFailing) {
                if (splitSize == lines.size()) {
                    break;
                }
                splitSize = Math.min(splitSize * 2, lines.size());
            }
        }
        return lines;
    }

    private static List<String> removeSubsetFromLine(List<String> a, List<String> b) {
        List<String> result = new LinkedList<>(a);
        result.removeAll(b);
        return result;
    }

    private static List<List<String>> split(List<String> s, int n) {
        List<List<String>> subsets = new LinkedList<>();
        int position = 0;
        for (int i = 0; i < n; i++) {
            List<String> subset = s.subList(position, position + (s.size() - position) / (n - i));
            subsets.add(subset);
            position += subset.size();
        }
        return subsets;
    }

    private static List<String> splitIntoEachWord(List<String> lines) {
        List<String> words = new ArrayList<>();
        lines.forEach(each -> words.addAll(Arrays.asList(each.split(" "))));
        return words;
    }
}