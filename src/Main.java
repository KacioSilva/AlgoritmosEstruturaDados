public class Main {
    public static void main(String[] args) {
        tabelaHash hashTable = new tabelaHash();
        hashTable.adicionar("Elemento 1", "A");
        hashTable.adicionar("Elemento 2", "B");
        hashTable.adicionar("Elemento 3", "C");
        hashTable.adicionar("Elemento 4", "D");

        System.out.println(hashTable.get("Elemento 4"));
        System.out.println(hashTable.get("Elemento 3"));
        System.out.println(hashTable.get("Elemento 2"));
        System.out.println(hashTable.get("Elemento 1"));

    }
}
