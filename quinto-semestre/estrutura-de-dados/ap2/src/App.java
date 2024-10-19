import java.util.Scanner;

import ex01.CancelledOrdersStack;
import ex01.Order;
import ex01.PendingOrderList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("*-*-*-* AP2 *-*-*-*");

        Scanner scanner = new Scanner(System.in);
        PendingOrderList pendingOrders = new PendingOrderList();
        CancelledOrdersStack cancelledOrders = new CancelledOrdersStack();

        int action = 0;
        String orders;

        System.out.println("\nExercício 01");
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
                    if (pendingOrders.getSize() == 0) {
                        System.out.println("Não há pedidos pendentes");
                        break;
                    }

                    Order order = pendingOrders.dequeue();
                    System.out.println("\nPedido atendido: " + order);
                    break;

                case 3:
                    Order oldOrder = pendingOrders.dequeue();
                    cancelledOrders.push(oldOrder);

                    System.out.println("Pedido cancelado: " + oldOrder);
                    break;

                case 4:
                    if (cancelledOrders.getSize() == 0) {
                        System.out.println("Não há pedidos cancelados para restaurar");
                        break;
                    }
                    Order orderRestored = cancelledOrders.pop();
                    pendingOrders.enqueue(orderRestored);

                    System.out.println("Pedido restaurado: " + orderRestored);
                    break;

                case 5:
                    System.out.println("\nListando pedidos pendentes");
                    orders = pendingOrders.printQueue();

                    if (orders.length() == 0) {
                        System.out.println("Não há pedidos pendentes");
                        break;
                    }

                    System.out.println(orders);
                    break;

                case 6:
                    System.out.println("\nListando pedidos cancelados");
                    orders = cancelledOrders.printStack();

                    if (orders.length() == 0) {
                        System.out.println("Não há pedidos cancelados");
                        break;
                    }

                    System.out.println(orders);
                    break;

                default:
                    action = 7;
                    break;
            }

        } while (action != 7);

        System.out.println("\nExercício 02");

    }
}
