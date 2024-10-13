public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("TDE aula 11");

        LinkedList<Integer> linkedList = new LinkedList<>();

        // Teste de inserção
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        System.out.println("Lista após inserção no fim: " + linkedList);

        // Inserir no início
        linkedList.insertAtStart(0);
        System.out.println("Lista após inserção no início: " + linkedList);

        // Inserir por posição
        linkedList.insertAtPosition(10, 3);
        System.out.println("Lista após inserção por posição: " + linkedList);

        // Buscar por posição
        System.out.println("Valor na posição 3: " + linkedList.getByPosition(3));

        // Buscar posição por valor
        System.out.println("Posição do valor 4: " + linkedList.getPositionByValue(4));

        // Atualizar valor
        linkedList.updateValue(10, 15);
        System.out.println("Lista após atualização de valor: " + linkedList);

        // Remover do início
        linkedList.removeAtStart();
        System.out.println("Lista após remover do início: " + linkedList);

        // Remover do fim
        linkedList.removeAtEnd();
        System.out.println("Lista após remover do fim: " + linkedList);

        // Remover por posição
        linkedList.removeByPosition(2);
        System.out.println("Lista após remover por posição: " + linkedList);

        // Limpar lista
        linkedList.clear();
        System.out.println("Lista após limpar: " + linkedList);
    }
}
