public class VetorClient {
    private int size;
    private int count = 0;
    private Client[] clients;

    public VetorClient(int size) {
        this.size = size;
        this.clients = new Client[this.size];
    }

    // Ex: 01
    // Adicionar elemento ao final: Adicione um elemento na primeira posição livre
    // ao final do vetor.
    public void add(Client client) {
        if (this.count == this.size) {
            System.out.println("Array full");
            return;
        }

        for (int i = 0; i <= this.getLastIndex(); i++) {
            if (this.clients[i] != null)
                continue;

            this.clients[i] = client;

            this.count++;
            break;
        }
    }

    // Ex: 02
    // Adicionar elemento em uma posição específica: Insira um elemento em uma
    // posição específica, deslocando os elementos subsequentes para a direita.
    public void add(int index, Client client) {
        if (this.count == this.size) {
            System.out.println("Array full");
            return;
        }

        Client aux;
        for (int y = index; y < this.getLastIndex(); y++) {
            aux = this.clients[y];
            this.clients[y] = client;
            this.clients[y + 1] = aux;
        }
    }

    // Ex: 03
    // Obter elemento de uma posição: Retorne o valor do elemento armazenado em uma
    // determinada posição.
    public Client get(int index) {
        if (this.getLastIndex() < index || index < 0)
            return null;

        return this.clients[index];
    }

    // Ex: 04
    // Alterar elemento de uma posição: Altere o valor do elemento armazenado em uma
    // determinada posição.
    public void set(int index, Client client) {
        this.clients[index] = client;
    }

    // Ex: 05
    // Aumentar a capacidade: Aumente a capacidade do Vetor quando estiver cheio.
    public void resize(int size) {
        Client[] newArray = new Client[size];

        for (int i = 0; i < this.getLastIndex(); i++) {
            newArray[i] = this.clients[i];
        }

        this.clients = newArray;
        this.size = size;
    }

    // Ex: 06
    // Remover elemento pelo índice: Remova o elemento na posição especificada,
    // reorganizando os elementos restantes para preencher a lacuna.
    public void remove(int index) {
        if (index > this.getLastIndex()) {
            System.out.println(String.format("Index '%d' is not exists", index));
            return;
        }

        if (this.clients[index] == null) {
            System.out.println(String.format("Element of index '%d' is null", index));
            return;
        }

        Client[] newArray = new Client[this.size];
        this.clients[index] = null;
        this.count--;

        int y = 0;
        for (int i = 0; i <= this.getLastIndex(); i++) {
            if (this.clients[i] != null) {
                newArray[y] = this.clients[i];
                y++;
            }
        }

        this.clients = newArray;
    }

    // Ex: 07
    // Remover elemento pelo valor: Encontre e remova a primeira ocorrência de um
    // valor específico no vetor.
    public void remove(Client client) {
        for (int i = 0; i <= this.getLastIndex(); i++) {
            if (!this.clients[i].equals(client))
                continue;
            this.clients[i] = null;
            break;
        }

        this.count--;
    }

    // Ex: 08
    // Verificar se um elemento existe: Verifique se um determinado valor está
    // presente no vetor.
    public boolean contains(Client client) {
        boolean result = false;

        for (Client currentClient : this.clients) {
            if (!currentClient.equals(client))
                continue;

            result = true;
            break;
        }

        return result;
    }

    // Ex: 09
    // Obter tamanho atual do vetor: Retorne o número de elementos atualmente
    // armazenados no vetor.
    public int quantityStored() {
        return this.count;
    }

    // Ex: 10
    // Verificar se o vetor está vazio: Indique se o vetor está vazio (ou seja, sem
    // nenhum elemento armazenado).
    public boolean isEmpty() {
        return this.count == 0 ? true : false;
    }

    // Ex: 11
    // Limpar: Remova todos os elementos do vetor, tornando-o vazio.
    public void removeAll() {
        this.clients = new Client[this.size];
        this.count = 0;
    }

    // Ex: 12
    // Listar Elementos: Reescreva o método toString() para listar todos os
    // elementos contidos no vetor
    @Override
    public String toString() {
        String clients = "[";
        for (int i = 0; i <= this.getLastIndex(); i++) {
            if (i != getLastIndex()) {
                clients += this.clients[i] + ",";
                continue;
            }

            clients += this.clients[i] + "]";
        }

        return clients;
    }

    public Client[] getAll() {
        return this.clients;
    }

    public Client[] findBy(String name) {
        int count = 0;
        for (Client client : this.clients) {
            if (client == null)
                continue;

            if (!(client.getName().equals(name)))
                continue;

            count++;
        }

        Client[] clientsFiltredByName = new Client[count];
        int index = 0;

        for (Client client : this.clients) {
            if (client != null && client.getName().equals(name)) {
                clientsFiltredByName[index] = client;
                index++;
            }
        }

        return clientsFiltredByName;
    }

    public Client[] findByEmailProvider(String emailProvider) {
        int count = 0;

        for (Client client : this.clients) {

            String provider = this.getEmailProvider(client);
            if (!provider.equals(emailProvider))
                continue;

            count++;
        }

        Client[] filtredByEmailProvider = new Client[count];

        int index = 0;
        for (Client client : this.clients) {
            String provider = this.getEmailProvider(client);
            if (!provider.equals(emailProvider))
                continue;

            filtredByEmailProvider[index] = client;
            index++;
        }

        return filtredByEmailProvider;
    }

    private String getEmailProvider(Client client) {
        if (client == null)
            return null;

        int atIndex = client.getEmail().indexOf('@');
        int dotIndex = client.getEmail().indexOf('.');

        if (dotIndex == 0 || atIndex == 0)
            return null;

        return client.getEmail().substring(atIndex + 1, dotIndex);
    }

    private int getLastIndex() {
        return this.size - 1;
    }

}
