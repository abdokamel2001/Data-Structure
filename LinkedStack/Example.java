public class LinkedStackEx {
    public static void main(String[] args) {
        LinkedStack<Double> s1 = new LinkedStack<>(1.,3.,4.,7.5);
        System.out.println(s1);
        double a = s1.pop();
        double b = s1.pop();
        System.out.println(s1);
        s1.push(a/b);
        System.out.println(s1);
        System.out.println("Removing : " + s1.pop());
        System.out.println("Removing : " + s1.pop());
        System.out.println("Removing : " + s1.pop());
        System.out.println("Removing : " + s1.pop());
    }
}
