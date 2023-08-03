package Tabela_Hash;

public class tabelaHash {
    private tabelaHashEntry[] vetor;
    private int tableSize = 10;
    private int size;

    public tabelaHash(){
        this.vetor = new tabelaHashEntry[tableSize];
        this.size = 0;
    }
    public void adicionar(String key, String valor){
        int index = defineIndex(key);
        if(this.vetor[index] == null){
            this.vetor[index] = new tabelaHashEntry(key, valor);
            if(size/tableSize > 0.5){
                reHash();
            }
        }else{
            this.vetor[index].setValue(valor);
        }
    }
    public String get(String key){
        int index = defineIndex(key);
        return this.vetor[index] == null ? null : vetor[index].getValue();
    }

    private void reHash(){
        tabelaHashEntry[] newVetor = this.vetor;
        int newTableSize = this.tableSize * 2;

        this.vetor = new tabelaHashEntry[newTableSize];
        this.tableSize = newTableSize;

        for(tabelaHashEntry entry : newVetor){
            adicionar(entry.getKey(), entry.getValue());
        }
    }

    private int defineIndex(String key){
        int hasCode = key.hashCode() < 0 ? key.hashCode() * (-1) : key.hashCode();
        int index = hasCode % tableSize;

        while (this.vetor[index] != null  && this.vetor[index].getKey() != key){
            if(index >= this.vetor.length -1){
                index = 0;
            }else{
                size++;
            }
        }return index;
    }
   public class tabelaHashEntry{
       private String key;
       private String value;

       public tabelaHashEntry(String key, String value){
           this.key = key;
           this.value = value;
       }

       public String getKey() {
           return key;
       }

       public void setKey(String key) {
           this.key = key;
       }

       public String getValue() {
           return value;
       }

       public void setValue(String value) {
           this.value = value;
       }
   }

    public static void main(String[] args) {
        Tabela_Hash.tabelaHash hashTable = new Tabela_Hash.tabelaHash();
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
