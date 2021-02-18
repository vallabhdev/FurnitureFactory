//package practice;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Minimize {
//    public static String minimize(String command, String failingInputFilename)
//            throws FileNotFoundException, IOException {
//        //command = java CaesarCipher failingInputFilename
//        List<String> lines = Utilities.readFile(failingInputFilename);
//
//        if (lines.size() == 1) {
//            lines = splitUpSingleLine(lines.get(0));
//        }
//
//        int splitSize = 2;
//        while (lines.size() >= 2) {
//            List<List<String>> subsets = split(lines, splitSize);
//            boolean complementFailing = false;
//
//            for (List<String> subset : subsets) {
//                List<String> reduced = difference(lines, subset);
//                Utilities.writeToFile("reducedFile", reduced);
//                String result = Utilities.runCommand(command + "reducedFile");
//                if (result.contains("stderr")) {
//                    lines = reduced;
//                    splitSize = Math.max(splitSize - 1, 2);
//                    complementFailing = true;
//                    break;
//                }
//            }
//
//            if (!complementFailing) {
//                if (splitSize == lines.size()) {
//                    break;
//                }
//                splitSize = Math.min(splitSize * 2, lines.size());
//            }
//        }
//        return lines.get(0);
//    }
//
//    private static <String> List<List<String>> split(List<String> s, int n) {
//        List<List<String>> subsets = new LinkedList<>();
//        int position = 0;
//        for (int i = 0; i < n; i++) {
//            List<String> subset = s.subList(position, position + (s.size() - position) / (n - i));
//            subsets.add(subset);
//            position += subset.size();
//        }
//        return subsets;
//    }
//
//    private static <String> List<String> difference(List<String> a, List<String> b) {
//        List<String> result = new LinkedList<>(a);
//        result.removeAll(b);
//        return result;
//    }
//
//    private static List<String> splitUpSingleLine(String line) {
//        return new ArrayList<>(Arrays.asList(line.split(" ")));
//    }
//
//    public static void main(String[] args) {
//        List<List<String>> split = split(Arrays.asList("1", "2", "3", "4", "5", "6"), 3);
//        System.out.println(split);
//    }
//}
