import java.util.*;
import java.io.*;

public class Question8 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test.dat"));
        LinkedHashSet<String> set1 = new LinkedHashSet<>();

        set1.add("New York");
        LinkedHashSet<String> set2 =
            (LinkedHashSet<String>) set1.clone();

        set1.add("Atlanta");
        output.writeObject(set1);
        output.writeObject(set2);
        output.close();

        ObjectInputStream input = new ObjectInputStream(
            new FileInputStream("test.dat"));

        set1 = (LinkedHashSet<String>) input.readObject();
        set2 = (LinkedHashSet<String>) input.readObject();

        System.out.println(set1);
        System.out.println(set2);
        input.close();
    }
}