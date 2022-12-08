public class Example {
    public static void main(String[] args) {
        Queue<String> q1 = new Queue<>(3);
        q1.enqueue("abdo");
        q1.enqueue("ahmed");
        q1.enqueue("kamel");
        q1.enqueue("apple");
        System.out.println(q1);
        System.out.println("Removing : " + q1.dequeue());
        System.out.println("Removing : " + q1.dequeue());
        System.out.println("Removing : " + q1.dequeue());
        System.out.println("Removing : " + q1.dequeue());
    }
}
