package practice.general;

public enum Langs {
    Python(10), JAVA(9), Angular(12);

    private int codes;

    Langs(int p) {
        codes = p;
    }

    int getCodes() {
        return codes;
    }
}
