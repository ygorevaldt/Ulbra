public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nVetor");

        Vetor vetor = new Vetor(3);

        // Ex: 01
        vetor.add("Item 0");
        vetor.add("Item 2");

        // Ex: 02
        vetor.add(1, "Item 1");

        // Ex: 03
        System.out.println(String.format("\nExercicio 03: %s", vetor.get(1)));

        // Ex: 04
        vetor.set(0, "Item 0 changed");

        // Ex: 05
        vetor.resize(5);

        // Ex: 06 RETORNAR AQUI DEPOIS
        // vetor.remove(0);

        // Ex: 07
        vetor.remove("Item 0 changed");

        // Ex: 08
        boolean result1 = vetor.contains("Item 0");
        boolean result2 = vetor.contains("Item 1");
        System.out.println(String.format("\nEx %d:\nContêm 'Item 0'? %b\nContêm 'Item 1': %b", 8, result1, result2));

        // Ex: 09
        System.out.println(String.format("\nEx 09: %d", vetor.quantityStored()));

        // Ex: 10
        System.out.println(String.format("\nEx 10: %b", vetor.isEmpty()));

        // Ex: 11
        vetor.removeAll();

        // Ex: 12
        System.out.println(String.format("\nEx 12: %s", vetor));
    }
}
