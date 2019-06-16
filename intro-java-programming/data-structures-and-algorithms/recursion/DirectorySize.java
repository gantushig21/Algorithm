import java.util.*;
import java.io.*;

public class DirectorySize {

    public static long getSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++)
                size += getSize(files[i]);
        } else size += file.length();

        return size;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a directory or a file: ");
        String directory = input.nextLine();
        input.close();

        System.out.println(getSize(new File(directory)) + " bytes");
    }
}