public class LinkedStack <T> {

    private final LinkedList<T> list = new LinkedList<>();

    public LinkedStack(){}

    @SafeVarargs
    public LinkedStack(T... items){
        for(T x: items) list.addFirst(x);
    }

    public int getSize(){return list.getSize();}

    public boolean isEmpty(){return list.getSize() == 0;}

    public T peek(){
        if(isEmpty()) {emptyError(); return null;}
        return list.getFirst();
    }

    public T pop(){
        if(isEmpty()) {emptyError(); return null;}
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public void push(T item){list.addFirst(item);}

    public LinkedList<T> getStack(){return list;}

    public String toString(){return list.toString();}

    public <E> E[] toArray(E[] a) { return list.toArray(a);}

    private void emptyError() {
        System.out.println("The queue is empty");
    }
}
