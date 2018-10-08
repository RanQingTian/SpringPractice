package test;

import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Alice alice = new Alice();
        Alice.Inner a = new Alice.Inner();
        alice.show();
        Set<Integer> hello = new HashSet<>();
        hello.add(1);
        hello.add(2);
        Set<Integer> hello3 = new HashSet<>();
        hello3.add(1);
        hello3.add(2);
        test(hello);
        test(hello3);
    }

    private static void test(Object v) {
        Set vSet;
        if (v instanceof List || v instanceof Set) {
            if(v instanceof List) {
                vSet = new TreeSet((List) v);
            } else {
                vSet = new TreeSet((Set) v);
            }
            System.out.println(vSet);
        }
    }
}
