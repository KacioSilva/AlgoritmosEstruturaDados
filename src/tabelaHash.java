public class tabelaHash {
    int size;
    int tableSize = 10;
    HashTableEntry[] vetor;

    public tabelaHash(){
        this.size = 0;
        this.vetor = new HashTableEntry[tableSize];
    }
    public void adicionar(String key, String valor){
        if(this.size / this.tableSize > 0.5){
            reHash();
        }
        int index = defineIndex(key);
        vetor[index] = new HashTableEntry(key, valor);
        size++;
    }

    public void remove(String key){

    }
    public String get(String key){
        return null;
    }
    public int getSize(){
        return this.size;
    }
    private void reHash(){

    }
    private int defineIndex(String key){
        int index = key.hashCode() % this.vetor.length;
        while(this.vetor[index] != null && this.vetor[index].getKey() != key){
            if(index == vetor.length-1){
                index = 0;
            }else{
                index++;
            }
        } return index;
    }

    public class HashTableEntry{
        private String key;
        private String valor;

        public HashTableEntry(String key, String valor){
            super();
            this.key = key;
            this.valor = valor;
        }

        public String getKey(){
            return key;
        }
        public void setKey(String key){
            this.key = key;
        }

        public String getValor(){
            return this.valor;
        }
        public void setValor(String valor){
        }
    }
}
