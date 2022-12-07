public class StackEx {
    public static void main(String[] args) {
        Stack<Boolean> s1 = new Stack<>(5);
        s1.push(Boolean.TRUE);
        s1.push(false);
        s1.push(Boolean.FALSE);
        s1.push(true);
        System.out.println(s1);
        System.out.println("Removing : " + s1.pop());
        System.out.println("Removing : " + s1.pop());
        System.out.println("Removing : " + s1.pop());
        System.out.println("Removing : " + s1.pop());
    }
}
