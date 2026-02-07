package collection;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
//        for(int i=0;i<30;i++){
//            list.add(i+"",i);
//        }
        list.add("AAA",0);
        list.add("BBB",1);
        list.add("CCC",2);
        list.remove(1);
        System.out.println(list);
    }
}
