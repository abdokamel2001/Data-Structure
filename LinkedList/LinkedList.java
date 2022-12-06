public class LinkedList<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public LinkedList(){}

    @SafeVarargs
    public LinkedList(T... data){
        for(T x: data) addLast(x);
    }

    public int getSize(){return size;}

    public T getFirst(){return head.data;}

    public T getLast(){return tail.data;}

    public T getData(int index){
        if (index >= size || index < 0) {
            outOfIndexError();
            return null;
        }
        if (index == size - 1) return getLast();
        Node<T> node = head;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node.data;
    }

    public int getIndex(T data){
        Node<T> node = head;
        for (int i = 0; i < size; i++){
            if (node.data == data) return i;
            node = node.next;
        }
        missingDataError();
        return -1;
    }

    public void addFirst(T data){
        Node<T> node = new Node<>(data);
        if(tail == null) tail = node;
        else node.next = head;
        head = node;
        size++;
    }

    public void addLast(T data){
        Node<T> node = new Node<>(data);
        if(head == null) head = node;
        else tail.next = node;
        tail = node;
        size++;
    }

    public void insertBefore(T data, int index) {
        if (index == 0) addFirst(data);
        else insertAfter(data, index - 1);
    }

    public void insertAfter(T data, int index) {
        if (index >= size || index < 0) {
            outOfIndexError();
            return;
        }
        if(index == size - 1){
            addLast(data);
            return;
        }
        Node<T> node = new Node<>(data);
        Node<T> prev = head;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node<T> next = prev.next;
        prev.next = node;
        node.next = next;
        size++;
    }

    public void edit(T data, int index) {
        if (index >= size || index < 0) {
            outOfIndexError();
            return;
        }
        if(index == size - 1){
            tail.data = data;
            return;
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++)
            node = node.next;
        node.data = data;
    }

    public void removeFirst(){removeByIndex(0);}

    public void removeLast(){removeByIndex(size - 1);}

    public void removeByIndex(int index) {
        if (index >= size || index < 0) {
            outOfIndexError();
            return;
        }
        if (index == 0) head = head.next;
        else{
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            Node<T> node = prev.next;
            if (index == size - 1) tail = prev;
            prev.next = node.next;
        }
        size--;
    }

    public void removeByData(T data) {
        Node<T> node = head, prev = null;
        for (int i = 0; i < size; i++){
            if(node.data == data){
                if (i == 0) head = head.next;
                else{
                    if(i == size - 1) tail = prev;
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
        missingDataError();
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        Node<T> node = head;
        for (int i = 0; i < size; i++){
            arr[i] = node.data;
            node = node.next;
        }
        return arr;
    }

    public LinkedList<T> copy(){
        return new LinkedList<>(toArray());
    }

    public void merge(LinkedList<T> B){
        tail.next = B.head;
        size += B.size;
    }

    public LinkedList<T> mergeCopy(LinkedList<T> A, LinkedList<T> B){
        LinkedList<T> A_copy = A.copy();
        LinkedList<T> B_copy = B.copy();
        A_copy.tail.next = B_copy.head;
        A_copy.size += B_copy.size;
        return A_copy;
    }

    public void cut(int start, int end){
        if (start >= size || start < 0 ||
        end >= size || end < 0 || end < start) {
            outOfIndexError();
            return;
        }
        Node<T> node = head;
        for (int i = 0; i < start; i++)
            node = node.next;
        head = node;
        for (int i = 0; i < end - start; i++)
            node = node.next;
        tail = node;
        tail.next = null;
        size = end - start + 1;
    }

    public LinkedList<T> cutCopy(int start, int end){
        LinkedList<T> list = copy();
        list.cut(start,end);
        return list;
    }

    public String toString() {
        Node<T> node = head;
        StringBuilder s = new StringBuilder("[ ");
        for (int i = 0; i < size; i++){
            s.append(node.data);
            if(i < size - 1) s.append(", ");
            node = node.next;
        }
        return s.toString();
    }

    private void outOfIndexError() {
        System.out.println("\nThe index is not in the list");
    }

    private void missingDataError() {
        System.out.println("\nCan't find an item with this data");
    }
}
