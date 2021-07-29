package training.lec7;

public class FixedIntegerArrayList {
    int[] elements;
    int size;
    int capacity;

    public FixedIntegerArrayList() {
        capacity = 500;
        elements = new int[capacity];
        size = 0;
    }

    public FixedIntegerArrayList(int capacity) {
        elements = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public int size() {
        return size;
    }

    public int get(int index) throws Exception {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            throw new Exception("Out of boundary.");
        }
    }

    public boolean append(int elem) {
        if (size + 1 >= capacity) {
            return false;
        } else {
            elements[size] = elem;
            size++;
            return true;
        }
    }

    public void add(int index, int elem) {
        if (index <= size && index >= 0 && size < capacity) {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i-1];
            }
            elements[index] = elem;
            size++;
        }
    }

    public boolean remove(int index) {

        if (index <= size && index >= 0) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i+1];
            }
            elements[size] = 0;
            size--;
            // equals to element[size--] = 0
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        FixedIntegerArrayList test = new FixedIntegerArrayList();
        System.out.println(test.capacity);
        FixedIntegerArrayList test2 = new FixedIntegerArrayList(10);
        System.out.println(test2.capacity);
    }
}
