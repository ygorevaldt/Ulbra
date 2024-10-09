public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("TDE aula 11");

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        System.out.println(linkedList);

        linkedList.removeByValue(3);

        System.out.println(linkedList);
    }
}
