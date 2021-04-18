package practice.general;

import java.util.HashMap;
import java.util.Map;

public class MyString {
    private String val;

    public MyString(String val) {
        this.val = val;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        String s1 = new String("Java OOPs!");
        String s2 = new String("Java OOPs");
        map1.put(s1, new Integer(10));
        map1.put(s2, new Integer(20));

        Map<MyString, Integer> map2 = new HashMap<>();
        MyString m1 = new MyString(s1);
        MyString m2 = new MyString(s2);
        map2.put(m1, new Integer(10));
        map2.put(m2, new Integer(20));
        System.out.println(map1.get(s1));
        System.out.println(map2.get(m1));
    }
}
