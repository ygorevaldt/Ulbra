import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("*-*-*-* AP2 *-*-*-*\n");

        Scanner scanner = new Scanner(System.in);
        PendingOrderList pendingOrders = new PendingOrderList();
        CancelledOrdersStack cancelledOrders = new CancelledOrdersStack();

        int action = 0;
        String orders;

        do {
            System.out.println("\nDigite a ação desejada\n");
            System.out.println("[1] - Adicionar pedido");
            System.out.println("[2] - Atender pedido");
            System.out.println("[3] - Cancelar pedido");
            System.out.println("[4] - Restaurar pedido");
            System.out.println("[5] - Exibir pedidos pendentes");
            System.out.println("[6] - Exibir pedidos cancelados");
            System.out.println("[7] - Excerrar programa");
            action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    System.out.println("\nDescreva seu pedido:");
                    String description = scanner.nextLine();

                    pendingOrders.enqueue(new Order(description));
                    break;

                case 2:
                    System.out.println("\nPedido atendido: " + pendingOrders.getStart());
                    pendingOrders.dequeue();
                    break;

                case 3:
                    System.out.println("Pedidos pendentes:");
                    orders = pendingOrders.printQueue();
                    System.out.println(orders);

                    System.out.println("Digite o ID do pedido que quer cancelar:");
                    String id = scanner.nextLine();

                    System.out.println("\nPedido cancelado: " + pendingOrders.getById(id));
                    pendingOrders.dequeueBy(id);
                    break;

                case 5:
                    System.out.println("\nListando pedidos");
                    orders = pendingOrders.printQueue();

                    if (orders.length() == 0) {
                        System.out.println("Não há pedidos pendentes");
                        break;
                    }

                    System.out.println(orders);
                    break;

                default:
                    action = 7;
                    break;
            }

        } while (action != 7);
    }
}
