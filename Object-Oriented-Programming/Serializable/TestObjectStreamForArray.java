import java.io.*;

public class TestObjectStreamForArray {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        String[] strings = { "John", "Susan", "Kim" };
        Pair[] pairs = { new Pair(1, 2), new Pair(2, 3) };

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat", true));

            output.writeObject(numbers);
            output.writeObject(strings);
            output.writeObject(pairs);
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));
            int[] newNumbers = (int[]) (input.readObject());
            String[] newStrings = (String[]) (input.readObject());
            Pair[] newPairs = (Pair[]) (input.readObject());

            for (int i = 0; i < newNumbers.length; i++)
                System.out.print(newNumbers[i] + " ");
            System.out.println();

            for (int i = 0; i < newStrings.length; i++)
                System.out.print(newStrings[i] + " ");
            System.out.println();

            // for (int i = 0; i < newPairs.length; i++)
            // System.out.print(newPairs[i] + " ");
            // System.out.println();
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
