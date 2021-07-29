package training.lec7;

// Abstract Data Type (ADT) - List
public class GenericFixedArrayList<E> {
    E[] elements;
    int size;
    int capacity;

    public GenericFixedArrayList() {
        this(500);
    }

    public GenericFixedArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
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

    public boolean append(E elem) {
        if (size + 1 >= capacity) {
            return false;
        } else {
            elements[size] = elem;
            size++;
            return true;
        }
    }

    public void add(int index, E elem) {
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
            elements[size] = null;
            size--;
            // equals to element[size--] = 0
            return true;
        } else {
            return false;
        }

    }

}
