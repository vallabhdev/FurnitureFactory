package DD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CrashMinimizer {

    /**
     * This function minimizes a crashing test case to
     * a single character that still causes the crash.
     *
     * @param //String command - the command to execute the
     *                 program under test.
     * @param //String failingTestInputFilename - the path
     *                 to the file causing a crash in the
     *                 target program. The contents of
     *                 this file are to be minimized by
     *                 this function.
     * @return String - the final, minimized version of the
     * failing test input file which still
     * causes a crash.
     */
    public static String minimize(
            String command, String failingInputFilename
    ) throws FileNotFoundException, IOException {
        List<String> lines = Utilities.readFile(failingInputFilename);
        lines = splitIntoEachWord(lines);

        int splitSize = 1;
        while (lines.size() >= 1) {
            List<List<String>> subsets = split(lines, splitSize);
            boolean isTestFailing = false;

            for (List<String> subset : subsets) {
                List<String> reduced = removeSubsetFromLine(lines, subset);
                Utilities.writeToFile("output.txt", reduced);
                String result = Utilities.runCommand(command + " output.txt");

                if (result.contains("Exception")) {
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
        List<String> minimized = Utilities.readFile("output.txt");
        return minimized.get(0);
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

    private static List<String> removeSubsetFromLine(List<String> a, List<String> b) {
        List<String> result = new LinkedList<>(a);
        result.removeAll(b);
        return result;
    }

    private static List<String> splitIntoEachWord(List<String> lines) {
        List<String> words = new ArrayList<>();
        lines.forEach(each -> words.addAll(Arrays.asList(each.split(" "))));
        return words;
    }
}