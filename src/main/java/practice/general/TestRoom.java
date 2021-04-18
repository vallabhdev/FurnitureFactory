package practice.general;

public class TestRoom {
    private int stck[];
    private int pos;

    public TestRoom(int size) {
        stck = new int[size];
        pos = -1;
    }

    public static void main(String[] args) {
        TestRoom obj = new TestRoom(3);
        for (int i = 0; i < 4; i++) obj.ins(i);
        for (int i = 0; i <= 3; i++)
            System.out.println(obj.delt());
        //2 4 6
    }


    public void ins(int item) {
        if (pos == stck.length - 1) {
            System.out.println("over");
        } else {
            stck[++pos] = item;
        }
    }

    public int delt() {
        if (pos < 0) {
            System.out.println("underflow.");
            return 0;
        } else {
            return stck[pos--];
        }
    }
}
