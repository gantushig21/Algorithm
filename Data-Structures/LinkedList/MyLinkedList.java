import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] objects) {
        super(objects);
    }

    public E getFirst() {
        if (size == 0)
            return null;

        return head.element;
    }

    public E getLast() {
        if (size == 0)
            return null;

        return tail.element;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e);

        node.next = head;
        head = node;
        size++;

        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e);

        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void add(int index, E e) {
        if (index == 0)
            addFirst(e);
        else if (index >= size)
            addLast(e);
        else {
            Node<E> node = new Node<>(e);
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;

            Node<E> temp = current.next;
            current.next = node;
            node.next = temp;

            size++;
        }
    }

    public E removeFirst() {
        if (size == 0)
            return null;

        Node<E> temp = head;

        head = head.next;
        if (head == null)
            tail = null;
        size--;

        return temp.element;
    }

    public E removeLast() {
        if (size == 0)
            return null;

        Node<E> temp = tail;
        if (size == 1) {
            head = tail = null;
            size = 0;

            return temp.element;
        }

        Node<E> current = head;
        for (int i = 0; i < size - 2; i++)
            current = current.next;

        tail = current;
        tail.next = null;
        size--;

        return temp.element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            return null;

        if (index == 0)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();
        else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++)
                previous = previous.next;

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;

            return current.element;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            } else {
                result.append("]");
            }
        }

        return result.toString();
    }

    public void clear() {
        size = 0;
        head = tail = null;
    }

    public boolean contains(E e) {
        return true;
    }

    public E get(int index) {
        return null;
    }

    public int indexOf(E e) {
        return 0;
    }

    public int lastIndexOf(E e) {
        return 0;
    }

    public E set(int index, E e) {
        return null;
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E e = head.element;
            current = current.next;

            return e;
        }

        public void remove() {

        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}