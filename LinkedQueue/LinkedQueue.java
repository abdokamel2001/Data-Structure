public class LinkedQueue <T> {

    private final LinkedList<T> list = new LinkedList<>();

    public LinkedQueue(){}

    @SafeVarargs
    public LinkedQueue(T... items){
        for(T x: items) list.addLast(x);
    }

    public int getSize(){return list.getSize();}

    public boolean isEmpty(){return list.getSize() == 0;}

    public T peek(){
        if(isEmpty()) {emptyError(); return null;}
        return list.getFirst();
    }

    public T dequeue(){
        if(isEmpty()) {emptyError(); return null;}
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public void enqueue(T item){list.addLast(item);}

    public LinkedList<T> getQueue(){return list;}

    public String toString(){return list.toString();}

    public <E> E[] toArray(E[] a) { return list.toArray(a);}

    private void emptyError() {
        System.out.println("The queue is empty");
    }
}
