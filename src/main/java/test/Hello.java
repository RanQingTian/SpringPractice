package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RanQingTian
 * @date 2018/5/7
 */
public class Hello {

    public static void main(String[] args) {
        List<Long> ids = new ArrayList<>();
        List linas = new ArrayList<Lina>();
        ids.add(3L);
        ids.add(1L);
        ids.add(2L);
        StringBuilder str = new StringBuilder();
        str.append(String.format("hello %d, %d", 1L, 2L));
        System.out.println(str.toString());
        System.out.println(ids);
        System.out.println(ids instanceof List);
        System.out.println(linas instanceof List);
    }
}
