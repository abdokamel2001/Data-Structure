public class LinkedQueueEx {
    public static void main(String[] args) {
        LinkedQueue<Integer> q1 = new LinkedQueue<>(1,3,6,7,9);
        q1.dequeue();
        q1.dequeue();
        System.out.println(q1);
        q1.enqueue(5);
        System.out.println(q1 + " , size = " + q1.getSize());
        System.out.println("Removing : " + q1.dequeue());
        System.out.println("Removing : " + q1.dequeue());
        System.out.println("Removing : " + q1.dequeue());
        System.out.println("Removing : " + q1.dequeue());
        System.out.println("Removing : " + q1.dequeue());
    }
}
