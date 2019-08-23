import java.util.Iterator;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<String>();

        list.add("America");
        list.add(0, "Canada");
        list.add("Russia");
        list.add("France");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(iterator.next());

        System.out.println(list);
    }
}