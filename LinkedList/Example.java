public class Example {
    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>("abdo", "ahmed", "kamel");
        System.out.println(list1);

        list1.insertAfter("essam", 1);
        list1.addLast("ali");
        list1.addFirst("medhat");
        System.out.println(list1 + " , size = " + list1.getSize());

        list1.removeFirst();
        list1.removeFirst();
        list1.removeLast();
        System.out.println(list1);

        LinkedList<String> list2 = new LinkedList<>("apple", "banana", "orange");
        list1.merge(list2);
        System.out.println(list1);

        list2 = list1.cutCopy(1,4);
        System.out.println(list2.toString());

        list2.removeByData("banana");
        list2.removeByIndex(1);
        System.out.println(list2);

        String[] s = list2.toArray(new String[0]);
        System.out.println(s[1]);
    }
}
