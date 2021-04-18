package practice.general;

public class Counter {
    static boolean flag = false;

    public static void main(String[] args) {
        int counter = 0;
        String text = "/*\n" +
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
        String text4 = "/**\n" +
                " * A hello world program\n" +
                "*/\n" +
                "\n" +
                "public class Example4 {\n" +
                "    public static void main(String[] args /* grab args */) {\n" +
                "        System.out.println(\"/*Hello world\"); // say hello\n" +
                "    }\n" +
                "}";
        String[] lines = text.split("\n");
        for (String eachLine : lines) {
            String trimmedLine = eachLine.trim();
            if (isBlankOrHasComments(trimmedLine)) {
                System.out.println("ignoring: " + trimmedLine);
                continue;
            }
            System.out.println("counting: " + trimmedLine);
            counter++;
        }
        System.out.println(counter);
    }

    private static boolean isBlankOrHasComments(String trimmedLine) {
        return trimmedLine.isBlank() || isOneLinerComment(trimmedLine) ||
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
//            if(!isRemainingLineHasComments(trimmedLine)){
//                return false;
//            }
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
}
