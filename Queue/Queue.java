public class Queue <T> {

    private final T[] arr;
    private final int max;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue(int max){
        arr = (T[]) new Object[max];
        this.max = max;
        front = 0;
        rear = -1;
        size = 0;
    }

    public  int getSize(){return size;}

    public boolean isEmpty(){return size == 0;}

    public boolean isFull(){return size == max;}

    public T peek(){
        if(isEmpty()) {emptyError(); return null;}
        return arr[front];
    }

    public T dequeue(){
        if(isEmpty()) {emptyError(); return null;}
        T item = arr[front];
        front = ++front % max;
        size--;
        return item;
    }

    public void enqueue(T item){
        if(isFull()) {fullError(); return;}
        rear = ++rear % max;
        arr[rear] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T[] getQueue(){
        if (isEmpty()) {emptyError(); return null;}
        int front = this.front;
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++){
            arr[i] = this.arr[front];
            front = ++front % max;
        }
        return arr;
    }

    public String toString(){
        int front = this.front;
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            s.append(arr[front]);
            if(i < size - 1) s.append(", ");
            front = ++front % max;
        }
        s.append("]");
        return s.toString();
    }

    private void emptyError() {
        System.out.println("The queue is empty");
    }

    private void fullError() {
        System.out.println("The queue is full");
    }
}
