import java.io.*;

public class TestFileStream {
    public static void main(String[] args) throws IOException {
        try (
            FileOutputStream output = new FileOutputStream("temp.dat");
        ) {
            // for (int i = 1; i <= 10; i++)
            //     output.write(i);
            byte[] b = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            output.write(b, 3, 5);
        }

        try (
            FileInputStream input = new FileInputStream("temp.dat");
        ) {
            int value;
            while ((value = input.read()) != -1)
                System.out.print(value + " ");
        }
    }
}