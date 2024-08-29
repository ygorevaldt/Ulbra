public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Semipresencial");

        VetorClient vetorClient = new VetorClient(20);

        for (int i = 0; i < 30; i++) {
            Client client = new Client("Cliente" + i, "51233334444", "cliente" + 1 + "@gmail.com");

            if (i > 10)
                client.setEmail("client" + i + "@outlook.com");

            vetorClient.add(client);
        }

        System.out.println("\n Clientes filtrados por nome");
        Client[] clientsFiltredByName = vetorClient.findBy("Cliente1");
        for (Client client : clientsFiltredByName) {
            System.out.println(client);
        }

        System.out.println("\n Clientes filtrados por provedor de E-mail");
        Client[] clientsFiltredByEmailProvider = vetorClient.findByEmailProvider("gmail");
        for (Client client : clientsFiltredByEmailProvider) {
            System.out.println(client);
        }

        System.out.println("\nInserção de cliente em posição específica do vetor");
        vetorClient.set(0, new Client("Novo Cliente", "51988887777", "novo_cliente@gmail.com"));

        System.out.println("\nExclusão de cliente em posição específica do vetor");
        vetorClient.remove(19);

        System.out.println("\nAlteração de cliente em uma posição específica do vetor");
        vetorClient.get(1).setName("Cliente002");

        System.out.println("\nClientes armazenados no vetor de clientes");
        for (Client client : vetorClient.getAll()) {
            System.out.println(client);
        }

    }
}
