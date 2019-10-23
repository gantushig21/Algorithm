import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements MySet<E> {
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    private static int MAXIMUM_CAPACITY = (1 << 30);

    private int capacity;

    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private float loadFactorThreshold;

    private int size = 0;

    private LinkedList<E>[] table;

    public MyHashSet() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY)
            capacity = MAXIMUM_CAPACITY;
        else
            capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    public int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;

        while (capacity < initialCapacity)
            capacity = capacity << 1;

        return capacity;
    }

    @Override
    public boolean add(E e) {
        if (contains(e))
            return false;

        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");
            rehash();
        }

        int bucketIndex = hash(e.hashCode());

        if (table[bucketIndex] == null)
            table[bucketIndex] = new LinkedList<>();

        size++;
        table[bucketIndex].add(e);

        return true;
    }

    public void rehash() {
        ArrayList<E> list = setToList();

        capacity = capacity << 1;
        table = new LinkedList[capacity];
        size = 0;

        for (E e : list)
            add(e);
    }

    public ArrayList<E> setToList() {
        ArrayList<E> list = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                for (E e : table[i])
                    list.add(e);
            }
        }

        return list;
    }

    public int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    public static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);

        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    public void clear() {
        size = 0;
        removeElements();
    }

    public void removeElements() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                table[i].clear();
        }
    }

    @Override
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());

        if (table[bucketIndex] == null)
            return false;

        for (E element : table[bucketIndex]) {
            if (element.equals(e))
                return true;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E e) {
        if (!contains(e))
            return false;

        int bucketIndex = hash(e.hashCode());

        table[bucketIndex].remove(e);

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyHashSetIterator(this);
    }

    private class MyHashSetIterator implements Iterator<E> {
        private ArrayList<E> list;
        private int current = 0;
        private MyHashSet<E> set;

        public MyHashSetIterator(MyHashSet<E> set) {
            this.set = set;
            list = setToList();
        }

        @Override
        public boolean hasNext() {
            if (current < list.size())
                return true;

            return false;
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        public void remove() {
            set.remove(list.get(current));
            list.remove(current);
        }
    }

    @Override
    public String toString() {
        ArrayList<E> list = setToList();
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < size - 1; i++)
            builder.append(list.get(i) + ", ");

        if (size == 0)
            builder.append("]");
        else
            builder.append(list.get(size - 1) + "]");

        return builder.toString();

    }
}