package practice.exceptions;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class TestException {
    public static void main(String[] args) {
        Collection[] obj = new Collection[4];
        obj[0] = new HashSet<Long>();
        obj[1] = Arrays.asList(1, 2, 3, 4);
        obj[2] = null;
        obj[3] = new DelayQueue<>();
        TestException test = new TestException();
        for (int i = 0; i < obj.length; i++) {
            try {
                System.out.println(test.m1(obj[i]));
            } catch (MyCheckedException ce) {
                System.err.println("oh sorry, I will proceed with other items");
            }
        }
    }

    private String m1(Collection<?> obj) throws MyCheckedException {
        if (obj == null) {
            throw new MyCheckedException("object can't be null");
        }
        if (obj instanceof Set || obj instanceof List) {
            return "valid";
        } else {
            throw new MyUncheckedException("Invalid Obj passed", obj);
        }

    }

//    private void m1(Map<String, Integer> map) {
//
//    }
//
//    private void m1(Set<Long> set) {
//
//    }
//
//    private void m1(Integer[] intArray) {
//
//    }
}
