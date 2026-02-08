package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("AAA","BBB","CCC"));
        List<String> list2 = new LinkedList<>(Arrays.asList("CCC","DDD","EEE"));
        list.sort((String o1,String o2) ->  o2.compareTo(o1));
        list2.replaceAll(str->str+"=");
        System.out.println(list2);

    }
}
