package training.lec7;

// Abstract Data Type (ADT) - List
public class GenericDynamicArrayList<E> {
    E[] elements;
    int size;
    int capacity;

    int[] a = new int[10];

    public GenericDynamicArrayList() {
        this(500);
    }

    public GenericDynamicArrayList(int capacity) {
        elements = (E[]) new Object[capacity];  // new E[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public E get(int index) throws Exception {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            throw new Exception("Out of boundary.");
        }
    }

    public void append(E elem) {
        if (size >= capacity) {
            // capacity = capacity + Constant
            // capacity = capacity * Constant

            capacity *= 2;
            E[] temp = (E[]) new Object[capacity];

            System.arraycopy(elements, 0, temp, 0, size);

            elements = temp;
        }

        elements[size] = elem;
        size++;
    }

    public void add(int index, E elem) {
        if (size >= capacity) {
            // capacity = capacity + Constant
            // capacity = capacity * Constant

            capacity *= 2;
            E[] temp = (E[]) new Object[capacity];

            System.arraycopy(elements, 0, temp, 0, size);

            elements = temp;
        }

        if (index <= size && index >= 0) {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = elem;
            size++;
        }

    }

    public boolean remove(int index) {

        if (index <= size && index >= 0) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size] = null;
            size--;
            // equals to element[size--] = 0
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        GenericFixedArrayList<String> list = new GenericFixedArrayList<String>();
        GenericFixedArrayList<Integer> list2 = new GenericFixedArrayList<Integer>();
    }

}
