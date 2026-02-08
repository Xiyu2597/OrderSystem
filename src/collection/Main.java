package collection;
import collection.LinkedList;
public class Main {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
//        for(int i=0;i<30;i++){
//           list.add(i+"",i);
//       }
        list.add("AAA",0);
        list.add("BBB",1);
        list.add("CCC",2);
//        System.out.println(list.get(1));
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
        System.out.println(list);
//        System.out.println(list.isEmpty());
    }
}
