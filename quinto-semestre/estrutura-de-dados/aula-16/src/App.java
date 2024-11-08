import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1,5,2,3,8,7,10));

        BinaryTree tree = new BinaryTree(null);

        System.out.println("Inserindo valores: [1,5,2,3,8]");
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("\nRemoção: 3");
        tree.remove(3);
        tree.printInOrder();

        System.out.println("Busca");
        System.out.println("O valor '1' existe na árvore? " + tree.fetch(1));

        System.out.println("\nPré-Ordem");
        tree.printInPreOrder();

        System.out.println("\nPós-Ordem");
        tree.printInPosOrder();

        System.out.println("\nAltura");
        System.out.println(tree.getHeight());

        System.out.println("\nTotal de nós");
        System.out.println(tree.getNodesAmount());

        System.out.println("\nTotal de folhas");
        System.out.println(tree.getLeavesAmount());

        System.out.println("\nProfundidade de '7'");
        System.out.println(tree.getDepth(7));

    }
}
