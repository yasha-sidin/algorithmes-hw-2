public class LinkedList<T extends Comparable<T>> {
    private Node root;
    private int size;

    /**
     *
     *
     *
     * HOMEWORK-----------------------------------------------------------------------------------------
     *
     *
     *
     */
    public void revert() {
        if (root == null || root.next == null) {
            return;
        }
        int n = size / 2;
        for (int i = 0; i < n; i++) {
            this.swap(i, size - 1 - i);
        }
    }

    /**
     *
     *
     *
     * HOMEWORK-----------------------------------------------------------------------------------------
     *
     *
     *
     */

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = new Node(value);
        size++;
    }

    public void addSorted(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        if (root.value.compareTo(value) > 0) {
            Node newNode = new Node(value, root);
            root = newNode;
            size++;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) >= 0) {
                Node newNode = new Node(value, currentNode.next);
                currentNode.next = newNode;
                size++;
                return;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value);
    }

    public boolean remove(T value) {
        if (root == null)
            return false;
        if (root.value.compareTo(value) == 0) {
            root = root.next;
            size--;
            return true;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void removeAt(int index) {
        if (index == 0) {
            root = root.next;
            size--;
            return;
        }
        Node currentNode = this.getNode(index - 1);
        currentNode.next = currentNode.next.next;
        size--;
    }

    public void removeAll(T value) {
        if (root == null)
            return;
        while (root != null && root.value.compareTo(value) == 0) {
            root = root.next;
            size--;
        }
        if (root == null)
            return;
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                size--;
            } else
                currentNode = currentNode.next;
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    public T getValue(int index) {
        return this.getNode(index).value;
    }

    public void setValue(int index, T value) {
        this.remove(getValue(index));
        this.addSorted(value);
    }

    public void swap(int index1, int index2) {
        if (index1 == index2)
            return;
        Node node1 = this.getNode(index1);
        Node node2 = this.getNode(index2);
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public void quickSort() {
        quickSort(0, size - 1);
    }

    private void quickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        T pivot = this.getValue((leftMarker + rightMarker) / 2);
        while (leftMarker <= rightMarker) {
            while (this.getValue(leftMarker).compareTo(pivot) < 0)
                leftMarker++;
            while (this.getValue(rightMarker).compareTo(pivot) > 0)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                swap(leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftMarker < rightBorder)
            quickSort(leftMarker, rightBorder);
        if (leftBorder < rightMarker)
            quickSort(leftBorder, rightMarker);
    }

    public void print() {
        System.out.print("[ ");
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]  size:" + size);
    }

    private class Node {
        T value;
        Node next;

        Node() {
        }

        Node(T value) {
            this.value = value;
        }

        Node(Node next) {
            this.next = next;
        }

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}