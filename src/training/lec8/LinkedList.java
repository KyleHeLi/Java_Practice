package training.lec8;

public class LinkedList<E> implements List<E> {

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(int index, E elem) {

    }

    @Override
    public boolean add(E elem) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E o) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(E o) {
        return 0;
    }

    @Override
    public int lastIndexOf(E o) {
        return 0;
    }

    @Override
    public boolean contains(E o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private class Node<E> {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
