public class Stack <T> {

    private final T[] arr;
    private int top;
    private final int max;

    @SuppressWarnings("unchecked")
    public Stack(int max) {
        arr = (T[]) new Object[max];
        this.max = max;
        top = 0;
    }

    public  int getSize(){return top;}

    public boolean isEmpty(){return top == 0;}

    public boolean isFull(){return top == max;}

    public T peek(){
        if(isEmpty()) {emptyError(); return null;}
        return arr[top - 1];
    }

    public T pop(){
        if(isEmpty()) {emptyError(); return null;}
        return arr[--top];
    }

    public void push(T item){
        if(isFull()) {fullError(); return;}
        arr[top++] = item;
    }

    @SuppressWarnings("unchecked")
    public T[] getStack(){
        T[] arr = (T[]) new Object[top];
        for (int i = 0; i < top; i++)
            arr[i] = this.arr[top - 1 - i];
        return arr;
    }

    public String toString(){
        StringBuilder s = new StringBuilder("[");
        for (int i = top; i > 0; i--){
            s.append(arr[i - 1]);
            if(i > 1) s.append(", ");
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
