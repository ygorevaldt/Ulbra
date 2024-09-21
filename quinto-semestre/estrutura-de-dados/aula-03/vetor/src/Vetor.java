public class Vetor {
    private int count = 0;
    private int size;
    private String[] items;

    public Vetor(int size) {
        this.size = size;
        this.items = new String[this.size];
    }

    // Ex: 01
    // Adicionar elemento ao final: Adicione um elemento na primeira posição livre
    // ao final do vetor.
    public void add(String item) {
        boolean isArrayFull = this.count == this.size;

        if (isArrayFull) {
            System.out.println("Array full");
            return;
        }

        for (int i = 0; i < this.getLastIndex(); i++) {
            boolean isPositionBusy = this.items[i] != null;
            if (isPositionBusy)
                continue;

            this.items[i] = item;
            this.count++;

            break;
        }
    }

    // Ex: 02
    // Adicionar elemento em uma posição específica: Insira um elemento em uma
    // posição específica, deslocando os elementos subsequentes para a direita.
    public void add(int index, String item) {
        if (this.count == this.size) {
            System.out.println("Array full");
            return;
        }

        if (index == this.getLastIndex()) {
            this.items[index] = item;
            return;
        }

        String aux;
        for (int y = index; y < this.getLastIndex(); y++) {
            aux = this.items[y];
            this.items[y] = item;
            this.items[y + 1] = aux;
        }
    }

    // Ex: 03
    // Obter elemento de uma posição: Retorne o valor do elemento armazenado em uma
    // determinada posição.
    public String get(int index) {
        if (this.getLastIndex() < index || index < 0)
            return null;

        return this.items[index];
    }

    // Ex: 04
    // Alterar elemento de uma posição: Altere o valor do elemento armazenado em uma
    // determinada posição.
    public void set(int index, String item) {
        this.items[index] = item;
    }

    // Ex: 05
    // Aumentar a capacidade: Aumente a capacidade do Vetor quando estiver cheio.
    public void resize(int size) {
        String[] newArray = new String[size];

        for (int i = 0; i < this.getLastIndex(); i++) {
            newArray[i] = this.items[i];
        }

        this.items = newArray;
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

        if (this.items[index] == null) {
            System.out.println(String.format("Element of index '%d' is null", index));
            return;
        }

        String[] newArray = new String[this.size];
        this.items[index] = null;
        this.count--;

        for (int i = 0; i <= this.getLastIndex(); i++) {
            if (this.items[i] == null)
                continue;

            for (int y = 0; y < newArray.length; y++) {
                newArray[y] = this.items[i];
            }
        }

        this.items = newArray;
    }

    // Ex: 07
    // Remover elemento pelo valor: Encontre e remova a primeira ocorrência de um
    // valor específico no vetor.
    public void remove(String item) {
        for (int i = 0; i <= this.getLastIndex(); i++) {
            if (!this.items[i].equals(item))
                continue;
            this.items[i] = null;
            break;
        }

        this.count--;
    }

    // Ex: 08
    // Verificar se um elemento existe: Verifique se um determinado valor está
    // presente no vetor.
    public boolean contains(String item) {
        boolean result = false;

        for (String currentItem : this.items) {
            if (currentItem != item)
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
        this.items = new String[this.size];
        this.count = 0;
    }

    // Ex: 12
    // Listar Elementos: Reescreva o método toString() para listar todos os
    // elementos contidos no vetor
    @Override
    public String toString() {
        String items = "[";
        for (int i = 0; i <= this.getLastIndex(); i++) {
            if (i != getLastIndex()) {
                items += this.items[i] + ",";
                continue;
            }

            items += this.items[i] + "]";
        }

        return items;
    }

    public String[] getAll() {
        return this.items;
    }

    private int getLastIndex() {
        return this.size - 1;
    }

}
