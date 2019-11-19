import java.util.*;
import java.io.*;

public class Pair implements Serializable {
    public int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "[" + a + ", " + b + "]";
    }
}