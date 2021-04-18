package practice.general;

public class CLOC {

    static boolean flag = false;

    public static void main(String[] args) {
        String text = "public class Example1 {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello world\");\n" +
                "    }\n" +
                "}";
        String text2 = "public class Example2 {\n" +
                "    public static void main(String[] args) {\n" +
                "        \n" +
                "        // say hello\n" +
                "        System.out.println(\"Hello world\");\n" +
                "    }\n" +
                "}";
        String text3 = "public class Example3 {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello world\"); // say hello\n" +
                "    }\n" +
                "}";
        String text4 = "/**\n" +
                " * A hello world program\n" +
                "*/\n" +
                "\n" +
                "public class Example4 {\n" +
                "    public static void main(String[] args /* grab args */) {\n" +
                "        System.out.println(\"/*Hello world\"); // say hello\n" +
                "    }\n" +
                "}";
        String text5 = "/*\n" +
                " /****//*\n" +
                " A hello world program\n" +
                " *\\/\n" +
                "*/// -----------------\n" +
                "class Example5 {\n" +
                "    public static void main(String[] args) { \n" +
                "        System.out./*  */println(\"/*\\\"Hello world\")\n" +
                "            ;\n" +
                "///*\n" +
                "    }\n" +
                "/* // */ }";
        System.out.println("first must be 5 : " + count(text));
        System.out.println("text2 must be 5 : " + count(text2));
        System.out.println("text3 must be 5 : " + count(text3));
        System.out.println("text4 must be 5 : " + count(text4));
        System.out.println("text5 must be 6 : " + count(text5));
    }

    public static int count(String text) {
        int lineCounter = 0;
        String[] lines = text.split("\n");
        for (String eachLine : lines) {
            if (isBlankOrHasComments(eachLine.trim())) {
                continue;
            }
            lineCounter++;
        }
        return lineCounter;
    }

    private static boolean isBlankOrHasComments(String trimmedLine) {
        return trimmedLine.isBlank() ||
                isOneLinerComment(trimmedLine) ||
                isBlockComment(trimmedLine);
    }

    private static boolean isOneLinerComment(String trimmedLine) {
        return trimmedLine.startsWith("//") || isASingleLineBlockComment(trimmedLine);
    }

    private static boolean isASingleLineBlockComment(String trimmedLine) {
        return trimmedLine.startsWith("/*") && trimmedLine.endsWith("*/");
    }

    private static boolean isBlockComment(String trimmedLine) {
        if (flag) {
            return ifBlockCommentIsClosedWithoutAnythingLeft(trimmedLine)
                    || isRemainingLineHasComments(trimmedLine);
        } else if (!flag && trimmedLine.startsWith("/*") && !trimmedLine.endsWith("*/")) {
            flag = true;
            return true;
        } else return flag;
    }

    private static boolean ifBlockCommentIsClosedWithoutAnythingLeft(String trimmedLine) {
        if (trimmedLine.contains("*/")) {
            flag = false;
            return trimmedLine.endsWith("*/");
        } else return flag;
    }

    private static boolean isRemainingLineHasComments(String trimmedLine) {
        String[] afterBlockString = trimmedLine.split("[*][/]");
        if (afterBlockString.length > 1) {
            if (afterBlockString[1].isBlank() || isOneLinerComment(afterBlockString[1])) {
                return true;
            }
            return isBlockComment(afterBlockString[1]);
        } else {
            return false;
        }
    }

//    private static boolean isBlockComment(String trimmedLine) {
//        if (trimmedLine.startsWith("/*") && !trimmedLine.endsWith("*/")) {
//            flag = true;
//            return true;
//        } else if (flag && trimmedLine.contains("*/")) {
//            if (trimmedLine.endsWith("*/")) {
//                flag = false;
//                return true;
//            } else {
//                return isBlankOrHasComments(trimmedLine.split("[*/]")[1]);
//            }
//        } else return true;
//    }
}
